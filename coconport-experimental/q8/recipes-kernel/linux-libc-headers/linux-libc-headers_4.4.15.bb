# for sunxi
require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v4.x/linux-${PV}.tar.xz;name=kernel" 
SRC_URI[kernel.md5sum] = "7b59c25c783173969bfb62cac4f057ce"
SRC_URI[kernel.sha256sum] = "303634711f0f39806fdbfaae69f59be26b46ef45f080c7d801a26864e264acb0"

