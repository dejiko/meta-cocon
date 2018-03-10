DESCRIPTION = "GTK+ applet for NetworkManager (GTK+2)" 
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

DEPENDS = "libnotify libsecret networkmanager dbus-glib gconf libgnome-keyring iso-codes"

inherit gnomebase gsettings gtk-icon-cache

GNOME_COMPRESS_TYPE = "xz"

# GTK2.x mode
EXTRA_OECONF += " \
    --with-gtkver=2 \
    --with-bluetooth=no \
    --disable-migration \
"

do_configure_prepend() {
  sed -e 's,Gtk-3.0,Gtk-2.0,' -i ${S}/src/libnm-gtk/Makefile.in
}

do_configure_append() {
    rm config.log
    # Sigh... --enable-compile-warnings=no doesn't actually turn off -Werror
    for i in $(find ${S} -name "Makefile") ; do
        sed -i -e s:-Werror::g $i
    done

#    sed -i -e 's/ -shared / -Wl,-O1,--as-needed\0/g' ${S}/libtool
}

RDEPENDS_${PN} =+ "networkmanager"

FILES_${PN} += " \
    ${datadir}/nm-applet/ \
    ${datadir}/libnm-gtk/wifi.ui \
"

FILES_${PN} += "${libdir}/gnome-bluetooth/plugins/*.so"
FILES_${PN}-dev += "${libdir}/gnome-bluetooth/plugins/libnma.la"
FILES_${PN}-staticdev += "${libdir}/gnome-bluetooth/plugins/libnma.a"
FILES_${PN}-dbg += "${libdir}/gnome-bluetooth/plugins/.debug/"

SRC_URI[archive.md5sum] = "5148348c139229c6a753f815f3f11e1c"
SRC_URI[archive.sha256sum] = "46fee9a1e667d1826e6a94bb6bd2e6bdbde535fc995e534542f5f7e8b8dae0cb"

