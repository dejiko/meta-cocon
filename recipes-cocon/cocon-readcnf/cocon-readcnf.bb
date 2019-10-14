DESCRIPTION = "opencocon configuration reader"
SECTION = "base"
RDEPENDS_${PN} = "lsb python3-core python3-io"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://scan-cnf-from-storage \
           file://cocon-read-cnf"

S="${WORKDIR}"

do_install() {
  set -ex

  install -d ${D}${sysconfdir}/init.d
  install -m 0755 ${WORKDIR}/scan-cnf-from-storage ${D}${sysconfdir}/init.d/scan-cnf-from-storage

  install -d ${D}${bindir}/
  install -m 0755 ${WORKDIR}/cocon-read-cnf ${D}${bindir}/cocon-read-cnf

}


# init.d : run on rc.S after udev, before of spmachine.

inherit update-rc.d

INITSCRIPT_PACKAGES = "cocon-readcnf"
INITSCRIPT_NAME_cocon-readcnf = "scan-cnf-from-storage"
INITSCRIPT_PARAMS_cocon-readcnf = "start 40 S ."

FILES_${PN} = "/"

