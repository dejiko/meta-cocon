SECTION = "kernel"
DESCRIPTION = "Mainline Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel

require recipes-kernel/linux/linux.inc

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v4.x/linux-${PV}.tar.xz;name=kernel"
S = "${WORKDIR}/linux-${PV}"

SRC_URI[kernel.md5sum] = "d8f9218277a3f0d2e1703676002be428"
SRC_URI[kernel.sha256sum] = "5bfd9ed52c1ccd8dcd6418646d5a78b0af501cfdcd3e0900f1918ecba1a8af97"

