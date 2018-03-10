require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.org X server -- Trident display driver"
DEPENDS += " xf86dgaproto"

LIC_FILES_CHKSUM = "file://COPYING;md5=2e9eb6db89324a99415a93a059157da7"

SRC_URI[md5sum] = "04243bba246fe369c30a3b970f5b1c23"
SRC_URI[sha256sum] = "ecd518de627a0d49e17c158bfc72ab657386c6907c91ef89fa09332558e413ae"

