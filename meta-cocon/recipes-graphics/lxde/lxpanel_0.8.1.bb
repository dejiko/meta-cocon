DESCRIPTION = "LXDE Panel"
SECTION = "x11"
DEPENDS = "libwnck menu-cache glib-2.0 gtk+ gdk-pixbuf libfm keybinder alsa-lib"
LICENSE = "GPLv2"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.xz"

inherit autotools gettext pkgconfig

RDEPENDS_${PN} = "menu-cache gettext wireless-tools gdk-pixbuf"
FILES_${PN}-dbg += "${libdir}/lxpanel/plugins/.debug \
                    ${libdir}/lxpanel/liblxpanel.so"

LIC_FILES_CHKSUM = "file://COPYING;md5=9d19a9495cc76dc96b703fb4aa157183"

EXTRA_OECONF += "--with-plugins='volumealsa,batt,xkb,monitors'"

SRC_URI[md5sum] = "6ea8dea8dc6c781b7adfbccbcd59c512"
SRC_URI[sha256sum] = "c657eb049a0f59e7b2d1ad6cb621c272833b765705c19089e48b3c248351b1e0"

