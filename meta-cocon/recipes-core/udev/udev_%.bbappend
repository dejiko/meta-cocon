FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-mtd_probe.h-Add-stdint.h-as-it-was-removed-from-mtd-.patch \
            file://0002-configure.ac-Makefile.am-Check-for-input.h-and-input.patch \
            file://50-udev-default.rules \
"

do_install_append() {
    install -d ${D}${sysconfdir}/udev/rules.d

    install -m 0644 ${WORKDIR}/50-udev-default.rules ${D}${base_libdir}/udev/rules.d/50-udev-default.rules
}
