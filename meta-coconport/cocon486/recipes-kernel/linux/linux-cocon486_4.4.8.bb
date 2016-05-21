inherit kernel
require recipes-kernel/linux/linux.inc

LINUX_VERSION = "${PV}"

S = "${WORKDIR}/linux-${PV}"
B = "${S}"

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v4.x/linux-${PV}.tar.xz;name=kernel \
           git://github.com/sfjro/aufs4-standalone.git;protocol=http;branch=aufs4.4;name=aufs \
           file://pata_legacy.patch \
           file://add-kme-kxlc005-0x2804.patch \
           file://defconfig \
"

SRCREV_aufs = "96236731c07a66db3ab1dcfe93aaa14f3074be14"
SRC_URI[kernel.md5sum] = "d6430ac57c5f1830798095b7147908e4"
SRC_URI[kernel.sha256sum] = "d2a7a7536a5012cc2e6ab1ddf3d31320b4420cc4de3a4c2cda1daed8663bee09"

COMPATIBLE_MACHINE = "cocon486"

# apply patches without quilt
do_configure_prepend() {
  # Extract aufs tree to Linux tree
  if [ ! -e ${S}/.cocon.aufs-patched ];
  then
    cd ${S} 
    patch -p1 <${WORKDIR}/git/aufs4-kbuild.patch
    patch -p1 <${WORKDIR}/git/aufs4-base.patch
    patch -p1 <${WORKDIR}/git/aufs4-mmap.patch
    patch -p1 <${WORKDIR}/git/aufs4-standalone.patch
    cp -R ${WORKDIR}/git/fs/* ./fs/
    cp -R ${WORKDIR}/git/include/uapi/linux/aufs_type.h ./include/uapi/linux/

    cp ${WORKDIR}/defconfig ${S}/.config

    touch ${S}/.cocon.aufs-patched
  fi
}


