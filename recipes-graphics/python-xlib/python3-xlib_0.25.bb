SUMMARY = "Python X Library"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=aafda896eaede3729318e4093f288504"

SRC_URI = "https://github.com/python-xlib/python-xlib/releases/download/python-xlib/python-xlib-${PV}.tar.bz2 \
           file://remove-the-setup_requires-for-setuptools-scm.patch"

SRC_URI[md5sum] = "ded820dc8e943106bd660801ed7a82f7"
SRC_URI[sha256sum] = "204f280b549352af6cbdaff43405186822ae05749518dd9be209bd88a0088f99"

S = "${WORKDIR}/python-xlib-${PV}"

inherit setuptools3

