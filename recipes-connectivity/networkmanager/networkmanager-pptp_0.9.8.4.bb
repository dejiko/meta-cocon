DESCRIPTION = "NetworkManager"
SECTION = "net/misc"
LICENSE = "GPLv2"
PRIORITY = "optional"
DEPENDS = "networkmanager libnl dbus dbus-glib wireless-tools polkit gnutls util-linux ppp libgnome-keyring gtk+"
RDEPENDS_${PN} = "wpa-supplicant dhcp-client \
           ${@base_contains('COMBINED_FEATURES', '3gmodem', 'ppp', '', d)} \
           "
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

EXTRA_OECONF = " --with-gtkver=2 \
		--disable-more-warnings"

inherit autotools pkgconfig

SRC_URI += "${GNOME_MIRROR}/NetworkManager-pptp/0.9/NetworkManager-pptp-${PV}.tar.xz \
"

S = "${WORKDIR}/NetworkManager-pptp-${PV}"

FILES_${PN} += " \
		${libdir}/NetworkManager/*.so \
		${datadir}/gnome-vpn-properties \
		${datadir}/icons \
                ${libdir}/pppd/*/*.so"
FILES_${PN}-dev += "${libdir}/NetworkManager/libnm-pptp-properties.la \
                ${libdir}/pppd/*/nm-pptp-pppd-plugin.la "
FILES_${PN}-staticdev += "${libdir}/NetworkManager/libnm-pptp-properties.a \
                ${libdir}/pppd/*/nm-pptp-pppd-plugin.a "
FILES_${PN}-dbg += "${libdir}/NetworkManager/.debug/* \
                ${libdir}/pppd/*/.debug/* "

SRC_URI[md5sum] = "2d1f48ab2383aaba1cc4acb43a187320"
SRC_URI[sha256sum] = "97ba8f6f726056c3b8e0e1c8d2ab3d32791cadd7c3a38e0478fb2bd3ecafdce8"

