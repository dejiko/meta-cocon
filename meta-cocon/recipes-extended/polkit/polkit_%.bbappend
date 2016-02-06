# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# patch from : https://bugs.freedesktop.org/show_bug.cgi?id=50145
SRC_URI_append_libc-uclibc += "file://polkit-0.113-uclibc-netgroup.patch \
"

