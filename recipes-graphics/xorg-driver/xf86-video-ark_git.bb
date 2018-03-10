require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- ark display driver"

LIC_FILES_CHKSUM = "file://COPYING;md5=bdb6aed1d4651e3c08a43c49b9b286d7"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-ark;protocol=git;branch=master \
"

S = "${WORKDIR}/git"
SRCREV = "3a3eb72baec46f48e6cf15a834271c3d3386deac"

