DESCRIPTION = "An Open-Source Cross-platform Multi-protocol VPN Program"
AUTHOR = "SoftEther Project at University of Tsukuba, Japan."
HOMEPAGE = "https://github.com/SoftEtherVPN/"
SECTION = "net"
PRIORITY = "optional"
LICENSE = "GPLv2"
#DEPENDS = "zlib ncurses openssl"

SRC_URI = "git://github.com/SoftEtherVPN/SoftEtherVPN.git;branch=master \
"

SRCREV = "5efab0381cc9bfc907114f1135005d3aa869776c"

S = "${WORKDIR}/git"

#EXTRA_OEMAKE += "'PREFIX=${D}${prefix} CC=${CC} -fomit-frame-pointer \
#                 ${CFLAGS}'"

do_configure() {
    # Copy linux-32bit makefile
    cp ${S}/src/makefiles/linux_32bit.mak ${S}/Makefile
}

#do_compile() {
#        oe_runmake ${EXTRA_OEMAKE}
#}


LIC_FILES_CHKSUM = "file://LICENSE;md5=bb2892df08b38bb8481923827d174b93"

