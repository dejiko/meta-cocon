SUMMARY = "Library for registering global keyboard shortcut"
HOMEPAGE = "https://github.com/engla/keybinder"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"


SECTION = "x11/libs"
DEPENDS = "glib-2.0 gtk+"

SRC_URI = "https://github.com/engla/keybinder/archive/v${PV}.tar.gz"

inherit autotools pkgconfig gtk-doc

SRC_URI[md5sum] = "2cbb2672dfd9a97291d12fe01a0213d9"
SRC_URI[sha256sum] = "8e8d77386b9e29556fab097c31aec643d36a33d201733b7b999179abcba7774e"

EXTRA_OECONF += "--disable-python --disable-lua --enable-introspection=no --enable-gtk-doc=no"

