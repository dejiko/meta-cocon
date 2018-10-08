# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Packagegroup for opencocon sound extention"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit packagegroup


RDEPENDS_${PN} = " \
alsa-utils-alsactl \
alsa-utils-alsamixer \
alsa-utils-amixer \
alsa-utils-aplay \
alsa-utils-speakertest \
"

