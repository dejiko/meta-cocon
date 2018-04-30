require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- SiS display driver"
DEPENDS += "xf86miscproto xf86dgaproto drm xf86driproto"

LIC_FILES_CHKSUM = "file://COPYING;md5=cbbdd887d04deb501076c22917e2030d"

# Patch from buildroot and Arch Linux
SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-sis;protocol=git;branch=master \
           file://xdriver_xf86-video-sis-0.10.0.patch \
           file://Xi.patch"

S = "${WORKDIR}/git"
SRCREV = "a50b2b3412dd8e7f3916acb142c942e85ffcb3e5"

# EXTRA_OECONF += " --enable-dri"
