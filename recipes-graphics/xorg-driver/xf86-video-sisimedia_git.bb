# A lot of thanks to maintainers that made buildable recipe!

require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- X.org SiS 671 video driver"
DEPENDS += "xf86miscproto xf86dgaproto drm xf86driproto util-macros"

LIC_FILES_CHKSUM = "file://src/sis_driver.c;beginline=6;endline=28;md5=8c7057c95db5909c1e455042c48cec57"

SRC_URI = "git://github.com/rkrell/xf86-video-sisimedia.git;protocol=https;branch=master"

S = "${WORKDIR}/git"
SRCREV = "85a1036a4f804fd378d5118fb44387a34489b384"

# It seems need edit configure.ac to enable DRI.
EXTRA_OECONF += " --disable-dri"

