# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Task for opencocon thinclient on cocon486 machine (without X.org)"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

inherit packagegroup

COMPATIBLE_MACHINE = "ac100"

RDEPENDS_${PN} = " \
base-files \
base-passwd \
busybox \
cocon-data-doc \
dropbear \
e2fsprogs-badblocks \
e2fsprogs-e2fsck \
e2fsprogs-mke2fs \
gnutls \
gnutls-openssl \
kbd \
keymaps \
libgcc \
libgcrypt \
libgpg-error \
openssl \
opkg \
udev \
update-rc.d \
usbutils \
util-linux-cfdisk \
util-linux-fdisk \
wireless-tools \
wpa-supplicant \
"

