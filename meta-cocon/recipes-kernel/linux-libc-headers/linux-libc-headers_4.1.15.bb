KORG_ARCHIVE_COMPRESSION = "xz"

require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v4.x/linux-${PV}.tar.xz"
SRC_URI[md5sum] = "b227333912b161c96ff3e30f5041e1c0"
SRC_URI[sha256sum] = "472288cc966188c5d7c511c6be0f78682843c9ca2d5d6c4d67d77455680359a3"

