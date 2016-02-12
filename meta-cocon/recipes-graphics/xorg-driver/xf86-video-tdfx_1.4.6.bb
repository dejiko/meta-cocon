require recipes-graphics/xorg-driver/xorg-driver-video.inc

DEPENDS += " drm xf86driproto"

LIC_FILES_CHKSUM = "file://COPYING;md5=41f74bf6ac6803f497df136f0896153a"

# Patch from buildroot
#SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-tdfx;protocol=git;branch=master 
SRC_URI += "file://xdriver_xf86-video-tdfx-1.4.0.patch"

#EXTRA_OECONF += " --enable-dri"

SRC_URI[md5sum] = "3ad54183fa339ef2ab10e2704ba95060"
SRC_URI[sha256sum] = "3a8a88867c40ad61f1c9a09ffd7ac64102fa821685855d50ce66c7603dcc6d37"

