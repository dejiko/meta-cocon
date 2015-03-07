#!/bin/sh

DEFCONF="/usr/share/cocon/default.cnf"
SECCONF="/mnt/union/mnt/realroot/cocon.cnf"
SECCONF_EXTREME="/cocon.cnf"
CONF_MOUNT="/mnt/cfg"
CNFFILE="/tmp/.cocon.cnf"
DISKSTATS_TMP="/var/volatile/tmp/.cocon.diskstats"
CNF_NM_FILE_MOVETO="/tmp/.cocon.cnf.files/nm/"
COPYTORAM_AFTER_INITRD="/mnt/oldroot/mnt/copytoram"

read_args() {
    [ -z "$CMDLINE" ] && CMDLINE=`cat /proc/cmdline`
    for arg in $CMDLINE; do
        optarg=`expr "x$arg" : 'x[^=]*=\(.*\)'`
        case $arg in
            debug) set -x
                COCON_DEBUG=1
                export COCON_DEBUG
                echo "COCON_DEBUG=1"  >> $CNFFILE
                ;;
            forcefb1|forcefb2|forcefb3|forcefb)
                echo "COCON_FORCEFB=1"  >> $CNFFILE
                ;;
            forcesvga)
                echo "COCON_FORCESVGA=1" >> $CNFFILE
                ;;
        esac
    done
}

get_partition_type()
{
    fstype=`blkid /dev/$dev`
    fstype=`expr "$fstype" : '.*TYPE="\([A-Za-z0-9]*\)".*'`
}


scan_cocon_setting()
{
  # Scan all available device/partitions
  cat /proc/diskstats > $DISKSTATS_TMP

  if [ "$ROOT_DEVICE" ];
  then
    # Exclude Boot device (because already loaded)
    # sed "/`basename $ROOT_DEVICE`/d" $DISKSTATS_TMP > /tmp/.cocon.scan
    # echo "Exclude: $ROOT_DEVICE"
    rootdv=`basename $ROOT_DEVICE`
  fi

  while read maj min dev ex1 ex2 ex3 ex4 ex5 ex6 ex7 ex8 ex9 ex10 ex11; do

    # echo "Searching: $dev"

    # Exclude ram and loop device
    if [ "`echo $arg | grep 'loop\|ram'`" ];
    then
      continue;
    fi

    if [ "$ROOT_DEVICE" = "/dev/$dev" -a "$COCON_COPYTORAM" = "1" ];
    then
      # This is booted CD drive (or USB Stick).
      # after Copy-to-RAM, mount this drive then close CD tray.
      # then ignore this drive.
      # Instead, copyed config file may store on (initrd)/mnt/copytoram.

      if [ -d "$COPYTORAM_AFTER_INITRD" ];
      then
        scan_cocon_userconfig $COPYTORAM_AFTER_INITRD
      fi
      continue;
    fi

    get_partition_type

    if [ "$fstype" = "iso9660" -o "$fstype" = "vfat" -o "$fstype" = "ext3" -o "$fstype" = "ntfs" -o  "$fstype" = "ext4" ];
    then
      mount -o ro /dev/$dev $CONF_MOUNT
      scan_cocon_userconfig $CONF_MOUNT
      sync
      umount /dev/$dev
    fi
  done < $DISKSTATS_TMP
}


# Scan $1 folder and place cocon.cnf, coconfrm, coconnm.
scan_cocon_userconfig()
{
  ALLOW_LOAD_FIRMWARE_B43="wl_apsta-3.130.20.0.o\|wl_apsta.o"
  ALLOW_LOAD_FIRMWARE_IPW2X00="ipw2100-1.3-i.fw\|ipw2100-1.3-p.fw\|ipw2100-1.3.fw\|ipw2200-bss.fw\|ipw2200-ibss.fw\|ipw2200-sniffer.fw"
  ALLOW_LOAD_FIRMWARE_P54="isl3886pci\|isl3886usb\|isl3887usb"

  userconfig_scanpath="$1"
  echo "user config scan -> $userconfig_scanpath"

  # cocon.cnf and related files
  if [ -r $userconfig_scanpath/cocon.cnf ];
  then
    echo  " --> cocon.cnf found"
    cocon-read-cnf $userconfig_scanpath/cocon.cnf >> $CNFFILE
  fi

  # Non-redistributable Firmwares
  if [ -d $userconfig_scanpath/coconfrm ];
  then
    echo "--> firmware directory found"
    for frm in `ls -1 $userconfig_scanpath/coconfrm`; do
      if expr "$frm" : "$ALLOW_LOAD_FIRMWARE_B43" > /dev/null ;
      then
        # Broadcom is big firmware file, so cut now.
        b43-fwcutter -w /lib/firmware $userconfig_scanpath/coconfrm/$frm
        continue;
      fi

      if expr "$frm" : "$ALLOW_LOAD_FIRMWARE_IPW2X00\|$ALLOW_LOAD_FIRMWARE_P54" > /dev/null ;
      then
        # Just copy
        cp $userconfig_scanpath/coconfrm/$frm /lib/firmware
        continue;
      fi
    done
          
  fi

  # NetworkManager Settings
  if [ -d $userconfig_scanpath/coconnm ];
  then
    mkdir -p $CNF_NM_FILE_MOVETO
    echo "--> NetworkManager setting directory found"
    for nm in `ls -1 $userconfig_scanpath/coconnm`; do
      if [ -z ` cat $nm | grep '\#\!\/' ` ];
      then
        # TODO : more more inf file check
        cp $CONF_MOUNT/coconnm/$nm $CNF_NM_FILE_MOVETO
        chmod 600 $CNF_NM_FILE_MOVETO/$nm
      fi
    done
  fi
}


read_args


# mount missing /dev/pts
if [ ! -d /dev/pts ];
then
  mkdir /dev/pts
fi
mount -t devpts -o mode=0620,gid=5 none /dev/pts

# mount missing volatile
#mount -t tmpfs none /var/volatile
#mkdir /var/volatile/tmp
if [ ! -d /var/volatile/log ];
then
  mkdir -p /var/volatile/log
fi

# TODO : create on base-files.
mkdir /var/volatile/run
mkdir /var/volatile/lock


# workaround : force depmod
#depmod -a


if [ -z "$BOOT_FS" ];
then
  # If extreme mode, start udev.
  mount -t devtmpfs devtmpfs /dev
fi

  # Run udev daemon (TODO : is this safe?)
/etc/init.d/udev restart

#else
  # Scan again
#  udevadm trigger --action=add
#  udevadm settle
#fi


if [ "$COCON_DEBUG" = "1" ];
then
  echo "DEBUG: after udev."
  /bin/sh
fi

# zram
COCON_MEM_MB=`free -m | grep "Mem:" | sed -r "s/Mem://" | sed -r "s/^[[:space:]]*([0-9]+).*/\\1/"`
echo "Memory: $COCON_MEM_MB MB"

if [ "$COCON_MEM_MB" -lt 240 ];
then
  echo $(($COCON_MEM_MB*1048576)) > /sys/block/zram0/disksize
  sleep 2
  mkswap /dev/zram0
  swapon /dev/zram0
fi

if [ "$COCON_DEBUG" = "1" ];
then
  echo "DEBUG: after zram."
  /bin/sh
fi


# Read setting file.
# First : /usr/share/cocon/default.cnf
# Second : /mnt/cf/mnt/realroot/cocon.cnf
# Third : (mounted device except boot device)/cocon.cnf [TODO]
cocon-read-cnf $DEFCONF >> $CNFFILE
if [ -z "$BOOT_FS" ];
then
  if [ -r $SECCONF_EXTREME ];
  then
    cocon-read-cnf $SECCONF_EXTREME >> $CNFFILE
  fi
else
  if [ -r $SECCONF ];
  then
    cocon-read-cnf $SECCONF >> $CNFFILE
  fi
fi

scan_cocon_setting

if [ "$COCON_DEBUG" = "1" ];
then
  echo "DEBUG: after parse config."
  /bin/sh
fi


# After parsing setting file, read .cocon.cnf
if [ -e $CNFFILE ];
then
  . $CNFFILE
fi

# Enable Framebuffer console : needed for i810
if [ -c /dev/fb0 ];
then
  /sbin/modprobe fbcon
fi

# Daemon
mkdir -p /var/run/dbus/
/etc/init.d/dbus-1 start

# NetworkManager IPv6 fix
ln -sf /var/lib/dbus/machine-id /etc/machine-id

/etc/init.d/NetworkManager start


# Volume mute 
#if [ "$COCON_MUTE_MASTER_ON_BOOT" = "1" ];
#then
#  amixer set 'Master' 0%
#fi


# Keymap (TODO)
if [ -z $COCON_KBD_CONSOLE ];
then
  COCON_KBD_CONSOLE="jp106"
fi

/usr/bin/loadkeys $COCON_KBD_CONSOLE

# Timezone (TODO)
ln -sf /usr/share/zoneinfo/Asia/Tokyo /etc/localtime

# If /var/log is not folder, recreate it.
# (only for coconrpi?)
if [ ! -d "/var/log/" ];
then
  rm -rf /var/log/
  mkdir -p /var/log/
fi

# Hostname
hostname tiny$RANDOM

if [ "$COCON_DEBUG" = "1" ];
then
  sleep 4
  echo "Debug : enable dropbear. Please input user password."
  passwd xuser
  dropbearkey -t rsa -f /tmp/.cocon.debugrsa
  dropbear -r /tmp/.cocon.debugrsa -w -K 0
  
  echo "Debug : after setup.sh"
  /bin/sh
fi
