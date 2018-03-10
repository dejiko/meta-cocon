DESCRIPTION = "Image Viewer"
SECTION = "x11"
DEPENDS = "glib-2.0 gtk+ exiv2"
LICENSE = "GPLv3"

SRC_URI = "https://www.dropbox.com/s/zytq0suabesv933/${PN}-${PV}.tar.gz"

inherit autotools gettext pkgconfig

SRC_URI[md5sum] = "13d7cb3381522161b32de9b70dd989b8"
SRC_URI[sha256sum] = "ea14f27d384962c0c429e123f1275938bacd2a636b995645aadf3d78c708616f"


FILES_${PN} += "${datadir}/icons/hicolor/*"

LIC_FILES_CHKSUM = "file://COPYING;md5=8f0e2cd40e05189ec81232da84bd6e1a"

