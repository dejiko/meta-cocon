# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_libc-musl += "file://musl-arm-inb-outb.patch \
                             file://kdrive-musl.patch"

EXTRA_OECONF += " --enable-xephyr --enable-kdrive --enable-install-setuid"

LIB_DEPS += "libx11 libxv xcb-util-image xcb-util-keysyms xcb-util-wm xcb-util-renderutil"

