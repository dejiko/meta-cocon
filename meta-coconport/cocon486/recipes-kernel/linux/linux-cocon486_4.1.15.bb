inherit kernel
require recipes-kernel/linux/linux.inc

LINUX_VERSION = "${PV}"

S = "${WORKDIR}/linux-${PV}"
B = "${S}"

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v4.x/linux-${PV}.tar.xz;name=kernel \
           git://github.com/sfjro/aufs4-standalone.git;protocol=http;branch=aufs4.1;name=aufs \
           file://pata_legacy.patch \
           file://defconfig \
"

SRC_URI[kernel.md5sum] = "b227333912b161c96ff3e30f5041e1c0"
SRC_URI[kernel.sha256sum] = "472288cc966188c5d7c511c6be0f78682843c9ca2d5d6c4d67d77455680359a3"
SRCREV_aufs = "161911a653aa5c14aba800c8ace0c5fcf2f8a51a"

COMPATIBLE_MACHINE = "cocon486"

# B = "${WORKDIR}/linux-{PV}"

# apply patches without quilt
do_configure_prepend() {
  # Extract aufs tree to Linux tree

  cd ${WORKDIR}/linux-${PV} 
  patch -p1 <${WORKDIR}/git/aufs4-kbuild.patch
  patch -p1 <${WORKDIR}/git/aufs4-base.patch
  patch -p1 <${WORKDIR}/git/aufs4-mmap.patch
  patch -p1 <${WORKDIR}/git/aufs4-standalone.patch
  cp -R ${WORKDIR}/git/fs/* ./fs/
  cp -R ${WORKDIR}/git/include/uapi/linux/aufs_type.h ./include/uapi/linux/

  cp ${WORKDIR}/defconfig ${B}/.config
}


