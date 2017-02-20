FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append += "file://include_netinet-in.h_before_linux-in.h.patch"

do_install_append_libc-musl() {
  mkdir -p ${D}${includedir}/net/
  install -m 0755 ${S}/include/net/ppp_defs.h ${D}${includedir}/net/
}

