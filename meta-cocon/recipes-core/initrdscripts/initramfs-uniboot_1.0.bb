DESCRIPTION = "A modular initramfs init script system."

SRC_URI = "file://init.sh \
file://clean.sh \
file://cocon-init-dummy \
"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

do_install() {
        install -d ${D}${base_sbindir}/
        install -m 0755 ${WORKDIR}/init.sh ${D}${base_sbindir}/linuxrc
	install -m 0755 ${WORKDIR}/clean.sh ${D}${base_sbindir}/clean
	install -d ${D}${base_bindir}/
	install -m 0755 ${WORKDIR}/cocon-init-dummy ${D}${base_bindir}/cocon-init
}

PACKAGE_ARCH = "all"
FILES_${PN} += " /sbin/linuxrc /sbin/clean /bin/cocon-init"
