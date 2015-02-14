DESCRIPTION = "LXDE RandR"
SECTION = "x11"
DEPENDS = "xrandr glib-2.0 intltool"
LICENSE = "GPLv2"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.xz"

inherit autotools gettext

LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI[md5sum] = "250f0ebb09c1e02f430f951911ba1259"
SRC_URI[sha256sum] = "183deaed658c4a0ba937fc349e88330267b8309fc51f67f7ec4b4768ccc66b76"
