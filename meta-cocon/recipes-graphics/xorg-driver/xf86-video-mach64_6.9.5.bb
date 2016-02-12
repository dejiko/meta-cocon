require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- ATI Mach64 display driver"
DEPENDS += " virtual/libx11 libxvmc drm xf86driproto"

LIC_FILES_CHKSUM = "file://COPYING;md5=be79d1b174a1e5b7e9303201e18d45f4"

SRC_URI += "file://xdriver_xf86-video-mach64-cross-compile.patch"

SRC_URI[md5sum] = "1013ccc86052d0e82c4d504e0c4e896e"
SRC_URI[sha256sum] = "3e98985b6e044189efd42342862208f472881c25debf22230a1d54a96d71b41f"

