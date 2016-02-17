DESCRIPTION = "The Koruri - Japanese TrueType fonts"
HOMEPAGE = "http://koruri.lindwurm.biz/"
LICENSE = "Apache-2.0 & mplus"
SRC_DISTRIBUTE_LICENSES += "mplus"
RDEPENDS_${PN} = "fontconfig-utils"

inherit allarch fontcache

SRC_URI = "http://osdn.dl.sourceforge.jp/koruri/62469/Koruri-${PV}.tar.xz"
S = "${WORKDIR}/Koruri-${PV}"


do_install () {
        install -d ${D}${datadir}/fonts/ttf/
        for i in *.ttf; do
                install -m 0644 $i ${D}${prefix}/share/fonts/ttf/${i}
        done

        install -d ${D}${prefix}/share/doc/${PN}/
        install -m 0644 ${S}/LICENSE ${D}${datadir}/doc/${PN}/
        install -m 0644 ${S}/LICENSE_E.mplus ${D}${datadir}/doc/${PN}/
}

pkg_postinst_${PN} () {
#!/bin/sh
fc-cache
}


PACKAGES = "${PN}"
FILES_${PN} += "${sysconfdir} ${datadir}"

SRC_URI[md5sum] = "21b1e8b0a011649e37fddf0e2bf61305"
SRC_URI[sha256sum] = "2de09d84d05955018dd2b053ec912a94edb6320579bacfb96347d5fe8eb13872"

LIC_FILES_CHKSUM = "file://LICENSE;md5=9d088c3f7ae366ec868f971a0a4b664e \
                    file://LICENSE_E.mplus;md5=1c4767416f20215f1e61b970f2117db9"
