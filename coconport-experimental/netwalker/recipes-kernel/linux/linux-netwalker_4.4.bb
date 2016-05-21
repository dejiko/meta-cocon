inherit kernel
require recipes-kernel/linux/linux.inc
require recipes-kernel/linux/linux-dtb.inc

LINUX_VERSION = "${PV}"

S = "${WORKDIR}/linux-${PV}"
B = "${S}"

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v4.x/linux-${PV}.tar.xz;name=kernel \
           file://makefile-add-netwalker-dts.patch \
           file://imx51-sharp-netwalker.dts \
           file://defconfig \
"

COMPATIBLE_MACHINE = "netwalker"

do_configure_prepend() {
  cp -R ${WORKDIR}/imx51-sharp-netwalker.dts ${S}/arch/arm/boot/dts/
}

do_compile_append() {
    oe_runmake dtbs

    # Combine (Adhoc)
    mv ${S}/arch/arm/boot/zImage ${S}/arch/arm/boot/zImage.org
    cat ${S}/arch/arm/boot/zImage.org arch/arm/boot/dts/imx51-sharp-netwalker.dts > ${S}/arch/arm/boot/zImage
}

SRC_URI[kernel.md5sum] = "9a78fa2eb6c68ca5a40ed5af08142599"
SRC_URI[kernel.sha256sum] = "401d7c8fef594999a460d10c72c5a94e9c2e1022f16795ec51746b0d165418b2"

