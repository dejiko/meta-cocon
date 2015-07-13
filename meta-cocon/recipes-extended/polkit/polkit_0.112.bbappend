# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_libc-uclibc += "file://polkit-0.111-uclibc-netgroup.patch \
"

