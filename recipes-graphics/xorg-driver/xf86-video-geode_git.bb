require recipes-graphics/xorg-driver/xorg-driver-video.inc
LIC_FILES_CHKSUM = "file://COPYING;md5=e7f3e39474aeea5af381a8e103dafc36"

SUMMARY = "X.org server -- Geode GX2/LX display driver"
PR = "${INC_PR}.0"

COMPATIBLE_HOST = "i.86.*-linux"

RDEPENDS_${PN} += "xserver-xorg-module-exa"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-geode;protocol=git;branch=master \
"

S = "${WORKDIR}/git"
SRCREV = "8382e6bb0c76a8029493eae3f2d7a3dbfd0cfc12"

