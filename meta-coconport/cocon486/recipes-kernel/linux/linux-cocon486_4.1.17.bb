inherit kernel
require recipes-kernel/linux/linux.inc

LINUX_VERSION = "${PV}"

S = "${WORKDIR}/linux-${PV}"
B = "${S}"

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v4.x/linux-${PV}.tar.xz;name=kernel \
           git://github.com/sfjro/aufs4-standalone.git;protocol=http;branch=aufs4.1.13+;name=aufs \
           file://pata_legacy.patch \
           file://defconfig \
"

SRC_URI[kernel.md5sum] = "4b0bd6b3775170ce0f76ef219ac279d8"
SRC_URI[kernel.sha256sum] = "4b19988e252d4a954d86f9a5aa2d32e11e6131ad182f25b3a447d4b753909120"
SRCREV_aufs = "7254f7820ca90483896d2796b90b2a3028cdb0dc"

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


