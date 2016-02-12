require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- NV display driver"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-nv;protocol=git;branch=master \
          "

S = "${WORKDIR}/git"
SRCREV = "38d888e0f377bf28373b55c3250c39ab5f8c95b3"

LIC_FILES_CHKSUM = "file://COPYING;md5=5f26d42045c078fef2e284111eabdd31"

