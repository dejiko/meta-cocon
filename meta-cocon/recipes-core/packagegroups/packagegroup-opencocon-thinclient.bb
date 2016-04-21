# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Task for opencocon thinclient desktop environment"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

inherit packagegroup


RDEPENDS_${PN} = " \
celt \
cocon-data \
cocon-data-doc \
cocon-thinclient-desktop \
coconvnc \
cyrus-sasl \
dialog \
eject \
freerdp \
gnome-icon-theme \
hicolor-icon-theme \
iproute2 \
libnotify \
libvncserver \
libwnck \
lxpanel \
lxrandr \
lxterminal \
matchbox-wm \
mkfontdir \
network-manager-applet \
networkmanager \
ntpdate \
opencocon-init \
python-core \
python-io \
python-shell \
spice-gtk \
sudo \
tzdata \
viewnior \
xserver-xf86-config \
xserver-xorg-xephyr \
xuser-account \
"

