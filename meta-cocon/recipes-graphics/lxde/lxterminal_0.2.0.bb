DESCRIPTION = "LXDE Terminal"
SECTION = "x11"
DEPENDS = "vte intltool-native"
LICENSE = "GPLv2"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.gz"

SRC_URI[md5sum] = "e80ad1b6e26212f3d43908c2ad87ba4d"
SRC_URI[sha256sum] = "174b0e99652f72acd7a98b6ff1b75eba1a9bf364996e6f118cccdaba0d282baf"

inherit autotools

#RDEPENDS_${PN} = "vte"

LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

FILES_${PN} += "${datadir}/icons/hicolor/128x128/apps/lxterminal.png"

