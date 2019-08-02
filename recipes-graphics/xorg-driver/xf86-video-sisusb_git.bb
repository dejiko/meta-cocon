require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- SiS Net2280-based USB video driver"
DEPENDS += "drm"

LIC_FILES_CHKSUM = "file://COPYING;md5=b08997efa10dc31f51dad7e85e77f182"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-sisusb;protocol=git;branch=master"

S = "${WORKDIR}/git"
SRCREV = "06a2f92d23d512f348bf3ebf6582d6a9e13697d7"

