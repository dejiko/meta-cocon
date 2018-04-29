require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- NV display driver"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-nv;protocol=git;branch=master \
          "

S = "${WORKDIR}/git"
SRCREV = "b7d57087d082d027f059f4e0a6ce9982c3e5f0fb"

LIC_FILES_CHKSUM = "file://COPYING;md5=5f26d42045c078fef2e284111eabdd31"

