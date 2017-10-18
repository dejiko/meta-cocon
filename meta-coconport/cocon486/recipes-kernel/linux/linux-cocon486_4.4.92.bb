inherit kernel
require recipes-kernel/linux/linux.inc

LINUX_VERSION = "${PV}"

S = "${WORKDIR}/linux-${PV}"
B = "${S}"

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v4.x/linux-${PV}.tar.xz;name=kernel \
           file://pata_legacy.patch \
           file://add-kme-kxlc005-0x2804.patch \
           file://defconfig \
"

COMPATIBLE_MACHINE = "cocon486"

SRC_URI[kernel.md5sum] = "ebf8185c276d94e76eae79aaa778e8da"
SRC_URI[kernel.sha256sum] = "53f8cd8b024444df0f242f8e6ab5147b0b009d7a30e8b2ed3854e8d17937460d"

