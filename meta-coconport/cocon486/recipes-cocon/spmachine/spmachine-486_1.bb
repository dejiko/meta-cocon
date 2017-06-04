DESCRIPTION = "Some configuration file when running special x86 machines."
SECTION = "base"
LICENSE = "MIT"
DEPENDS = "base-files dialog opengalax"
LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://COPYING.MIT \
           file://cocon-spmachine \
           file://cocon-spmachine-early \
           file://spmachine486 \
           file://spmachine486-early \
           file://spmachine486-shutdown \
	   file://card-fbdev.conf \
	   file://defaultdepth.conf \
           file://geode-1024x600.conf \
           file://geode-800x480.conf \
           file://poulsbo.conf \
           file://smi_712.conf \
           file://libretto-lx.conf \
           file://sony-pcg-c1.conf \
           file://kohjinsha-pm.conf \
           file://depth-24.conf \
"

S="${WORKDIR}"

do_install() {
	set -ex

	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/spmachine486-early ${D}${sysconfdir}/init.d/spmachine486-early
	install -m 0755 ${WORKDIR}/spmachine486 ${D}${sysconfdir}/init.d/spmachine486
	install -m 0755 ${WORKDIR}/spmachine486-shutdown ${D}${sysconfdir}/init.d/spmachine486-shutdown

	install -d ${D}${bindir}/
        install -m 0755    ${WORKDIR}/cocon-spmachine    ${D}${bindir}/cocon-spmachine
        install -m 0755    ${WORKDIR}/cocon-spmachine-early    ${D}${bindir}/cocon-spmachine-early

	install -d ${D}${datadir}/spmachine-486/
        install -m 0644 ${WORKDIR}/*.conf ${D}${datadir}/spmachine-486/
}

FILES_${PN} = "/"

inherit update-rc.d

PACKAGES =+ "${PN}-early ${PN}-shutdown"
FILES_${PN}-early = "${bindir}/cocon-spmachine-early ${sysconfdir}/init.d/spmachine486-early"
FILES_${PN}-shutdown = "${sysconfdir}/init.d/spmachine486-shutdown"

INITSCRIPT_PACKAGES = "${PN} ${PN}-early ${PN}-shutdown"
# spmachine486-early must be run before udev
INITSCRIPT_NAME_${PN}-early = "spmachine486-early"
INITSCRIPT_PARAMS_${PN}-early = "start 01 S ."
INITSCRIPT_NAME_${PN} = "spmachine486"
INITSCRIPT_PARAMS_${PN} = "start 36 S ."
INITSCRIPT_NAME_${PN}-shutdown = "spmachine486-shutdown"
INITSCRIPT_PARAMS_${PN}-shutdown = "stop 01 0 6 ."


