DESCRIPTION = "Python libSDL Bindings"
SECTION = "devel/python"
HOMEPAGE = "http://www.pygame.org"
LICENSE = "LGPLv2.1"
DEPENDS = "virtual/libsdl libsdl-image libsdl-mixer libsdl-ttf python-numeric pkgconfig-native libv4l"
RDEPENDS_${PN} = "python-numeric"
SRCNAME = "pygame"
LIC_FILES_CHKSUM = "file://LGPL;md5=7fbc338309ac38fefcd64b04bb903e34"

SRC_URI = "http://www.pygame.org/ftp/${SRCNAME}-${PV}release.tar.gz;name=archive \
           file://videodev.patch"

SRC_URI[archive.md5sum] = "1c4cdc708d17c8250a2d78ef997222fc"
SRC_URI[archive.sha256sum] = "a26095472ae4be9631e0d5bfb9a52ac57a3a091e45757913128e4a473807d433"
S = "${WORKDIR}/${SRCNAME}-${PV}release"

inherit distutils

export SDL_CONFIG = "$( PKG_CONFIG_PATH=${PKG_CONFIG_PATH} PKG_CONFIG_SYSROOT_DIR=${STAGING_DIR_HOST} ${STAGING_BINDIR_NATIVE}/pkg-config sdl --cflags --libs )"

do_configure_prepend() {
  sed '/^SDL =/d; /^SMPEG =/d; /^movie src/d; /^pypm src/d' ${S}/Setup.in > ${S}/Setup
  echo "SDL = ${SDL_CONFIG}" >> ${S}/Setup
}

