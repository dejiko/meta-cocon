DESCRIPTION = "The Koruri - Japanese TrueType fonts"
HOMEPAGE = "http://koruri.lindwurm.biz/"
LICENSE = "Apache-2.0 & mplus"
SRC_DISTRIBUTE_LICENSES += "mplus"
RDEPENDS_${PN} = "fontconfig-utils"

inherit allarch fontcache

SRC_URI = "https://github.com/Koruri/Koruri/releases/download/Koruri-${PV}/Koruri-${PV}.tar.xz"
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

SRC_URI[md5sum] = "6a2ac1420063905f8c7bca81b6646139"
SRC_URI[sha256sum] = "6627a5a9532efb6c6c26ae5eb9127d2bbb43db0f5decf0b9d2c77a044d4fba85"

LIC_FILES_CHKSUM = "file://LICENSE;md5=9d088c3f7ae366ec868f971a0a4b664e \
                    file://LICENSE_E.mplus;md5=1c4767416f20215f1e61b970f2117db9"
