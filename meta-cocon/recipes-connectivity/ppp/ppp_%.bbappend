FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

do_install_append_libc-musl() {
  mkdir -p ${D}${includedir}/net/
  install -m 0755 ${S}/include/net/ppp_defs.h ${D}${includedir}/net/
}

