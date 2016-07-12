# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

EXTRA_OECONF_linux-uclibc += " ac_cv_tls=no "

DEPENDS += " libcheck "
