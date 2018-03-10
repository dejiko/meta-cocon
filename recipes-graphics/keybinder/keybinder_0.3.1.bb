DESCRIPTION = "Library for registering global key bindings, for gtk-based applications"
HOMEPAGE = "https://github.com/engla/keybinder"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

DEPENDS += "gtk+ gobject-introspection-stub-native"

EXTRA_OECONF += "--disable-python --disable-lua"

inherit autotools pkgconfig
SRC_URI = "https://github.com/engla/keybinder/releases/download/v${PV}/keybinder-${PV}.tar.gz"

SRC_URI[md5sum] = "a6d7caae0dcb040b08692b008a68a507"
SRC_URI[sha256sum] = "879f07130ac64792ddb9fd758e6673119283bda37d75573787ae22af8684a240"

