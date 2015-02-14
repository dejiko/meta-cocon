require recipes-graphics/xorg-driver/xorg-driver-video.inc

DEPENDS += "xf86miscproto drm xf86driproto"

LIC_FILES_CHKSUM = "file://COPYING;md5=2b1ee283c95fdba674307f121936ca9a"


SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-xgi;protocol=git;branch=master \
           file://fix-configure.patch \
          "
#do_configure_prepend() {
#        sed -i \
#                -e s:'#include "mibstore.h"':'':g \
#                ${S}/src/xgi_driver.c
#}

S = "${WORKDIR}/git"
SRCREV = "e26231b128289de190b9381d53bf62e70f06966b"
