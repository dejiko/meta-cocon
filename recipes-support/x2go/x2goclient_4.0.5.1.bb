HOMEPAGE = "http://wiki.x2go.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

# Patches from Fedora and OpenBSD.
SRC_URI = "http://code.x2go.org/releases/source/x2goclient/x2goclient-${PV}.tar.gz \
           file://x2goclient-qt5.patch \
           file://sshmasterconnction-stack-size.patch \
"

inherit qmake5

DEPENDS += "nxcomp nxproxy qtbase qtx11extras qtsvg qttools-native openldap libssh libxpm libx11 cups"

SUBLIBS += "-lX11 -lldap -lcups -lXpm"
export SUBLIBS

do_configure_prepend() {
  echo "DEFINES += __linux__" >> ${S}/x2goclientconfig.pri
}


do_install() {
  install -d ${D}${bindir}
  install -m 0755 ${B}/x2goclient ${D}${bindir}/x2goclient

  install -d ${D}${datadir}/applications
  install -m 0644 ${S}/desktop/x2goclient.desktop ${D}${datadir}/applications/x2goclient.desktop

  install -d ${D}${datadir}/x2goclient/icons
  install -m 0644 ${S}/res/img/icons/x2goclient.xpm ${D}${datadir}/x2goclient/icons/x2goclient.xpm
  install -m 0644 ${S}/res/img/icons/128x128/x2goclient.png ${D}${datadir}/x2goclient/icons/x2goclient.png
  install -m 0644 ${S}/res/img/icons/128x128/x2gosession.png ${D}${datadir}/x2goclient/icons/x2gosession.png

  install -d ${D}${datadir}/icons/hicolor/128x128/apps
  install -m 0644 ${S}/res/img/icons/128x128/x2goclient.png ${D}${datadir}/icons/hicolor/128x128/apps/x2goclient.png

  install -d ${D}${datadir}/icons/hicolor/16x16/apps
  install -m 0644 ${S}/res/img/icons/16x16/x2goclient.png ${D}${datadir}/icons/hicolor/16x16/apps/x2goclient.png

  install -d ${D}${datadir}/icons/hicolor/64x64/apps
  install -m 0644 ${S}/res/img/icons/64x64/x2goclient.png ${D}${datadir}/icons/hicolor/64x64/apps/x2goclient.png

  install -d ${D}${datadir}/icons/hicolor/32x32/apps
  install -m 0644 ${S}/res/img/icons/32x32/x2goclient.png ${D}${datadir}/icons/hicolor/32x32/apps/x2goclient.png
}

FILES_${PN} += "${datadir}/icons/"

SRC_URI[md5sum] = "08ff4bd5d40a9ce011be4c56ac5ce296"
SRC_URI[sha256sum] = "844e983fbbddfe8a626506e4140b1ad65591e14f794c735412402bee3163ed11"
