inherit kernel
require recipes-kernel/linux/linux.inc
require recipes-kernel/linux/linux-dtb.inc

LINUX_VERSION = "${PV}"

S = "${WORKDIR}/linux-${PV}"
B = "${S}"

COMPATIBLE_MACHINE = "ac100"

SRC_URI = " ${KERNELORG_MIRROR}/linux/kernel/v3.0/linux-${PV}.tar.xz;name=kernel\
    file://defconfig \
"

SRC_URI[kernel.md5sum] = "fb3ef8da32a25607807887b9567a6927"
SRC_URI[kernel.sha256sum] = "2c6aec73fd868db12d29dfa2dc34d6cfa04b0e3e5ae65be34c2cb30243470e2e"


do_configure_prepend() {
    install ${WORKDIR}/defconfig ${S}/.config
}

do_compile_append() {
    oe_runmake dtbs

    # Combine (Adhoc)
    mv ${S}/arch/arm/boot/zImage ${S}/arch/arm/boot/zImage.org
    cat ${S}/arch/arm/boot/zImage.org arch/arm/boot/dts/tegra20-paz00.dtb > ${S}/arch/arm/boot/zImage
}


