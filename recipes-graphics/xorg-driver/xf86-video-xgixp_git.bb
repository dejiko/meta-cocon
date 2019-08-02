require recipes-graphics/xorg-driver/xorg-driver-video.inc

inherit pkgconfig

DEPENDS += "drm"

LIC_FILES_CHKSUM = "file://COPYING;md5=225ca1644e92badb31a40ef755bf2364"

# Patch from buildroot
SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-xgixp;protocol=git;branch=master \
           file://xdriver_xf86-video-xgixp-cross-compile.patch"

S = "${WORKDIR}/git"
SRCREV = "ee201fc80796f97befcb1952178d0f91c03cecd6"

