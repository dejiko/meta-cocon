DESCRIPTION = "opencocon configuration reader"
SECTION = "base"
RDEPENDS_${PN} = "lsb python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

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

