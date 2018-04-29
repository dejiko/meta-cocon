FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_libc-musl += "file://exiv2-0.26-musl.patch"

