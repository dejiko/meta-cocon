require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- Savage display driver"
DEPENDS += "drm"

LIC_FILES_CHKSUM = "file://COPYING;md5=1f50f1289ca3b91a542a26ba5df51608"

# Patch from buildroot
SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-savage;protocol=git;branch=master"

S = "${WORKDIR}/git"
SRCREV = "2ec88355123b1def99d8c79769f396ac97bc5008"
