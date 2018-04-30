require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- S3 ViRGE display driver"

LIC_FILES_CHKSUM = "file://COPYING;md5=09743e0f5c076a765cd16697b5b1effb"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-s3virge;protocol=git;branch=master"

S = "${WORKDIR}/git"
SRCREV = "81542ee8efb9662016aea717b018f126e47d325b"

