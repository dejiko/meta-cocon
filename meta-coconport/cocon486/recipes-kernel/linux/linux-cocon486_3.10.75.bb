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
           file://pata_legacy.patch \
"

SRC_URI[md5sum] = "688e92ff6f0132586fce97b10d8c2c4f"
SRC_URI[sha256sum] = "18987c2e9a8f5e2583b1ac5c2bed52777b8730ab29612a5b70c94fa17c659803"
SRCREV_aufs = "3ec542bfe6854491bceb77b40c46f3b63849445a"

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


