SUMMARY = "SPICE Protocol"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=b37311cb5604f3e5cc2fb0fd23527e95"

inherit autotools gettext pkgconfig

SRC_URI = "http://spice-space.org/download/releases/spice-protocol-${PV}.tar.bz2"

BBCLASSEXTEND = "native nativesdk"
SRC_URI[md5sum] = "50a1d951d1fa96d1478ff0cc7f3b1442"
SRC_URI[sha256sum] = "89ee11b202d2268e061788e6ace114e1ff18c7620ae64d1ca3aba252ee7c9933"

