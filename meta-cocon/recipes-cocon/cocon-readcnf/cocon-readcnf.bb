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

FILES_${PN} = "/"

