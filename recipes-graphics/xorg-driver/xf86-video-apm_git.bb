require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "This is the Alliance Promotion driver for XFree86 4.0+"

LIC_FILES_CHKSUM = "file://COPYING;md5=0b302c1eb730ff7a191f2cbdc952f689"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-apm;protocol=git;branch=master \
"

S = "${WORKDIR}/git"
SRCREV = "9f67408e4f078e907fbf4feb45cfdcfd0cdebcca"

