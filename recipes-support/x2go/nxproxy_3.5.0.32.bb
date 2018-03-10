
require nx-libs.inc

DEPENDS += "nxcomp"
S = "${WORKDIR}/nx-libs-${PV}/${PN}"

SRC_URI += "file://fix-header.patch"

do_configure_append() {
  mkdir ${B}/man
  cp ${S}/man/nxproxy.1 ${B}/man/
}

SRC_URI[md5sum] = "89ba66391de908ee3cc6e28be4e729bd"
SRC_URI[sha256sum] = "b5ab9f0ae35cdf6c3e26484d2a2ca55cd0225b6d8693f5544a096b19585bc50a"

