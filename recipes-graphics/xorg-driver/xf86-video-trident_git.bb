require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.org X server -- Trident display driver"
DEPENDS += " xf86dgaproto"

LIC_FILES_CHKSUM = "file://COPYING;md5=2e9eb6db89324a99415a93a059157da7"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-trident;protocol=git;branch=master \
          "

S = "${WORKDIR}/git"
SRCREV = "1d270ceb929068f7292b9d759000a6224f2747cc"
