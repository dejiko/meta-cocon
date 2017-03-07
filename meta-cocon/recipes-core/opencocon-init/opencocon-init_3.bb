DESCRIPTION = "classic opencocon-local init"
SECTION = "base"
LICENSE = "MIT"
DEPENDS = "base-files"
RDEPENDS_${PN} = "busybox python"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

SRC_URI = "file://setup.sh \
	   file://cocon-poweroff \
           file://default.cnf \
           file://cocon-version \
           file://services \
"


S="${WORKDIR}"

do_install() {
	set -ex

        install -d ${D}${sysconfdir}
        install -d ${D}${sysconfdir}/default
        install -d ${D}${sysconfdir}/init.d
        install -d ${D}${sysconfdir}/rcS.d
        install -m 0644 ${WORKDIR}/cocon-version ${D}${sysconfdir}/cocon-version
        install -m 0644 ${WORKDIR}/services ${D}${sysconfdir}/services

        install -d ${D}${base_sbindir}/
        install -m 0755    ${WORKDIR}/setup.sh          ${D}${base_sbindir}/setup.sh

	install -d ${D}${bindir}/
	install -m 0755    ${WORKDIR}/cocon-poweroff     ${D}${bindir}/cocon-poweroff

	install -d ${D}${datadir}/cocon/
        install -m 0644 ${WORKDIR}/default.cnf ${D}${datadir}/cocon/default.cnf
}


FILES_${PN} = "/"

