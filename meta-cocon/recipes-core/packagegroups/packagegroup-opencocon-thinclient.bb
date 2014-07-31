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
cyrus-sasl \
dialog \
eject \
freerdp \
gnome-icon-theme \
gnome-keyring \
gtk-vnc \
hicolor-icon-theme \
iproute2 \
libfreerdp \
libfreerdp-plugin-audin \
libfreerdp-plugin-audin-alsa \
libfreerdp-plugin-audin-pulse \
libfreerdp-plugin-drdynvc \
libfreerdp-plugin-rdpsnd \
libfreerdp-plugin-rdpsnd-alsa \
libfreerdp-plugin-rdpsnd-pulse \
libfreerdp-plugin-tsmf \
libfreerdp-plugin-tsmf-alsa \
libfreerdp-plugin-tsmf-pulse \
libnotify \
libvncserver \
libwnck \
lxpanel \
lxrandr \
lxterminal \
matchbox-wm \
network-manager-applet \
networkmanager \
ntpdate \
opencocon-init \
polkit-gnome \
spice-gtk \
viewnior \
xserver-xorg-xephyr \
xuser-account \
"

