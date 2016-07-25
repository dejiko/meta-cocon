# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Packagegroup for opencocon project (common, depends X)"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

inherit packagegroup


RDEPENDS_${PN} = " \
mkfontdir \
gnome-icon-theme \
hicolor-icon-theme \
xserver-xf86-config \
xuser-account \
dbus-x11 \
encodings \
font-alias \
font-util \
freetype \
liberation-fonts \
libjpeg-turbo \
setxkbmap \
ttf-bitstream-vera \
ttf-koruri \
x11perf \
xauth \
xcb-util-image \
xcb-util-keysyms \
xcb-util-renderutil \
xcb-util-wm \
xdpyinfo \
xinit \
xinput-calibrator \
xmodmap \
xorg-minimal-fonts \
xrandr \
xserver-xorg \
linuxconsole-inputattach \
"
