require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- openchrome display driver"
DEPENDS += "libxvmc"


do_configure_prepend() {
        rm -f ${S}/acinclude.m4 || true
}

LIC_FILES_CHKSUM = "file://COPYING;md5=ed28020670498bb992812791b7aa3cca"

SRC_URI = "git://anongit.freedesktop.org/openchrome/xf86-video-openchrome;protocol=git;branch=master \
"

S = "${WORKDIR}/git"
SRCREV = "3c882cf8e694c752541153a4a535f398fe7175c6"


