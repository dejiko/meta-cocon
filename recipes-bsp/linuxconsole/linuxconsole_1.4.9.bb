LICENSE = "GPLv2"
SRC_URI = "${SOURCEFORGE_MIRROR}/project/linuxconsole/linuxconsoletools-${PV}.tar.bz2 \
           file://without-sdl.patch" 
SRC_URI_append_libc-musl += "file://sys-time.patch"

LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

S = "${WORKDIR}/linuxconsoletools-${PV}"

SRC_URI[md5sum] = "9b91718fefabc021ca7a5adbf13e3fde"
SRC_URI[sha256sum] = "fa9c64f98cd991e71e23fa9b673635e23f0b69f0325593c0a56b8960bb139b67"

do_install() {
        cd ${S}/utils/
        install -d ${D}${bindir}
        install inputattach jstest jscal fftest ${D}${bindir}
}

PACKAGES =+ "${PN}-inputattach ${PN}-joystick"
FILES_${PN}-inputattach += "${bindir}/inputattach"
FILES_${PN}-joystick += "${bindir}/jstest \
                         ${bindir}/jscal \
                         ${bindir}/fftest"
 
