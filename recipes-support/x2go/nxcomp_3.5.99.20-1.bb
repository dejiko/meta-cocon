require nx-libs.inc

DEPENDS += "zlib libpng jpeg jpeg-native xorgproto"
S = "${WORKDIR}/nx-libs-${PV}/${PN}"

SRC_URI_append = "\
                  file://nxcomp-disable-test.patch"

do_configure_prepend() {
  # configure checks VERSION file, so copy to build directory.
  cp ${S}/VERSION ${B}/
}

SRC_URI[md5sum] = "7814de74cb09131f8a62e426cc8a2552"
SRC_URI[sha256sum] = "6b934a98e6425b3790ab0fa56e6e1c7047e98ffdb381415afa755375ae1cb123"
