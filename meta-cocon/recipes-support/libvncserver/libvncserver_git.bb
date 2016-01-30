ESCRIPTION = "library for easy implementation of a RDP/VNC server"
AUTHOR = "Johannes Schindelin <dscho@users.sourceforge.net>"
HOMEPAGE = "http://sourceforge.net/projects/libvncserver/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv2"
DEPENDS = "zlib libjpeg-turbo libgcrypt libgcrypt-native gnutls"

SRC_URI = "git://github.com/LibVNC/libvncserver;protocol=git;branch=master \
	   file://acinclude.m4 \
"

SRCREV = "cf03f71780ace5db61f194bbe6c832f32fbc10f8"

S = "${WORKDIR}/git"

EXTRA_OECONF += " --without-x11vnc --disable-libtool-lock --without-websockets --with-gcrypt"

inherit autotools

do_configure_prepend() {
  # Exclude examples
  sed -i -e s:'client_examples':'':g ${S}/Makefile.am
}

LIC_FILES_CHKSUM = "file://COPYING;md5=361b6b837cad26c6900a926b62aada5f"

PACKAGES += " \
  ${PN}-client \
"

FILES_${PN}-client = "\
  ${libdir}/libvncclient.so* \
"

FILES_${PN}-server = "\
  ${libdir}/libvncserver.so* \
"

FILES_${PN}-dev = "\
  ${bindir}/libvncserver-config \
  ${includedir}/rfb/* \
  ${libdir}/libvncclient.la \
  ${libdir}/libvncserver.la \
  ${libdir}/pkgconfig/* \
  ${libdir}/libvnc*.so \
"


