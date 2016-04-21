# for sunxi
require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

#PV = "4.3+4.4rc5.git${SRCPV}"
#SRCREV_pn-${PN} = "9f9499ae8e6415cefc4fe0a96ad0e27864353c89"

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v4.x/linux-${PV}.tar.xz;name=kernel" 
#S = "${WORKDIR}/git"
SRC_URI[kernel.md5sum] = "efc822dad2149e40cc908718a4fea1d3"
SRC_URI[kernel.sha256sum] = "a3bccec4c28939355cd415672414583ecaf5531a87ddb44c9dc036aeacec577d"

