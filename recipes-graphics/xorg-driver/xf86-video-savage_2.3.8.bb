require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- Savage display driver"
DEPENDS += " drm xf86driproto"

LIC_FILES_CHKSUM = "file://COPYING;md5=1f50f1289ca3b91a542a26ba5df51608"

# Patch from buildroot
SRC_URI += "file://xdriver_xf86-video-savage-2.2.1-cross-compile.patch"
#            file://03_request_16bit_depth.diff

SRC_URI[md5sum] = "b29672072aacd5ea0d569235e9e25ae1"
SRC_URI[sha256sum] = "fdcea4a86532bceb50095eaf0fe2f38bbfa160e98463b815f4b549eb9985fa63"

