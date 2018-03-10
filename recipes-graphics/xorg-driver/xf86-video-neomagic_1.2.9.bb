require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X11 driver for NeoMagic 2200, 2160, 2097, 2093, 2090, 2070"
DEPENDS += " xf86dgaproto"

LIC_FILES_CHKSUM = "file://COPYING;md5=3a6358ddf387f4be24801a5337a021a8"

SRC_URI[md5sum] = "4b5b52e9da0a954cd3d6068a33975bc1"
SRC_URI[sha256sum] = "72f89396b10527549337cb72a7eafb1194cf140144f9236a94ad2becdf140bf2"

