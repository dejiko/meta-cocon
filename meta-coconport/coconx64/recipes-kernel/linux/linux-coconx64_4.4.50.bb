inherit kernel
require recipes-kernel/linux/linux.inc

LINUX_VERSION = "${PV}"

S = "${WORKDIR}/linux-${PV}"
B = "${S}"

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v4.x/linux-${PV}.tar.xz;name=kernel \
           file://defconfig \
"

SRC_URI[kernel.md5sum] = "6f7f4cb7ceaac770eadf0c7a18ef5225"
SRC_URI[kernel.sha256sum] = "e4944ca5bb0bdf63a7e97dc7fbdd38bcc820d8b3b57c4a3a7b3bf9c8a48216b7"

COMPATIBLE_MACHINE = "coconx64"


