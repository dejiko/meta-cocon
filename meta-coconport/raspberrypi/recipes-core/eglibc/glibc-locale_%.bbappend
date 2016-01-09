# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# TODO : only on Raspberrypi
# COMPATIBLE_MACHINE = "raspberrypi"

# opencocon for Raspberrypi don't use eglibc-locale, but bitbake builds this
# recipe, so this bbappend is workaround.


# Do nothing.

do_install() {
    :
}
