require recipes-graphics/ttf-fonts/ttf.inc

DESCRIPTION = "The Koruri - Japanese TrueType fonts"
HOMEPAGE = "http://koruri.lindwurm.biz/"
LICENSE = "Apache-2.0 & mplus"
RDEPENDS_${PN} = "fontconfig-utils"

SRC_URI = "https://osdn.jp/dl/koruri/Koruri-${PV}.tar.xz"
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


FILES_${PN} += "${sysconfdir} ${datadir}"


LIC_FILES_CHKSUM = "file://LICENSE;md5=9d088c3f7ae366ec868f971a0a4b664e \
                    file://LICENSE_E.mplus;md5=0ac67069f6b72509c2a25f49ee987f4a"

SRC_URI[md5sum] = "45a25d40ad1a628c7524d0c64d63b9f6"
SRC_URI[sha256sum] = "15b72c803af963f72c838053a10bea1ae608b36ac9acaf2b69f7d924ee38181f"

