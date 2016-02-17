# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://NetworkManager"

SRC_URI_append_libc-musl += "file://new-fix-musl-headers.patch \
                             file://exclude-systemd.patch"

RDEPENDS_${PN} += "polkit"

EXTRA_OECONF_append_libc-musl += "--with-systemdsystemunitdir=no"

do_install_append() {
  install -d ${D}${sysconfdir}/init.d
  install -m 0755 ${WORKDIR}/NetworkManager ${D}${sysconfdir}/init.d/NetworkManager
}

