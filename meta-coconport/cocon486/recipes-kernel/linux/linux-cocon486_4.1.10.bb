inherit kernel
require recipes-kernel/linux/linux.inc

LINUX_VERSION = "${PV}"

S = "${WORKDIR}/linux-${PV}"

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v4.x/linux-${PV}.tar.xz;name=kernel \
           git://github.com/sfjro/aufs4-standalone.git;protocol=http;branch=aufs4.1;name=aufs \
           file://pata_legacy.patch \
           file://defconfig \
"

#SRC_URI[kernel.md5sum] = "6fce868a56f2d83f80cdad5fed457110"
#SRC_URI[kernel.sha256sum] = "5b8e223c569a5955717feadb0cc206647d2e6d1aceb2ddf21b8b736f5d278db9"
SRCREV_aufs = "4912d6da07e3e24d7a8484e0e8a4c1315adbc8fd"

COMPATIBLE_MACHINE = "cocon486"


#B = "${WORKDIR}/linux-${PACKAGE_ARCH}-build"


#do_configure_prepend() {
#  cd ${WORKDIR}/linux-${PV}
#  install ${WORKDIR}/defconfig ${WORKDIR}/linux-${PV}/.config
#
#  oe_runmake oldconfig
#}


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

  # Other patches
  #patch -p1 <${WORKDIR}/pata_legacy.patch

  #cd ${WORKDIR}/linux-${PV}
  cp ${WORKDIR}/defconfig ${B}/.config

#  oe_runmake oldconfig

}


