require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- SiliconMotion display driver"

LIC_FILES_CHKSUM = "file://COPYING;md5=3893e77db70569921f6d79c387b5748a"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-siliconmotion;protocol=git;branch=master"

S = "${WORKDIR}/git"
SRCREV = "1f94cd4f4b9a4455cc184af4e460d6d1a7fe354b"

