# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append += "file://functions \
                   file://78-graphics-card.rules \
"

do_install_append () {
        install -d ${D}${sysconfdir}/init.d
        install -m 0755 ${WORKDIR}/functions ${D}${sysconfdir}/init.d/functions

        install -d ${D}${base_libdir}/udev/rules.d/
        install -m 0644 ${WORKDIR}/78-graphics-card.rules         ${D}${base_libdir}/udev/rules.d/78-graphics-card.rules

}

