DESCRIPTION = "Wine - compatibility layer capable of running Windows applications"

SRC_URI = "http://prdownloads.sourceforge.net/wine/wine-${PV}.tar.bz2"
SRC_URI[md5sum] = "0f6c56f86befe38e219090915f81f48a"
SRC_URI[sha256sum] = "f0ab9eede5a0ccacbf6e50682649f9377b9199e49cf55641f1787cf72405acbe"

DEPENDS = "m4 libtool freetype virtual/xserver"

inherit autotools

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=6ab17b41640564434dda85c06b7124f7"

#PARALLEL_MAKE=""

CONFIGURE_OPTIONS = " \
                    --without-v4l \
                    --without-coreaudio \
                    --without-gphoto \
                    --without-ldap \
                    --without-sane \
                    --without-capi \
                    --without-xslt \
                   "
