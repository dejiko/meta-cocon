require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- Savage display driver"
DEPENDS += "drm"

LIC_FILES_CHKSUM = "file://COPYING;md5=1f50f1289ca3b91a542a26ba5df51608"

# Patch from buildroot
SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-savage;protocol=git;branch=master \
           file://xdriver_xf86-video-savage-2.2.1-cross-compile.patch"

S = "${WORKDIR}/git"
SRCREV = "4241304ee2101563d2d8eb8916d85fc3626f181b"
