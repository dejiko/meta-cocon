LICENSE = "GPLv2"
DEPENDS = "celt cyrus-sasl gtk+ jpeg pulseaudio zlib libusb"


SRC_URI = "http://spice-space.org/download/gtk/spice-gtk-${PV}.tar.bz2 " 


inherit autotools gettext


EXTRA_OECONF += "--without-python --disable-gtk-doc-html --disable-gtk-doc --with-gtk=2.0 --enable-smartcard=no --enable-introspection=no"

do_configure_prepend() {
    sed -i \
        -e s:HAVE_TERMIOS_H:COCON_TERMIOS_DISABLE:g \
        ${S}/gtk/spicy.c

    # spice-protocol fixes
    cp -R ${S}/m4 ${S}/spice-common/spice-protocol
    sed -i \
        -e "s:dist-bzip2:dist-bzip2 subdir-objects:g" \
        ${S}/spice-common/spice-protocol/configure.ac
    sed -i \
        -e "s:no-dist-gzip:no-dist-gzip subdir-objects:g" \
        ${S}/spice-common/configure.ac
    sed -i \
        -e "s:dist-bzip2:dist-bzip2 subdir-objects:g" \
        ${S}/configure.ac


}

CFLAGS += "-fno-stack-protector -O1"

PACKAGES += "${PN}-vala" 
FILES_${PN}-vala += "${datadir}/vala/*"

LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI[md5sum] = "722105732b37bbcd04c4051ff44c2fdd"
SRC_URI[sha256sum] = "5075e07010db434146649110ade31f5a6cdcdb4efbb4bedd40f1a977f090430c"

