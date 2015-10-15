SUMMARY = "A lightweight web browser"
HOMEPAGE = "http://midori-browser.org/"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"
DEPENDS = "webkit-gtk libsoup-2.4 openssl python-native python-docutils-native librsvg-native libnotify libunique"

SRC_URI = "http://pkgs.fedoraproject.org/repo/pkgs/midori/midori_0.5.8_all_.tar.bz2/b89e25e74199d705e74767499a415976/${BPN}_${PV}_all_.tar.bz2 \
"
SRC_URI[md5sum] = "b89e25e74199d705e74767499a415976"
SRC_URI[sha256sum] = "af19135fd4c4b04345df4d3592e7939c20f9b40eaca24550e6cb619751aa9381"

# midori depends on webkit-gtk, and webkit-gtk can NOT be built on
# MIPS64 with n32 ABI. So remove it from mips64 n32 temporarily.
COMPATIBLE_HOST_mips64 = "mips64.*-linux$"

inherit gtk-icon-cache pkgconfig vala pythonnative cmake


do_unpack() {
  # Extract manually : tarball of 0.5.8 is not contain on midori-${PV} directory
  tar -xjf ${DL_DIR}/${BPN}_${PV}_all_.tar.bz2  -C ${S}
}

EXTRA_OECMAKE = " -DUSE_ZEITGEIST=0"

#do_configure() {
#    sed -i -e 's:, shell=False::g' -e s:/usr/X11R6/include::g -e s:/usr/X11R6/lib::g wscript
#    ./configure \
#            --prefix=${prefix} \
#            --bindir=${bindir} \
#            --sbindir=${sbindir} \
#            --libexecdir=${libexecdir} \
#            --datadir=${datadir} \
#            --sysconfdir=${sysconfdir} \
#            --sharedstatedir=${sharedstatedir} \
#            --localstatedir=${localstatedir} \
#            --libdir=${libdir} \
#            --includedir=${includedir} \
#            --infodir=${infodir} \
#            --mandir=${mandir} \
#            --disable-gtk3 \
#            --disable-zeitgeist \
#}

PARALLEL_MAKE = ""
TARGET_CC_ARCH += "${LDFLAGS}"

#do_install() {
#    oe_runmake DESTDIR=${D} install
#}

RRECOMMENDS_${PN} += "glib-networking ca-certificates gnome-icon-theme"

FILES_${PN}-dev += "${datadir}/vala/vapi"
