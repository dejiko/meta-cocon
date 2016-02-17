SUMMARY = "SPICE Client"
LICENSE = "GPLv2"
DEPENDS = "celt cyrus-sasl gtk+ jpeg pulseaudio zlib libusb orc gstreamer1.0 \
           gstreamer1.0-plugins-base spice-protocol spice-protocol-native \
           python-six-native python-pyparsing-native"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

inherit autotools gettext pkgconfig pythonnative python-dir

EXTRA_OECONF += "--without-python --disable-gtk-doc-html --disable-gtk-doc --with-gtk=2.0 --enable-smartcard=no --enable-introspection=no"

SRC_URI = "http://spice-space.org/download/gtk/spice-gtk-${PV}.tar.bz2"

LDFLAGS_prepend_libc-uclibc = " -lssp "

do_configure_prepend_linux-uclibc() {
    sed -i \
        -e s:HAVE_TERMIOS_H:COCON_TERMIOS_DISABLE:g \
        ${S}/src/spicy.c
}

do_configure_prepend() {
    sed -i \
        -e 's:CODE_GENERATOR_BASEDIR=`pkg-config --variable=codegendir spice-protocol`:CODE_GENERATOR_BASEDIR=${STAGING_LIBDIR_NATIVE}/spice-protocol:g' \
        ${S}/spice-common/configure.ac
}

do_configure_append() {
        autoreconf --verbose --install --force --exclude=autopoint ${S}/spice-common
}

CFLAGS += "-fno-stack-protector"

PACKAGES += "${PN}-vala"
FILES_${PN}-vala += "${datadir}/vala/*"

SRC_URI[md5sum] = "723e0e9ce9d507ba5d6cd331a3a9b7fb"
SRC_URI[sha256sum] = "e23323fa399efba17b3c18475ef10a29815851be5e7dbedd246b28ee8eb1379c"

