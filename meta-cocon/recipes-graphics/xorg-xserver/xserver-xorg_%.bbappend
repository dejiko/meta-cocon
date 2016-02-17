# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

EXTRA_OECONF += " --enable-xephyr --enable-kdrive --enable-install-setuid"

LIB_DEPS += "libx11 libxv xcb-util-image xcb-util-keysyms xcb-util-wm xcb-util-renderutil"

do_compile_prepend_linux-musl() {
	sed -i -e s:'__uid_t':'uid_t':g \
	    -i -e s:'__gid_t':'gid_t':g \
	${S}/hw/kdrive/linux/linux.c
}
