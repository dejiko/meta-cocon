# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Task for opencocon Web browser extention (coconcaravan)"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

inherit packagegroup


RDEPENDS_${PN} = " \
firefox \
firefox-l10n-en-us \
firefox-addon-webconverger \
"

