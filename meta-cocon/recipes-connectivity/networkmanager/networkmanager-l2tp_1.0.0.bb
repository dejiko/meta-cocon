DESCRIPTION = "NetworkManager L2TP support"
SECTION = "net/misc"
LICENSE = "GPLv2"
PRIORITY = "optional"
DEPENDS = "networkmanager libnl dbus dbus-glib polkit gnutls ppp libgnome-keyring"
RDEPENDS_${PN} = "wpa-supplicant dhcp-client \
           ${@base_contains('COMBINED_FEATURES', '3gmodem', 'ppp', '', d)} \
           "
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

S = "${WORKDIR}/network-manager-l2tp-${PV}"

inherit autotools pkgconfig

SRC_URI = "https://github.com/nm-l2tp/${PN}/archive/${PV}.tar.gz"


EXTRA_OECONF = " --without-gnome "

FILES_${PN} += "${libdir}/NetworkManager/*.so \
		${datadir}/gnome-vpn-properties \
		${datadir}/icons \
                ${libdir}/pppd/*/*.so "
FILES_${PN}-dev += "${libdir}/NetworkManager/libnm-l2tp-properties.la \
                ${libdir}/pppd/*/nm-l2tp-pppd-plugin.la "
FILES_${PN}-staticdev += "${libdir}/NetworkManager/libnm-l2tp-properties.a \
                ${libdir}/pppd/*/nm-l2tp-pppd-plugin.a "
FILES_${PN}-dbg += "${libdir}/NetworkManager/.debug/* \
                ${libdir}/pppd/*/.debug/* "

SRC_URI[md5sum] = "3ba15ecc7c5f8bff116d41975390bbd3"
SRC_URI[sha256sum] = "3ef5204a4aaeebcea74cdeed10ebea49e18a7004a3146c7044083b1d165ff91f"

