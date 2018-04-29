require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- MGA display driver"

LIC_FILES_CHKSUM = "file://COPYING;md5=bc1395d2cd32dfc5d6c57d2d8f83d3fc"

# Patch from https://bugs.freedesktop.org/show_bug.cgi?id=57606
SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-mga;protocol=git;branch=master \
            file://xf86-video-mga-cross-compile.patch "

SRC_URI[md5sum] = "a53b5ce166e31c181aaa4c3816d8babb"
SRC_URI[sha256sum] = "7704b1ea35098769787a9c93e903b827be97a99facfb1696aa5236a58ff1c7d7"

S = "${WORKDIR}/git"
SRCREV = "34f37fe119f07e1e7b79964de08ac601a0753a7f"


