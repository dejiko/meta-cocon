FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append += "file://xserver-nodm"

ROOTLESS_X = "1"

# force ROOTLESS X
do_install_append() {
	echo "xuser" > ${WORKDIR}/Xusername
	install -d ${D}${sysconfdir}/X11
	install ${WORKDIR}/Xusername ${D}${sysconfdir}/X11
}
