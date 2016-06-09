FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

EXTRA_OECONF_append_libc-musl += " --disable-gnu-indirect-function "
