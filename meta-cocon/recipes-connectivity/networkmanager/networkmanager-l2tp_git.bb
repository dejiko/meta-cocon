DESCRIPTION = "NetworkManager"
SECTION = "net/misc"
LICENSE = "GPLv2"
PRIORITY = "optional"
DEPENDS = "networkmanager libnl dbus dbus-glib wireless-tools polkit gnutls util-linux ppp libglade gnome-keyring xl2tpd"
RDEPENDS_${PN} = "wpa-supplicant dhcp-client \
           ${@base_contains('COMBINED_FEATURES', '3gmodem', 'ppp', '', d)} \
           "
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

EXTRA_OECONF = " \
		--with-distro=debian \
		--with-crypto=gnutls \
		--disable-more-warnings \
                --without-gnome"

inherit autotools pkgconfig


SRCREV = "79fd238a2d1d91725c4bb3a71a08546e5daf03d1"


SRC_URI = "git://github.com/seriyps/NetworkManager-l2tp.git"

S = "${WORKDIR}/git"

FILES_${PN} += " \
		${libdir}/NetworkManager/*.so \
		${datadir}/gnome-vpn-properties \
		${datadir}/icons \
                ${libdir}/pppd/2.4.5/*.so "


