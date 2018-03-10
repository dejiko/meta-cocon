# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Packagegroup for opencocon VPN extention"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

inherit packagegroup

RDEPENDS_${PN} = " \
xl2tpd \
networkmanager-l2tp \
networkmanager-openvpn \
networkmanager-pptp \
openssh-ssh \
strongswan \
openvpn \
pptp-linux \
softether-hamcore \
softether-vpnclient \
softether-vpncmd \
"

