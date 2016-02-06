# for sunxi
require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

PV = "4.3+4.4rc5.git${SRCPV}"
SRCREV_pn-${PN} = "9f9499ae8e6415cefc4fe0a96ad0e27864353c89"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=git;branch=master"

S = "${WORKDIR}/git"
