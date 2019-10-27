require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- r128 display driver"

LIC_FILES_CHKSUM = "file://COPYING;md5=7afbe929192be6cccb50f81b968fd23a"

# Patch from buildroot
SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-r128;protocol=git;branch=master"

S = "${WORKDIR}/git"
SRCREV = "3af7cd1faf42f6458d72bd412349478e252e9bd6"
