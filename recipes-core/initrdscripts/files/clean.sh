#!/bin/sh

MOUNTLOC="/mnt/realroot"
UNIONLOC="/mnt/union"
RAMLOC="/mnt/ram"
OLDLOC="/mnt/oldroot"
NEWLOC="/mnt/newroot"
COPYTORAMLOC="/mnt/copytoram"
ISOLOC="/mnt/iso"
#MODLOC="/mnt/mod"
CNFFILE="/tmp/.cocon.cnf"


# Cleanup scripts for CD-boot.
# To eject CD drive after finish CD Linux session, some cleanup and ummount
# is needed on this part. 

echo "--- reverse pivot ---"
#COCON_CDSHUTDOWN=1

# Read .cocon.cnf
if [ -e $CNFFILE ];
then
  . $CNFFILE
fi

# reverse pivot (to unmount)
pivot_root $OLDLOC $OLDLOC/$NEWLOC

# kill processs
PID="pidof clean"
for pid in `ps | grep -v "PID" | egrep -v "\[.*\]" | grep -F -v mount | sed -r "s/^[[:space:]]*([0-9]+).*/\\1/"`;
do
  declare -i cpid=`$PID`
  if [ $pid -lt $cpid ];
  then
    if [ $pid -ne 1 ];
    then
      LIST="$LIST $pid"
    fi
  fi
done

kill -s TERM $LIST >/dev/null 2>&1
#sleep 2
kill -s KILL $LIST >/dev/null 2>&1
sync

# unmount file system
umount -lf $NEWLOC/proc >/dev/null 2>&1
umount -lf $NEWLOC/sys >/dev/null 2>&1
umount -lf $NEWLOC/tmp >/dev/null 2>&1
umount -lf $NEWLOC/dev/pts >/dev/null 2>&1
umount -lf $NEWLOC/dev >/dev/null 2>&1
umount -lf $NEWLOC >/dev/null 2>&1
umount -lf $RAMLOC >/dev/null 2>&1
umount -lf $UNIONLOC >/dev/null 2>&1
umount -lf $COPYTORAMLOC >/dev/null 2>&1
umount -lf $ISOLOC >/dev/null 2>&1
umount -lf $MOUNTLOC >/dev/null 2>&1
#umount -lf /run >/dev/null 2>&1
#umount -lf $MODLOC >/dev/null 2>&1

# Eject CD drive
if [ $BOOT_FS = "iso9660" -a -z "$COCON_NOEJECT" -a -z "$COCON_COPYTORAM" ];
then 
  #mount -t devtmpfs devtmpfs /dev 
  #mount -t proc none /proc

  echo "--- Eject CD device. ($ROOT_DEVICE) ---"
  echo "Press [Enter] key (or wait 2min) to turn off computer."
  echo "Thank you for using opencocon, kon-kon!"
  fuser -k $ROOT_DEVICE
  sync
  eject.eject -s $ROOT_DEVICE >/dev/null 2>&1
  eject.eject $ROOT_DEVICE >/dev/null 2>&1
  read -t 120
fi

# and Power off
umount -lf /dev >/dev/null 2>&1

