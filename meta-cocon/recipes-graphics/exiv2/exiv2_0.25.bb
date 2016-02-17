# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Image metadata library and tools"
HOMEPAGE = "http://www.exiv2.org/"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=625f055f41728f84a8d7938acc35bdc2"

DEPENDS += "expat zlib"
RDEPENDS_${PV} = "expat zlib"

inherit cmake gettext
SRC_URI = "http://www.exiv2.org/exiv2-${PV}.tar.gz"

do_compile_append() {
    # Remove useless rpath
    find ${B}/src -name "libexiv2.so" | xargs chrpath -d
}

FILES_${PN}-doc += "${exec_prefix}/man/man1/exiv2.1"

SRC_URI[md5sum] = "258d4831b30f75a01e0234065c6c2806"
SRC_URI[sha256sum] = "c80bfc778a15fdb06f71265db2c3d49d8493c382e516cb99b8c9f9cbde36efa4"

