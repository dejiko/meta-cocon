DESCRIPTION = "Web safe object pickling/unpickling"
HOMEPAGE = "https://github.com/aresch/rencode"
SECTION = "devel/python"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "python3-wheel-native"

SRC_URI[md5sum] = "11851d443963a64b12dc8683f41ce0e3"
SRC_URI[sha256sum] = "2586435c4ea7d45f74e26765ad33d75309de7cf47c4d762e8efabd39905c0718"

inherit pypi setuptools3
