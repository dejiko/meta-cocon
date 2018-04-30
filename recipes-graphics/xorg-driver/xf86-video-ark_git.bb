require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- ark display driver"

LIC_FILES_CHKSUM = "file://COPYING;md5=bdb6aed1d4651e3c08a43c49b9b286d7"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-ark;protocol=git;branch=master \
"

S = "${WORKDIR}/git"
SRCREV = "9c9a53c9ca6a114df303ab71ca852cae13ee323c"

