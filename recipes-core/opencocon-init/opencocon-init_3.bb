DESCRIPTION = "opencocon-local init"
SECTION = "base"
LICENSE = "MIT"
DEPENDS = "base-files"
RDEPENDS_${PN} = "busybox"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

SRC_URI = "file://cocon-poweroff \
           file://default.cnf \
           file://cocon-version \
           file://services \
           file://make-tmpdir \
           file://read-args \
           file://set-hostname \
           file://set-keymap \
           file://sqs-netboot \
           file://set-timezone \
           file://zram \
"

S="${WORKDIR}"

do_install() {
	set -ex

        install -d ${D}${sysconfdir}
        #install -d ${D}${sysconfdir}/default
        install -m 0644 ${WORKDIR}/cocon-version ${D}${sysconfdir}/cocon-version
        install -m 0644 ${WORKDIR}/services ${D}${sysconfdir}/services

	install -d ${D}${datadir}/cocon/
        install -m 0644 ${WORKDIR}/default.cnf ${D}${datadir}/cocon/default.cnf

	install -d ${D}${sysconfdir}/init.d
        # cocon-poweroff : rename
	install -m 0755	${WORKDIR}/cocon-poweroff	${D}${sysconfdir}/init.d/cocon-poweroff.sh
	install -m 0755	${WORKDIR}/make-tmpdir		${D}${sysconfdir}/init.d/make-tmpdir
	install -m 0755 ${WORKDIR}/read-args		${D}${sysconfdir}/init.d/read-args
	install -m 0755 ${WORKDIR}/set-hostname		${D}${sysconfdir}/init.d/set-hostname
	install -m 0755 ${WORKDIR}/set-keymap		${D}${sysconfdir}/init.d/set-keymap
	install -m 0755 ${WORKDIR}/set-timezone		${D}${sysconfdir}/init.d/set-timezone
	install -m 0755	${WORKDIR}/sqs-netboot		${D}${sysconfdir}/init.d/sqs-netboot
	install -m 0755	${WORKDIR}/zram			${D}${sysconfdir}/init.d/zram
}


PACKAGES =+ "${PN}-poweroff ${PN}-make-tmpdir ${PN}-read-args ${PN}-set-hostname ${PN}-set-keymap ${PN}-set-timezone ${PN}-sqs-netboot ${PN}-zram"

FILES_${PN} = "${sysconfdir}/cocon-version \
	${sysconfdir}/services \
	${datadir}/cocon/default.cnf \
"
FILES_${PN}-poweroff = "${sysconfdir}/init.d/cocon-poweroff.sh"
FILES_${PN}-make-tmpdir = "${sysconfdir}/init.d/make-tmpdir"
FILES_${PN}-read-args = "${sysconfdir}/init.d/read-args"
FILES_${PN}-set-hostname = "${sysconfdir}/init.d/set-hostname"
FILES_${PN}-set-keymap = "${sysconfdir}/init.d/set-keymap"
FILES_${PN}-set-timezone = "${sysconfdir}/init.d/set-timezone"
FILES_${PN}-sqs-netboot = "${sysconfdir}/init.d/sqs-netboot"
FILES_${PN}-zram = "${sysconfdir}/init.d/zram"

inherit update-rc.d

INITSCRIPT_PACKAGES = "${PN}-poweroff ${PN}-make-tmpdir ${PN}-read-args ${PN}-set-hostname ${PN}-set-keymap ${PN}-set-timezone ${PN}-sqs-netboot ${PN}-zram"
INITSCRIPT_NAME_${PN}-poweroff = "cocon-poweroff.sh"
INITSCRIPT_PARAMS_${PN}-poweroff = "stop 99 0 6 ."
INITSCRIPT_NAME_${PN}-make-tmpdir = "make-tmpdir"
INITSCRIPT_PARAMS_${PN}-make-tmpdir = "start 00 S ."
INITSCRIPT_NAME_${PN}-read-args = "read-args"
INITSCRIPT_PARAMS_${PN}-read-args = "start 00 S ."
INITSCRIPT_NAME_${PN}-set-hostname = "set-hostname"
INITSCRIPT_PARAMS_${PN}-set-hostname = "start 50 S ."
INITSCRIPT_NAME_${PN}-set-keymap = "set-keymap"
INITSCRIPT_PARAMS_${PN}-set-keymap = "start 42 S ."
INITSCRIPT_NAME_${PN}-set-timezone = "set-timezone"
INITSCRIPT_PARAMS_${PN}-set-timezone = "start 42 S ."
INITSCRIPT_NAME_${PN}-sqs-netboot = "sqs-netboot"
INITSCRIPT_PARAMS_${PN}-sqs-netboot = "start 00 S ."
INITSCRIPT_NAME_${PN}-zram = "zram"
INITSCRIPT_PARAMS_${PN}-zram = "start 37 S ."

