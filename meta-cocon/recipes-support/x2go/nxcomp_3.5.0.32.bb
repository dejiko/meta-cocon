
require nx-libs.inc

DEPENDS += "zlib libpng jpeg "
S = "${WORKDIR}/nx-libs-${PV}/${PN}"

do_configure_prepend() {
  # configure checks VERSION file, so copy to build directory.
  cp ${S}/VERSION ${B}/

  # copy some file needed on install
  cp ${S}/mkinstalldirs ${B}/
  cp ${S}/NX*.h ${B}/
  cp ${S}/MD5.h ${B}/
}

SRC_URI[md5sum] = "89ba66391de908ee3cc6e28be4e729bd"
SRC_URI[sha256sum] = "b5ab9f0ae35cdf6c3e26484d2a2ca55cd0225b6d8693f5544a096b19585bc50a"

