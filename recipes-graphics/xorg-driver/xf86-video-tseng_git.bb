require recipes-graphics/xorg-driver/xorg-driver-video.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=0a077234e3915957b0b4a1f0ff3f10b7"


SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-tseng;protocol=git;branch=master \
          "

S = "${WORKDIR}/git"
SRCREV = "d2d5c8437e401181f56804cc68594c4831a0983d"
