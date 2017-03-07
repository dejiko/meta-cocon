# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

EXTRA_OECONF_linux-uclibc += " ac_cv_tls=no "

DEPENDS += " libcheck "

do_install_append() {
  # current opencocon : not need udev hock
  rm ${D}${base_libdir}/udev/rules.d/*.rules 
}

