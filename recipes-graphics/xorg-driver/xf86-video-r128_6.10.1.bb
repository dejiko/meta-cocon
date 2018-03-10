require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- r128 display driver"

LIC_FILES_CHKSUM = "file://COPYING;md5=7afbe929192be6cccb50f81b968fd23a"

# Patch from buildroot
SRC_URI += "file://0001-cross-compile.patch"

SRC_URI[md5sum] = "770c2342141874f8a81a95ecd1839746"
SRC_URI[sha256sum] = "5ebfef49831c9b12f7b7011c8314010596ac2ab0d5b9b7cfd17908e93d7de4ea"
