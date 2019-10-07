require nx-libs.inc

DEPENDS += "nxcomp"
S = "${WORKDIR}/nx-libs-${PV}/${PN}"

SRC_URI += " \
            file://fix-header.patch \
            file://nxproxy-makefile-am.patch"

SRC_URI[md5sum] = "7814de74cb09131f8a62e426cc8a2552"
SRC_URI[sha256sum] = "6b934a98e6425b3790ab0fa56e6e1c7047e98ffdb381415afa755375ae1cb123"
