DESCRIPTION = ""
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a1235faab6ffbdbcc0c45751a0e662a6"

SRC_URI = "https://pypi.python.org/packages/source/K/Kivy/${PN}-${PV}.tar.gz"
S = "${WORKDIR}/${PN}-${PV}"

SRC_URI[md5sum] = "e1cb0f9bca49fdad05653df3fb6fec46"
SRC_URI[sha256sum] = "29bc45be34c26a8acb1dafdd329145f997a473be344cd052659f821f6478637e"

DEPENDS += "python-cython-native libsdl2"
RDEPENDS_${PN} = "gstreamer1.0"

inherit setuptools

PACKAGES =+ "${PN}-examples"

FILES_${PN}-examples = "${datadir}/kivy-examples/*"
FILES_${PN}-dbg += "${libdir}/python2.7/site-packages/kivy/*/*/.debug/*.so"
