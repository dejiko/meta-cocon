# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Packagegroup for opencocon project (common, without X)"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit packagegroup


RDEPENDS_${PN} = " \
ntpdate \
sudo \
tzdata \
base-files \
base-passwd \
busybox \
e2fsprogs-badblocks \
e2fsprogs-e2fsck \
e2fsprogs-mke2fs \
gnutls \
gnutls-openssl \
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
nss \
networkmanager \
iproute2 \
eject \
consolekit \
"
