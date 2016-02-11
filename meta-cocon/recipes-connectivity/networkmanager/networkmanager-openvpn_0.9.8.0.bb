DESCRIPTION = "NetworkManager"
SECTION = "net/misc"
LICENSE = "GPLv2"
PRIORITY = "optional"
DEPENDS = "networkmanager libnl dbus dbus-glib wireless-tools polkit gnutls util-linux ppp libglade"
RDEPENDS_${PN} = "wpa-supplicant dhcp-client \
           ${@base_contains('COMBINED_FEATURES', '3gmodem', 'ppp', '', d)} \
           "
LIC_FILES_CHKSUM = "file://COPYING;md5=100d5a599bead70ddcd70dcd73f2e29c"

EXTRA_OECONF = " \
		--disable-more-warnings"

inherit autotools pkgconfig

SRC_URI += "${GNOME_MIRROR}/NetworkManager-openvpn/0.9/NetworkManager-openvpn-${PV}.tar.xz \
"

S = "${WORKDIR}/NetworkManager-openvpn-${PV}"

FILES_${PN} += " \
		${libdir}/NetworkManager/*.so \
		${datadir}/gnome-vpn-properties \
		${datadir}/icons "

SRC_URI[md5sum] = "6699552a550a18db9edb037951a81d62"
SRC_URI[sha256sum] = "4196f4c124426884657c8d0e2578f4d35205b8981a46bf645fd599fb238395ce"

