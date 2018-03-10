# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Packagegroup for opencocon project (common, without X)"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

inherit packagegroup


RDEPENDS_${PN} = " \
ntpdate \
python-core \
python-io \
python-shell \
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
