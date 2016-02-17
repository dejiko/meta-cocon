SECTION = "libs"
DESCRIPTION = "Celt Audio Compression Codec"
LICENSE = "BSD"
DEPENDS += "libogg" 

SRC_URI = "http://downloads.xiph.org/releases/celt/celt-${PV}.tar.gz \
"
SRC_URI_append_libc-musl += "file://0001-fix-gnuc-prereq.patch"

inherit autotools

EXTRA_OECONF += "--with-ogg=${D}${prefix}"

PACKAGES += " \
  ${PN}-tools \
"
FILES_${PN} = "\
  ${libdir}/libcelt*.so* \
"

FILES_${PN}-tools = "\
  ${bindir}/celtdec* \
  ${bindir}/celtenc* \
"


LIC_FILES_CHKSUM = "file://COPYING;md5=375f60ab360d17f0172737036ff155b2"

SRC_URI[md5sum] = "67e7b5e45db57a6f1f0a6962f5ecb190"
SRC_URI[sha256sum] = "fc2e5b68382eb436a38c3104684a6c494df9bde133c139fbba3ddb5d7eaa6a2e"

