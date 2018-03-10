DESCRIPTION = "Broadcom b43 firmware cutter"
HOMEPAGE = "http://wireless.kernel.org/en/users/Drivers/b43"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=f5be97ff12e4f00bc9ea69354841aab8"
PR = "r0"

# SRC_URI = "http://bues.ch/b43/fwcutter/b43-fwcutter-${PV}.tar.bz2"
SRC_URI = "http://distfiles.pld-linux.org/distfiles/by-md5/5/6/56fcb0c64dcc94dd2672b9ff87f8217f/b43-fwcutter-018.tar.bz2"


SRC_URI[md5sum] = "56fcb0c64dcc94dd2672b9ff87f8217f"
SRC_URI[sha256sum] = "57b069dcd1a369ceb457ca397aab470be9b3fc537f400d27244e060fd425638f"
S = "${WORKDIR}/b43-fwcutter-${PV}"


EXTRA_OEMAKE += "'PREFIX=${D}${prefix} CC=${CC} -Os -fomit-frame-pointer \
                 -DUNIX ${CFLAGS}'"

#export LD = "${CC}"

do_compile() {
        oe_runmake 
}

do_install() {
        install -d ${D}${bindir}/
        install -m 0755    ${S}/b43-fwcutter     ${D}${bindir}/b43-fwcutter
}

