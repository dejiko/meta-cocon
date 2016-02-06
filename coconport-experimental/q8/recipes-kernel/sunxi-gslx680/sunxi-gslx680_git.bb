SUMMARY = "gslx680 driver for the sunxi (Allwinner) platform"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"


inherit module

SRC_URI = "git://github.com/jabjoe/sunxi-gslx680.git;protocol=https;branch=master"
SRCREV =  "c8a91b8290aca8cd5f1329292d53e8bfe88c7f68"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX} SYSROOT=${STAGING_DIR_TARGET}"
export KERNEL_PATH

INHIBIT_PACKAGE_STRIP = "1"

do_compile_prepend() {
  sed -i -e 's,arm-linux-gnueabihf-,${CC},g' \
         -e "s,..\/build\/a13_defconfig-linux,${KERNEL_SRC},g" \
         ${S}/Makefile
}

do_install(){
	install -d ${D}/lib/modules/${KERNEL_VERSION}
	install -d ${D}${bindir}
	install -m 644 ${B}/bin/ar.ko ${D}/lib/modules/${KERNEL_VERSION}/
	cp -f ${S}/bin/ar_* ${D}${bindir}/ 
}

FILES_${PN} += "${bindir}/"

COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i)"
