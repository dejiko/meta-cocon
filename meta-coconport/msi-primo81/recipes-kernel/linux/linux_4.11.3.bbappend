FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://defconfig \
"

COMPATIBLE_MACHINE = "(sun4i|sun5i|sun6i|sun7i)"

COMPATIBLE_MACHINE = "msi-primo81"

require recipes-kernel/linux/linux-mainline-sunxi.inc

