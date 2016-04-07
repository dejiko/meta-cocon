#!/bin/sh

DEFCONF="/usr/share/cocon/default.cnf"
SECCONF="/mnt/union/mnt/realroot/cocon.cnf"
SECCONF_EXTREME="/cocon.cnf"
CONF_MOUNT="/mnt/cfg"
CNFFILE="/tmp/.cocon.cnf"
CNFFILE_BOOTDRIVE="/tmp/.cocon.cnf.bootdrive"
DISKSTATS_TMP="/var/volatile/tmp/.cocon.diskstats"
CNF_NM_FILE_MOVETO="/tmp/.cocon.cnf.files/nm/"
CNF_NM_FILE_MOVETO_BOOTDRIVE="/tmp/.cocon.cnf.files/nm.bootdrive/"
COPYTORAM_AFTER_INITRD="/mnt/oldroot/mnt/copytoram"
CNF_LOGFILE="/var/log/cocon-cnf.log"

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
            dropbear)
                COCON_DROPBEAR=1
                export COCON_DROPBEAR
                echo "COCON_DROPBEAR=1"  >> $CNFFILE
                ;;
            stopbeforex)
                COCON_XDEBUG=1
                export COCON_XDEBUG
                echo "COCON_XDEBUG=1"  >> $CNFFILE
                ;;
            delayreadcfg)
                COCON_DELAY_CFG=1
                export COCON_DELAY_CFG
                echo "COCON_DELAY_CFG=1"  >> $CNFFILE
                ;;
        esac
    done
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

if [ "$COCON_DEBUG" = "1" ];
then
  echo "DEBUG: before udev."
  /bin/sh
fi

# spmachine-early
cocon-spmachine-early

# Run udev daemon (TODO : is this safe?)
/etc/init.d/udev restart

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


# Delay read cocon.cnf?
if [ "$COCON_DELAY_CFG" = "1" ];
then
  sleep 10
fi

# Read setting file.
/etc/init.d/scan-cnf-from-storage start



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

if [ "$COCON_DROPBEAR" = "1" ];
then
  echo "Debug : enable dropbear. Please input user password."
  passwd xuser
  dropbearkey -t rsa -f /tmp/.cocon.debugrsa
  dropbear -r /tmp/.cocon.debugrsa -w -K 0
fi 

if [ "$COCON_DEBUG" = "1" ];
then
  echo "Debug : after setup.sh"
  /bin/sh
fi
