# initramfs image with interactive boot menu allowing to select rootfs location
# from choices of block devices, loopback images and NFS.

LICENSE = "MIT"
#LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

IMAGE_NAME = "${DISTRO_NAME}-${DISTRO_VERSION}-${MACHINE}-crusoe-initramfs"

IMAGE_INSTALL = " \
base-files \
base-passwd \
busybox \
initramfs-uniboot \
initramfs-module-bootmenu-crusoe \
udev \
"

IMAGE_LINGUAS = ""

BAD_RECOMMENDATIONS += "busybox-syslog"

IMAGE_FSTYPES += " squashfs "

inherit image
