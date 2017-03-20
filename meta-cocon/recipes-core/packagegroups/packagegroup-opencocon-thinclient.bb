# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Packagegroup for opencocon thinclient desktop environment"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

inherit packagegroup

# opencocon-init : compat module

RDEPENDS_${PN} = " \
celt \
cocon-data \
cocon-data-doc \
cocon-readcnf \
cocon-thinclient-desktop \
cocon-thinclient-desktop-copynm \
cocon-thinclient-desktop-pre-startx \
coconvnc \
cyrus-sasl \
dialog \
freerdp \
libvncserver \
lxpanel \
lxrandr \
lxterminal \
matchbox-wm \
network-manager-applet \
nxcomp \
nxproxy \
opencocon-init \
opencocon-init-poweroff \
opencocon-init-make-tmpdir \
opencocon-init-sqs-netboot \
opencocon-init-zram \
qtbase-plugins \
spice-gtk \
x2goclient \
xserver-nodm-init \
xserver-xorg-xephyr \
"

