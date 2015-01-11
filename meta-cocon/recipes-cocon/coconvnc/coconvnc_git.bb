# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "opencocon VNC client"
HOMEPAGE = "http://opencocon.org"
DEPENDS = "virtual/libx11 openssl libvncserver"
SECTION = "x11/network"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=361b6b837cad26c6900a926b62aada5f"

inherit cmake

S = "${WORKDIR}/git"
SRC_URI = "git://github.com/dejiko/coconvnc.git"
SRCREV = "45bf0b33a413e0f1d6dd74bba388dafd43be6cc9"

