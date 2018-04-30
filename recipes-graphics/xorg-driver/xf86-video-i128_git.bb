require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- i128 display driver"

LIC_FILES_CHKSUM = "file://COPYING;md5=47dae2fb2926bd08adffd5128f45190c"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-i128;protocol=git;branch=master \
"

S = "${WORKDIR}/git"
SRCREV = "628ffa784be178f402e4cb126ce3556fbd601df2"

