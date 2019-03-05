DESCRIPTION = "An Open-Source Cross-platform Multi-protocol VPN Program"
AUTHOR = "SoftEther Project at University of Tsukuba, Japan."
HOMEPAGE = "https://github.com/SoftEtherVPN/"
SECTION = "net"
PRIORITY = "optional"
LICENSE = "GPLv2"

SRC_URI = "gitsm://github.com/SoftEtherVPN/SoftEtherVPN.git;branch=master \
"

SRCREV = "a25fea0809eaf3e2397584588cab40511f69037d"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

LIC_FILES_CHKSUM = "file://LICENSE;md5=80bcfc91c01fb22ea037ed8afa5bbe75"

