require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- Glint display driver"
DEPENDS += " xf86dgaproto drm xf86driproto"

LIC_FILES_CHKSUM = "file://COPYING;md5=724772f5b1ac0f483904fa55275a5b85"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-glint;protocol=git;branch=master \
"

S = "${WORKDIR}/git"
SRCREV = "b54f27f0de0558880b2146a4315a99907eb72249"
