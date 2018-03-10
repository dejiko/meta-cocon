# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Task for opencocon canvas"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

inherit packagegroup


RDEPENDS_${PN} = " \
dialog \
kbd \
kbd-keymaps \
networkmanager \
initscripts \
"

