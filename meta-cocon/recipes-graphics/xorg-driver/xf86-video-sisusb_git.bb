require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- SiS Net2280-based USB video driver"
DEPENDS += "xf86miscproto xf86dgaproto drm xf86driproto"

LIC_FILES_CHKSUM = "file://COPYING;md5=b08997efa10dc31f51dad7e85e77f182"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-sisusb;protocol=git;branch=master"

S = "${WORKDIR}/git"
SRCREV = "293d0902705c272b83432a955fb6a3c96dd6cea7"

