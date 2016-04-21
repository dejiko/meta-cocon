inherit kernel
require recipes-kernel/linux/linux.inc
require recipes-kernel/linux/linux-dtb.inc

LINUX_VERSION = "${PV}"

S = "${WORKDIR}/linux-${PV}"
B = "${S}"

COMPATIBLE_MACHINE = "ac100"

SRC_URI = " ${KERNELORG_MIRROR}/linux/kernel/v3.0/linux-${PV}.tar.xz;name=kernel\
            git://git.code.sf.net/p/aufs/aufs3-standalone;protocol=http;branch=aufs3.18.25+;name=aufs \
    file://defconfig \
"

SRC_URI[kernel.md5sum] = "fb3ef8da32a25607807887b9567a6927"
SRC_URI[kernel.sha256sum] = "2c6aec73fd868db12d29dfa2dc34d6cfa04b0e3e5ae65be34c2cb30243470e2e"
SRCREV_aufs = "2f300e0b36822fe97abcc06ef28d8366e7c1a894"

do_configure_prepend() {
  # Extract aufs tree to Linux tree
  if [ ! -e ${S}/.cocon.aufs-patched ];
  then
    cd ${S}
    patch -p1 <${WORKDIR}/git/aufs3-kbuild.patch
    patch -p1 <${WORKDIR}/git/aufs3-base.patch
    patch -p1 <${WORKDIR}/git/aufs3-mmap.patch
    patch -p1 <${WORKDIR}/git/aufs3-standalone.patch
    cp -R ${WORKDIR}/git/fs/* ./fs/
    cp -R ${WORKDIR}/git/include/uapi/linux/aufs_type.h ./include/uapi/linux/

    cp ${WORKDIR}/defconfig ${S}/.config

    touch ${S}/.cocon.aufs-patched
  fi

  install ${WORKDIR}/defconfig ${S}/.config
}

do_compile_append() {
    oe_runmake dtbs

    # Combine (Adhoc)
    mv ${S}/arch/arm/boot/zImage ${S}/arch/arm/boot/zImage.org
    cat ${S}/arch/arm/boot/zImage.org arch/arm/boot/dts/tegra20-paz00.dtb > ${S}/arch/arm/boot/zImage
}


