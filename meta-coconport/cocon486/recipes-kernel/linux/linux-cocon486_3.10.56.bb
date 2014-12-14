inherit kernel
require recipes-kernel/linux/linux.inc

LINUX_VERSION = "${PV}"

S = "${WORKDIR}/linux-${PV}"

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v3.0/linux-${PV}.tar.xz;name=kernel \
           git://git.code.sf.net/p/aufs/aufs3-standalone;protocol=http;branch=aufs3.10.x;name=aufs \
           https://github.com/biergaizi/sm712fb/archive/master.zip;name=sm712 \
	   file://platform_driver_probe.patch \
	   file://pd6729.patch \
           file://defconfig \
           file://sm712fb-cocon.patch \
           file://sm712fb-800x600.patch \
           file://pata_legacy.patch \
"


SRCREV_aufs = "6faf71020cbf01bd20520556b5ea46542711922a"
SRC_URI[sm712.md5sum] = "e06b8a4a6086ae03dbb44c7833011a59"
SRC_URI[sm712.sha256sum] = "76d7e2a41466eba5fa61d771874ce3f397623398f962c82a1310a70cf8e57166"

COMPATIBLE_MACHINE = "cocon486"

do_configure_prepend() {
        install ${WORKDIR}/defconfig ${WORKDIR}/linux-${PV}/.config
        cd ${WORKDIR}/linux-${PV}
        oe_runmake oldconfig
}


# apply patches without quilt
do_patch() {
        # Extract aufs tree to Linux tree

	cd ${WORKDIR}/linux-${PV}
        patch -p1 <${WORKDIR}/git/aufs3-kbuild.patch
	patch -p1 <${WORKDIR}/git/aufs3-base.patch
        patch -p1 <${WORKDIR}/git/aufs3-mmap.patch
	patch -p1 <${WORKDIR}/git/aufs3-standalone.patch

	cp -R ${WORKDIR}/git/fs/* ./fs/
        cp -R ${WORKDIR}/git/include/uapi/linux/aufs_type.h ./include/uapi/linux/

        # sm712 patches
        cp -R ${WORKDIR}/sm712fb-master/sm712fb ./drivers/video/
#        patch -p1 <${WORKDIR}/sm712fb-800x600.patch
        patch -p1 <${WORKDIR}/sm712fb-cocon.patch


        # Other patches
	patch -p1 <${WORKDIR}/pd6729.patch
	patch -p1 <${WORKDIR}/platform_driver_probe.patch
        patch -p1 <${WORKDIR}/pata_legacy.patch
}


