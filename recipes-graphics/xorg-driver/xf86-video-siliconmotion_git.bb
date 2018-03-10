require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- SiliconMotion display driver"

LIC_FILES_CHKSUM = "file://COPYING;md5=3893e77db70569921f6d79c387b5748a"


SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-siliconmotion;protocol=git;branch=master"
 
#           file://exclude-sm712.patch

S = "${WORKDIR}/git"
SRCREV = "647e5a93d9387e3bc8d2c8569e3a5f996acfb169"

