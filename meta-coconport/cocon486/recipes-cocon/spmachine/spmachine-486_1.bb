DESCRIPTION = "Some configuration file when running special x86 machine."
SECTION = "base"
LICENSE = "MIT"
DEPENDS = "base-files dialog opengalax"
LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://COPYING.MIT \
           file://cocon-spmachine \
           file://cocon-spmachine-early \
	   file://card-fbdev.conf \
	   file://defaultdepth.conf \
           file://geode-1024x600.conf \
           file://geode-800x480.conf \
           file://poulsbo.conf \
           file://smi_712.conf \
           file://libretto-lx.conf \
           file://sony-pcg-c1.conf \
           file://kohjinsha-pm.conf \
           file://sca001.conf \
"

S="${WORKDIR}"

do_install() {
	set -ex

	install -d ${D}${bindir}/
        install -m 0755    ${WORKDIR}/cocon-spmachine    ${D}${bindir}/cocon-spmachine
        install -m 0755    ${WORKDIR}/cocon-spmachine-early    ${D}${bindir}/cocon-spmachine-early

	install -d ${D}${datadir}/spmachine-486/
        install -m 0644 ${WORKDIR}/*.conf ${D}${datadir}/spmachine-486/

}


FILES_${PN} = "/"

