# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "\
            file://include-memset.patch \
"

do_install_append () {
	rm -f ${D}${libdir}/charset.alias
}

FILES_${PN}-locale = "${localedir}"
