require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X11 driver for NeoMagic 2200, 2160, 2097, 2093, 2090, 2070"
DEPENDS += " xf86dgaproto"

LIC_FILES_CHKSUM = "file://COPYING;md5=3a6358ddf387f4be24801a5337a021a8"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-neomagic;protocol=git;branch=master \
          "
S = "${WORKDIR}/git"
SRCREV = "81b8ea1cb8aa8bc07e57ad885b4ba2957c90da6a"

