DESCRIPTION = "An Open-Source Cross-platform Multi-protocol VPN Program"
AUTHOR = "SoftEther Project at University of Tsukuba, Japan."
HOMEPAGE = "https://github.com/SoftEtherVPN/"
SECTION = "net"
PRIORITY = "optional"
LICENSE = "GPLv2"

SRC_URI = "git://github.com/SoftEtherVPN/SoftEtherVPN.git;branch=master \
"

SRCREV = "4df2eb4f9c2a8cf50e0123496bc20470edc21dc4"

S = "${WORKDIR}/git"

do_configure() {
    # Copy linux-32bit makefile
    # TODO : 64bit

    if [ "$TARGET_ARCH" = "x86_64" ];
    then
        cp ${S}/src/makefiles/linux_64bit.mak ${S}/Makefile
    else
        cp ${S}/src/makefiles/linux_32bit.mak ${S}/Makefile
    fi
}

LIC_FILES_CHKSUM = "file://LICENSE;md5=e877766b4a0fc05772993084f765afc7"

