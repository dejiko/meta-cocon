#!/bin/sh

MODULE_DIR=/initrd.d
BOOT_ROOT=
ROOT_DEVICE=
SQSFILE=
FROMISO=

early_setup() {
    mount -t proc proc /proc
    mount -t sysfs sysfs /sys
}

dev_setup()
{
  # TODO : move here (call cocon-udev)
    echo -n "initramfs: Creating device nodes: "
}

read_args() {
    [ -z "$CMDLINE" ] && CMDLINE=`cat /proc/cmdline`
    for arg in $CMDLINE; do
        optarg=`expr "x$arg" : 'x[^=]*=\(.*\)'`
        case $arg in
            root=*)
                ROOT_DEVICE=$optarg ;;
            rootfstype=*)
                ROOT_FSTYPE=$optarg ;;
            sqsfile=*)
		SQSFILE=$optarg
		export SQSFILE
                ;;
            fromiso=*)
                FROMISO=$optarg
                export FROMISO
                ;;
            rootdelay=*)
                rootdelay=$optarg ;;
            debug) set -x
                COCON_DEBUG=1
                export COCON_DEBUG
                ;;
            early) set -x
                COCON_INITRD_DEBUG=1
                export COCON_INITRD_DEBUG
                ;;
            copytoram)
                COCON_COPYTORAM=1
                export COCON_COPYTORAM
                ;;
            noeject)
                COCON_NOEJECT=1
                export COCON_NOEJECT
                ;;
            shell) sh ;;
        esac
    done
}


load_module() {
    # Cannot redir to $CONSOLE here easily - may not be set yet
    echo "initramfs: Loading $module module"
    source $1
}

load_modules() {
    for module in $MODULE_DIR/$1; do
        [ -e "$module"  ] && load_module $module
    done
}

fatal() {
    echo $1 >$CONSOLE
    echo >$CONSOLE
    exec sh
}


echo "Starting opencocon initrd boot..."
early_setup
load_modules '0*'

[ -z "$CONSOLE" ] && CONSOLE="/dev/console"

read_args

if [ -z "$rootdelay" ]; then
    rootdelay="2"
fi
if [ -n "$rootdelay" ]; then
    echo "Waiting $rootdelay seconds for devices to settle..." >$CONSOLE
    sleep $rootdelay
fi

dev_setup

load_modules '[1-9]*'

# [ -n "$BOOT_ROOT" ] && boot_root

fatal "No valid root device was specified.  Please add root=/dev/something to the kernel command-line and try again."
