HOMEPAGE = "http://wiki.x2go.org"
LICENSE = "AGPL-3.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=73f1eb20517c55bf9493b7dd6e480788"

SRC_URI = "http://code.x2go.org/releases/source/${PN}/${PN}-${PV}.tar.gz \
"

inherit setuptools3

RDEPENDS_${PN} = "nxproxy python3-x2go python3-argparse python3-setproctitle"

SRC_URI[md5sum] = "40f81e83d8729a0de8bab7bd0427e8c0"
SRC_URI[sha256sum] = "8ad4e711fe4f34f7177e6ea1a54f72b82da11cf729292b3f608e71e56afdd875"

