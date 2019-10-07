HOMEPAGE = "http://wiki.x2go.org"
LICENSE = "AGPL-3.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=73f1eb20517c55bf9493b7dd6e480788"

SRC_URI = "http://code.x2go.org/releases/source/python-x2go/python-x2go-${PV}.tar.gz \
"

inherit setuptools3

S = "${WORKDIR}/python-x2go-${PV}"

RDEPENDS_${PN} = "nxproxy python3-xlib python3-gevent python3-requests python3-simplejson python3-paramiko"

SRC_URI[md5sum] = "e311f0a627704b75f4ad4ce479150b36"
SRC_URI[sha256sum] = "83899a749b1c0f3c0c9acbb11bafc8b1711cb5142b4a013385dd47b0bb293908"
