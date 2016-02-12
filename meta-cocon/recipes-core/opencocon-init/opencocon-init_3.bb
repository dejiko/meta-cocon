DESCRIPTION = "classic opencocon-local init"
SECTION = "base"
LICENSE = "MIT"
DEPENDS = "base-files"
RDEPENDS_${PN} = "busybox python"
LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://COPYING.MIT \
           file://inittab \
           file://rcS-default \
           file://rc \
           file://rcS \
           file://setup.sh \
	   file://cocon-poweroff \
           file://default.cnf \
           file://cocon-version \
           file://cocon-read-cnf \
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
        install -m 0644 ${WORKDIR}/inittab ${D}${sysconfdir}/inittab
        install -m 0644 ${WORKDIR}/services ${D}${sysconfdir}/services
        install -m 0644    ${WORKDIR}/rcS-default       ${D}${sysconfdir}/default/rcS  
        install -m 0755    ${WORKDIR}/rc                ${D}${sysconfdir}/init.d
        install -m 0755    ${WORKDIR}/rcS               ${D}${sysconfdir}/init.d


        install -d ${D}${base_sbindir}/
        install -m 0755    ${WORKDIR}/setup.sh          ${D}${base_sbindir}/setup.sh

	install -d ${D}${bindir}/
	install -m 0755    ${WORKDIR}/cocon-poweroff     ${D}${bindir}/cocon-poweroff
        install -m 0755    ${WORKDIR}/cocon-read-cnf     ${D}${bindir}/cocon-read-cnf

	install -d ${D}${datadir}/cocon/
        install -m 0644 ${WORKDIR}/default.cnf ${D}${datadir}/cocon/default.cnf
}


FILES_${PN} = "/"

