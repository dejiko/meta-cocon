DESCRIPTION = "An initramfs module with UI for selection of boot device."
#RDEPENDS_${PN} = "initramfs-uniboot"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
SRC_URI = "file://30-bootmenu-crusoe.sh \
"

do_install() {
	install -d ${D}/initrd.d
        install -m 0755 ${WORKDIR}/30-bootmenu-crusoe.sh ${D}/initrd.d/
	#install -m 0755 ${WORKDIR}/udev-cocon ${D}/initrd.d/
}

PACKAGE_ARCH = "all"
FILES_${PN} += " /initrd.d/* "
