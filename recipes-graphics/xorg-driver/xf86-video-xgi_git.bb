require recipes-graphics/xorg-driver/xorg-driver-video.inc

inherit pkgconfig

DEPENDS += "xf86miscproto drm xf86driproto"

LIC_FILES_CHKSUM = "file://COPYING;md5=2b1ee283c95fdba674307f121936ca9a"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-xgi;protocol=git;branch=master \
           file://fix-configure.patch \
          "

S = "${WORKDIR}/git"
SRCREV = "bd94c475035739b42294477cff108e0c5f15ef67"
