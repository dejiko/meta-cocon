# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://NetworkManager"

do_install_append() {
  # init.d style
  install -d ${D}${sysconfdir}/init.d
  install -m 0755 ${WORKDIR}/NetworkManager ${D}${sysconfdir}/init.d/NetworkManager
}

inherit update-rc.d

INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME_${PN} = "NetworkManager"
INITSCRIPT_PARAMS_${PN} = "start 05 5 . stop 01 0 6 ."

