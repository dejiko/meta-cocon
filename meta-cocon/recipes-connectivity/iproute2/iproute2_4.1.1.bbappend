# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_libc-musl += "file://iproute2-4.0.0-fix-build-with-musl.patch \
                             file://iproute2-3.10.0-no-ipv6.patch \
                             file://musl-fixes-for-4.1.1.patch"

