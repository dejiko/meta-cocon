DESCRIPTION = "LXDE Terminal"
SECTION = "x11"
DEPENDS = "vte"
LICENSE = "GPLv2"

SRC_URI = "git://git.lxde.org/git/lxde/lxterminal.git;protocol=http"
SRCREV = "be658ad344e330744abda053f01f2d46d2bdb1da"

inherit autotools gettext pkgconfig

DEPENDS = "gettext intltool glib-2.0 gtk+ vte"
RDEPENDS_${PN} = "vte"

LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"
FILES_${PN} += "${datadir}/icons/hicolor/128x128/apps/lxterminal.png"

S = "${WORKDIR}/git"

EXTRA_OECONF += "--disable-gtk3 "

do_configure_prepend() {
  # disable generate man
  sed -i -e s:'man':'':g ${S}/Makefile.am
}

