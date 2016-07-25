# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Task for opencocon thinclient on cocon486 machine (X.org depends library)"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

inherit packagegroup

COMPATIBLE_MACHINE = "coconx64"

RDEPENDS_${PN} = " \
consolekit \
dbus-x11 \
encodings \
font-alias \
font-util \
freetype \
libdrm-intel \
libdrm-kms \
libdrm-nouveau \
libdrm-radeon \
libegl-mesa \
liberation-fonts \
libgbm \
libgl-mesa \
libglapi \
libgles1-mesa \
libgles2-mesa \
libjpeg-turbo \
mesa-driver-i915 \
mesa-driver-i965 \
mesa-driver-nouveau-vieux \
mesa-driver-r200 \
mesa-driver-radeon \
mesa-driver-swrast \
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
xf86-input-evdev \
xf86-input-keyboard \
xf86-input-mouse \
xf86-input-synaptics \
xf86-video-ati \
xf86-video-cirrus \
xf86-video-fbdev \
xf86-video-intel \
xf86-video-modesetting \
xf86-video-nouveau \
xf86-video-openchrome \
xf86-video-siliconmotion \
xf86-video-sisimedia \
xf86-video-xgi \
xf86-video-xgixp \
xf86-video-vesa \
xf86-video-vmware \
xinit \
xinput-calibrator \
xmodmap \
xorg-minimal-fonts \
xrandr \
xserver-xorg \
xserver-xorg-extension-dbe \
xserver-xorg-extension-extmod \
xserver-xorg-extension-glx \
xserver-xorg-fbdev \
xserver-xorg-module-exa \
xserver-xorg-module-libint10 \
xserver-xorg-module-libwfb \
"


