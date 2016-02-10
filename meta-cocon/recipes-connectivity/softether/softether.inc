DESCRIPTION = "An Open-Source Cross-platform Multi-protocol VPN Program"
AUTHOR = "SoftEther Project at University of Tsukuba, Japan."
HOMEPAGE = "https://github.com/SoftEtherVPN/"
SECTION = "net"
PRIORITY = "optional"
LICENSE = "GPLv2"

SRC_URI = "git://github.com/SoftEtherVPN/SoftEtherVPN.git;branch=master \
"

SRCREV = "d3a1b26413acf3b387475f9ec5c4cbd93c5ffffe"

S = "${WORKDIR}/git"

do_configure() {
    # Copy linux-32bit makefile
    # TODO : 64bit
    cp ${S}/src/makefiles/linux_32bit.mak ${S}/Makefile
}

LIC_FILES_CHKSUM = "file://LICENSE;md5=bb2892df08b38bb8481923827d174b93"

