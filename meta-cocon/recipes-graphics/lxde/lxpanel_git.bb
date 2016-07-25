DESCRIPTION = "LXDE Panel"
SECTION = "x11"
DEPENDS = "libwnck menu-cache glib-2.0 gtk+ gdk-pixbuf libfm keybinder alsa-lib"
LICENSE = "GPLv2"

SRC_URI = "git://git.lxde.org/git/lxde/lxpanel.git;protocol=http"
SRCREV = "40bb034a2e7c2f16242b33d98082a45bd4ccabdd"

inherit autotools gettext pkgconfig autotools-brokensep

RDEPENDS_${PN} = "menu-cache gettext wireless-tools gdk-pixbuf"
FILES_${PN}-dbg += "${libdir}/lxpanel/plugins/.debug \
                    ${libdir}/lxpanel/liblxpanel.so"

LIC_FILES_CHKSUM = "file://COPYING;md5=9d19a9495cc76dc96b703fb4aa157183"

EXTRA_OECONF += "--with-plugins='volumealsa,batt,xkb,monitors' --disable-gtk3"

S = "${WORKDIR}/git"

