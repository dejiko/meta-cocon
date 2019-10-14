DESCRIPTION = "opencocon-local data file"
SECTION = "base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
DEPENDS = "base-files"

SRC_URI = "file://COPYING.MIT \
	   file://COPYING.PICS \
           file://gplv2.txt \
           file://gplv3.txt \
           file://lgpl-2.1.txt \
           file://lgplv3.txt \
           file://about.txt \
	   file://sample1.jpg \
	   file://sample2.jpg \
           file://sample3.jpg \
           file://sample4.jpg \
           file://sample5.jpg \
"

S="${WORKDIR}"

do_install() {
	set -ex
 
        install -d ${D}${datadir}/doc/cocon/
        install -m 0644 ${WORKDIR}/about.txt ${D}${datadir}/doc/cocon/about.txt
        install -m 0644 ${WORKDIR}/gplv2.txt ${D}${datadir}/doc/cocon/gplv2.txt
        install -m 0644 ${WORKDIR}/gplv3.txt ${D}${datadir}/doc/cocon/gplv3.txt
        install -m 0644 ${WORKDIR}/lgpl-2.1.txt ${D}${datadir}/doc/cocon/lgpl-2.1.txt
        install -m 0644 ${WORKDIR}/lgplv3.txt ${D}${datadir}/doc/cocon/lgplv3.txt
	install -m 0644 ${WORKDIR}/COPYING.MIT ${D}${datadir}/doc/cocon/COPYING.MIT

	install -d ${D}${datadir}/cocon/pic/
        install -m 0644 ${WORKDIR}/COPYING.PICS ${D}${datadir}/cocon/pic/COPYING.PICS
	install -m 0644 ${WORKDIR}/sample1.jpg ${D}${datadir}/cocon/pic/sample1.jpg
        install -m 0644 ${WORKDIR}/sample2.jpg ${D}${datadir}/cocon/pic/sample2.jpg
        install -m 0644 ${WORKDIR}/sample3.jpg ${D}${datadir}/cocon/pic/sample3.jpg
        install -m 0644 ${WORKDIR}/sample4.jpg ${D}${datadir}/cocon/pic/sample4.jpg
        install -m 0644 ${WORKDIR}/sample5.jpg ${D}${datadir}/cocon/pic/sample5.jpg
}


FILES_${PN} = "/"

