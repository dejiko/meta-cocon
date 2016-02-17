# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_libc-musl += "file://strongswan-5.3.2-fix-with-musl.patch"

