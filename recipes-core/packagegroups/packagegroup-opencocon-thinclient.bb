# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Packagegroup for opencocon thinclient desktop environment"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit packagegroup

RDEPENDS_${PN} = " \
celt \
cocon-data \
cocon-data-doc \
cocon-readcnf \
cocon-thinclient-desktop \
coconvnc \
cyrus-sasl \
dialog \
freerdp \
libvncserver \
matchbox-wm \
network-manager-applet \
opencocon-init \
opencocon-init-poweroff \
opencocon-init-make-tmpdir \
opencocon-init-read-args \
opencocon-init-set-hostname \
opencocon-init-set-timezone \
opencocon-init-sqs-netboot \
opencocon-init-zram \
pyhoca-cli \
spice-gtk \
xserver-xorg-xephyr \
xpra \
"

# for lxqt testing
RDEPENDS_${PN} += " \
xfce4-panel \
"

