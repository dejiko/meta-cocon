require recipes-graphics/ttf-fonts/ttf.inc

DESCRIPTION = "The Koruri - Japanese TrueType fonts"
HOMEPAGE = "https://koruri.github.io"
LICENSE = "Apache-2.0 & ttf-mplus"
RDEPENDS_${PN} = "fontconfig-utils"

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


FILES_${PN} += "${sysconfdir} ${datadir}"


LIC_FILES_CHKSUM = "file://LICENSE;md5=dcbf253b3d6d09ae7e64cb34b4d0ec33 \
                    file://LICENSE_E.mplus;md5=0ac67069f6b72509c2a25f49ee987f4a"

SRC_URI[md5sum] = "1e4af5d50c261b9a9173be98bd147342"
SRC_URI[sha256sum] = "9cfd9a867f60b8da8653b87706b9bafc113bb477b5e72d1095f43117f7fb3366"

