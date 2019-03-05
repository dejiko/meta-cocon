# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Packagegroup for opencocon VPN extention"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit packagegroup

RDEPENDS_${PN} = " \
xl2tpd \
openssh-ssh \
strongswan \
openvpn \
pptp-linux \
softether-hamcore \
softether-vpnclient \
softether-vpncmd \
"

