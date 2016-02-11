SUMMARY = "SPICE Protocol"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=b37311cb5604f3e5cc2fb0fd23527e95"

#DEPENDS = "celt cyrus-sasl gtk+ jpeg pulseaudio zlib libusb"

inherit autotools gettext pkgconfig

SRC_URI = "http://spice-space.org/download/releases/spice-protocol-${PV}.tar.bz2"

#EXTRA_OECONF += "--without-python --disable-gtk-doc-html --disable-gtk-doc --with-gtk=2.0 --enable-smartcard=no --enable-introspection=no"

#PACKAGES += "${PN}-vala"
#FILES_${PN}-vala += "${datadir}/vala/*"


BBCLASSEXTEND = "native nativesdk"

SRC_URI[md5sum] = "1fb9d0dcdd42dce1b476ae8aa7569bcc"
SRC_URI[sha256sum] = "788f0d7195bec5b14371732b562eb55ca82712aab12273b0e87529fb30532efb"
