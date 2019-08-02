require recipes-graphics/xorg-driver/xorg-driver-video.inc

DEPENDS += "drm"

LIC_FILES_CHKSUM = "file://COPYING;md5=41f74bf6ac6803f497df136f0896153a"

# Patch from buildroot
SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-tdfx;protocol=git;branch=master \
           file://xdriver_xf86-video-tdfx-1.4.0.patch"

S = "${WORKDIR}/git"
SRCREV = "dfe3f54292b3fd37230fb017c80e91038eedfbb5"
