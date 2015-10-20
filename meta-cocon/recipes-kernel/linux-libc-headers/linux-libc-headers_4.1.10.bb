KORG_ARCHIVE_COMPRESSION = "xz"

require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v4.x/linux-${PV}.tar.xz"
SRC_URI[md5sum] = "16953359a8c245d478294af65fd756a8"
SRC_URI[sha256sum] = "5724e7c099afa4c442dcea64ce13aea66b66915ef629b79c21d6df46c5cfbabe"

