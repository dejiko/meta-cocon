# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Packagegroup for opencocon thinclient on cocon486 machine (X.org depends library)"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

inherit packagegroup

COMPATIBLE_MACHINE = "cocon486"

RDEPENDS_${PN} = " \
libdrm \
libdrm-intel \
libdrm-kms \
libdrm-nouveau \
libdrm-radeon \
libegl-mesa \
libgbm \
libgl-mesa \
libglapi \
libgles1-mesa \
libgles2-mesa \
mesa-driver-i915 \
mesa-driver-i965 \
mesa-driver-nouveau-vieux \
mesa-driver-r200 \
mesa-driver-radeon \
mesa-driver-swrast \
xf86-input-evdev \
xf86-input-keyboard \
xf86-input-mouse \
xf86-input-synaptics \
xf86-video-apm \
xf86-video-ark \
xf86-video-ast \
xf86-video-ati \
xf86-video-chips \
xf86-video-cirrus \
xf86-video-fbdev \
xf86-video-geode \
xf86-video-glint \
xf86-video-i128 \
xf86-video-intel \
xf86-video-mach64 \
xf86-video-mga \
xf86-video-modesetting \
xf86-video-neomagic \
xf86-video-nouveau \
xf86-video-nv \
xf86-video-openchrome \
xf86-video-r128 \
xf86-video-s3 \
xf86-video-s3virge \
xf86-video-savage \
xf86-video-siliconmotion \
xf86-video-sis \
xf86-video-sisimedia \
xf86-video-sisusb \
xf86-video-tdfx \
xf86-video-trident \
xf86-video-tseng \
xf86-video-vesa \
xf86-video-xgi \
xf86-video-xgixp \
xserver-xorg-extension-glx \
xserver-xorg-fbdev \
xserver-xorg-module-exa \
xserver-xorg-module-libint10 \
xserver-xorg-module-libwfb \
"


