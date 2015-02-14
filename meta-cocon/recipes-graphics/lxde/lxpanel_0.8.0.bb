DESCRIPTION = "LXDE Panel"
SECTION = "x11"
DEPENDS = "libwnck menu-cache glib-2.0 gtk+ gdk-pixbuf libfm keybinder"
LICENSE = "GPLv2"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.xz"


inherit autotools gettext

RDEPENDS_${PN} = "menu-cache gettext wireless-tools gdk-pixbuf"
FILES_${PN}-dbg += "${libdir}/lxpanel/plugins/.debug \
                    ${libdir}/lxpanel/liblxpanel.so"

LIC_FILES_CHKSUM = "file://COPYING;md5=9d19a9495cc76dc96b703fb4aa157183"

EXTRA_OECONF += "--with-plugins='volumealsa,batt,xkb,monitors'"

# --enable-indicator-support

SRC_URI[md5sum] = "aa5bc73f4fe1d8006248a1f45f0a8a21"
SRC_URI[sha256sum] = "94dd664ed6c7c001ca83959cdeadaa386ba0d2c91f113c2e6d318a5f33604415"

