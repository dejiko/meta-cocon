DESCRIPTION = "classic opencocon-local init"
SECTION = "base"
LICENSE = "MIT"
DEPENDS = "base-files"
RDEPENDS_${PN} = "busybox python"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

SRC_URI = "file://cocon-poweroff \
           file://default.cnf \
           file://cocon-version \
           file://services \
           file://make-tmpdir \
           file://cocon-classic-setup \
           file://sqs-netboot \
           file://zram \
"

S="${WORKDIR}"

do_install() {
	set -ex

        install -d ${D}${sysconfdir}
        install -d ${D}${sysconfdir}/default
        install -m 0644 ${WORKDIR}/cocon-version ${D}${sysconfdir}/cocon-version
        install -m 0644 ${WORKDIR}/services ${D}${sysconfdir}/services

	install -d ${D}${datadir}/cocon/
        install -m 0644 ${WORKDIR}/default.cnf ${D}${datadir}/cocon/default.cnf

	install -d ${D}${sysconfdir}/init.d
	install -m 0755	${WORKDIR}/cocon-poweroff	${D}${sysconfdir}/init.d/cocon-poweroff
	install -m 0755	${WORKDIR}/make-tmpdir		${D}${sysconfdir}/init.d/make-tmpdir
	install -m 0755	${WORKDIR}/cocon-classic-setup	${D}${sysconfdir}/init.d/cocon-classic-setup
	install -m 0755	${WORKDIR}/sqs-netboot		${D}${sysconfdir}/init.d/sqs-netboot
	install -m 0755	${WORKDIR}/zram			${D}${sysconfdir}/init.d/zram
}


PACKAGES =+ "${PN}-poweroff ${PN}-make-tmpdir ${PN}-sqs-netboot ${PN}-zram"

FILES_${PN} = "${sysconfdir}/cocon-version \
	${sysconfdir}/services \
	${datadir}/cocon/default.cnf \
	${sysconfdir}/init.d/cocon-classic-setup \
"
FILES_${PN}-poweroff = "${sysconfdir}/init.d/cocon-poweroff"
FILES_${PN}-make-tmpdir = "${sysconfdir}/init.d/make-tmpdir"
FILES_${PN}-sqs-netboot = "${sysconfdir}/init.d/sqs-netboot"
FILES_${PN}-zram = "${sysconfdir}/init.d/zram"

inherit update-rc.d

INITSCRIPT_PACKAGES = "${PN} ${PN}-poweroff ${PN}-make-tmpdir ${PN}-sqs-netboot ${PN}-zram"
INITSCRIPT_NAME_${PN} = "cocon-classic-setup"
INITSCRIPT_PARAMS_${PN} = "start 01 S ."
INITSCRIPT_NAME_${PN}-poweroff = "cocon-poweroff"
INITSCRIPT_PARAMS_${PN}-poweroff = "stop 99 0 6 ."
INITSCRIPT_NAME_${PN}-make-tmpdir = "make-tmpdir"
INITSCRIPT_PARAMS_${PN}-make-tmpdir = "start 00 S ."
INITSCRIPT_NAME_${PN}-sqs-netboot = "sqs-netboot"
INITSCRIPT_PARAMS_${PN}-sqs-netboot = "start 00 S ."
INITSCRIPT_NAME_${PN}-zram = "zram"
INITSCRIPT_PARAMS_${PN}-zram = "start 37 S ."

