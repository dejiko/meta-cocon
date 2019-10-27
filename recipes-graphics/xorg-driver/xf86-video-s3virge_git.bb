require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- S3 ViRGE display driver"

LIC_FILES_CHKSUM = "file://COPYING;md5=09743e0f5c076a765cd16697b5b1effb"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-s3virge;protocol=git;branch=master \
           file://xf86-video-s3virge-Add-check-for-max-HV-Value-to-ValidMode-hook.patch"

S = "${WORKDIR}/git"
SRCREV = "2b620c3fd42c304ee6808a25c205ea03d763032f"

