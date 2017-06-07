# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://NetworkManager"

#SRC_URI_append_libc-musl += "file://new-fix-musl-headers.patch \
#                             file://disable_set_hostname.patch \
#"

#RDEPENDS_${PN} += "polkit libnewt"
#PACKAGECONFIG = "consolekit modemmanager ppp"

#do_configure_prepend() {
#    # exclude systemd-related source tree (from alpine)
#    files=$(find ${S}/src/dhcp-manager/systemd-dhcp -type f)
#    files="$files $(find ${S}/src/dhcp-manager -maxdepth 1 -type f -name "*-systemd.*")"
#    for f in $files; do
#        printf "" > $f
#    done
#}

do_install_append() {
  # init.d style
  install -d ${D}${sysconfdir}/init.d
  install -m 0755 ${WORKDIR}/NetworkManager ${D}${sysconfdir}/init.d/NetworkManager
}

inherit update-rc.d

INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME_${PN} = "NetworkManager"
INITSCRIPT_PARAMS_${PN} = "start 05 5 . stop 01 0 6 ."

