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

#SRCREV_aufs = "269a613efab1718fd587c2bfc945d095b57f56e2"
SRC_URI[kernel.md5sum] = "929e74f2e29e1b41d69e45c04d712c9e"
SRC_URI[kernel.sha256sum] = "c649874e2856101df7cefe5fdad313ebb2282a939fc1e95cf02222327745ff92"

do_configure_prepend() {
    install ${WORKDIR}/defconfig ${S}/.config
}

do_compile_append() {
    oe_runmake dtbs

    # Combine (Adhoc)
    mv ${S}/arch/arm/boot/zImage ${S}/arch/arm/boot/zImage.org
    cat ${S}/arch/arm/boot/zImage.org arch/arm/boot/dts/tegra20-paz00.dtb > ${S}/arch/arm/boot/zImage
}


