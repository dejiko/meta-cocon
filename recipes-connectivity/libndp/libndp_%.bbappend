FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append_libc-musl += "file://musl-fd_set.patch"
