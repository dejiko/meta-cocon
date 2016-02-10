SUMMARY = "A lightweight web browser"
HOMEPAGE = "http://midori-browser.org/"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"
DEPENDS = "webkitgtk libsoup-2.4 gcr python-native python-docutils-native \
           librsvg-native libnotify libunique gtk+3"

SRC_URI = "http://www.midori-browser.org/downloads/${BPN}_${PV}_all_.tar.bz2 \
"
SRC_URI[md5sum] = "fcc03ef759fce4fe9f2446d9da4a065e"
SRC_URI[sha256sum] = "96191a96be71144ae848a409fae5a1d6d52a00e583f33122081f47ead9c49c3d"

# midori depends on webkit-gtk, and webkit-gtk can NOT be built on
# MIPS64 with n32 ABI. So remove it from mips64 n32 temporarily.
COMPATIBLE_HOST_mips64 = "mips64.*-linux$"

inherit gtk-icon-cache pkgconfig vala pythonnative cmake

EXTRA_OECMAKE += " -DHALF_BRO_INCOM_WEBKIT2=1 -DUSE_GTK3=1 -DUSE_APIDOCS=0 -DUSE_ZEITGEIST=0"

TARGET_CC_ARCH += "${LDFLAGS}"

RRECOMMENDS_${PN} += "glib-networking ca-certificates gnome-icon-theme"

FILES_${PN} += "${datadir}/appdata/midori.appdata.xml"
FILES_${PN}-dev += "${datadir}/vala/vapi"
