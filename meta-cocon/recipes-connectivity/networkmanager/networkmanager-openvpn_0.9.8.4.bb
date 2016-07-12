DESCRIPTION = "NetworkManager"
SECTION = "net/misc"
LICENSE = "GPLv2"
PRIORITY = "optional"
DEPENDS = "networkmanager libnl dbus dbus-glib wireless-tools polkit gnutls util-linux ppp libgnome-keyring gtk+"
RDEPENDS_${PN} = "wpa-supplicant dhcp-client \
           ${@base_contains('COMBINED_FEATURES', '3gmodem', 'ppp', '', d)} \
           "
LIC_FILES_CHKSUM = "file://COPYING;md5=100d5a599bead70ddcd70dcd73f2e29c"

EXTRA_OECONF = " --with-gtkver=2 \
		--disable-more-warnings"

inherit autotools pkgconfig

SRC_URI += "${GNOME_MIRROR}/NetworkManager-openvpn/0.9/NetworkManager-openvpn-${PV}.tar.xz \
"

S = "${WORKDIR}/NetworkManager-openvpn-${PV}"

FILES_${PN} += " \
		${libdir}/NetworkManager/*.so \
		${datadir}/gnome-vpn-properties \
		${datadir}/icons "
FILES_${PN}-dev += "${libdir}/NetworkManager/libnm-openvpn-properties.la"
FILES_${PN}-staticdev += "${libdir}/NetworkManager/libnm-openvpn-properties.a"
FILES_${PN}-dbg += "${libdir}/NetworkManager/.debug/*"

SRC_URI[md5sum] = "afe11c50ce63bd251e50a2f1b20af654"
SRC_URI[sha256sum] = "af8c52b6a61af3c178eed1ea8f1d4704bea87331fde43deb3d4aafe1821e6687"

