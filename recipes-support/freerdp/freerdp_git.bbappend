FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_libc-musl += "file://1.2.5-musl-fix.diff"

# Overwrite SRCREV
SRCREV = "5b2455f3147aca395a441fc65b602938600f0788"

do_install_prepend () {
    # compatible with current meta-oe recipe.
    ln -sf ${B}/winpr/tools/makecert-cli ${B}/winpr/tools/makecert/cli
}


DEPENDS_append_libc-musl += "bsd-headers"
