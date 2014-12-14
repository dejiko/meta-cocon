require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- Savage display driver"
DEPENDS += " drm xf86driproto"

LIC_FILES_CHKSUM = "file://COPYING;md5=1f50f1289ca3b91a542a26ba5df51608"

# Patch from buildroot
SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-savage;protocol=git;branch=master \
            file://xdriver_xf86-video-savage-2.2.1-cross-compile.patch  \
            file://03_request_16bit_depth.diff \
"

#do_compile_prepend() {
#        sed -i \
#                -e s:'\-O2':'\-O0':g \
#                ${S}/src/Makefile
#        sed -i \
#                -e s:'\-O1':'\-O0':g \
#                ${S}/src/Makefile
#}

EXTRA_OECONF += " --enable-dri"

S = "${WORKDIR}/git"
SRCREV = "d28cd83c7b0b4a943efbe5ddf257c8ee2646ea73"
