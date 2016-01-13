DESCRIPTION = "NetworkManager"
SECTION = "net/misc"
LICENSE = "GPLv2"
PRIORITY = "optional"
DEPENDS = "networkmanager libnl dbus dbus-glib wireless-tools polkit gnutls util-linux ppp libglade"
RDEPENDS_${PN} = "wpa-supplicant dhcp-client \
           ${@base_contains('COMBINED_FEATURES', '3gmodem', 'ppp', '', d)} \
           "
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

EXTRA_OECONF = " \
		--with-distro=debian \
		--with-crypto=gnutls \
		--disable-more-warnings"

inherit autotools pkgconfig

PR = "r0"

SRC_URI += "${GNOME_MIRROR}/NetworkManager-pptp/0.9/NetworkManager-pptp-${PV}.tar.xz \
"

S = "${WORKDIR}/NetworkManager-pptp-${PV}"

FILES_${PN} += " \
		${libdir}/NetworkManager/*.so \
		${datadir}/gnome-vpn-properties \
		${datadir}/icons \
                ${libdir}/pppd/2.4.5/*.so"

SRC_URI[md5sum] = "37bad4600d4e26a6267ad425d16da3cf"
SRC_URI[sha256sum] = "34d0981462d8948ace0dd4f49478c86017b53516afbbf62e2a4c6c0adc679cc8"

