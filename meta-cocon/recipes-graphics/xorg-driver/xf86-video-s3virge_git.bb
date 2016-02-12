require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- S3 ViRGE display driver"

LIC_FILES_CHKSUM = "file://COPYING;md5=09743e0f5c076a765cd16697b5b1effb"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-s3virge;protocol=git;branch=master"

S = "${WORKDIR}/git"
SRCREV = "47f43694645f3e6347b536d5e3fb2fee56e715ab"

