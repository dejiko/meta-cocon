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

SRC_URI[kernel.md5sum] = "d6430ac57c5f1830798095b7147908e4"
SRC_URI[kernel.sha256sum] = "d2a7a7536a5012cc2e6ab1ddf3d31320b4420cc4de3a4c2cda1daed8663bee09"

COMPATIBLE_MACHINE = "cocon486"


