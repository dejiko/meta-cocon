# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Packagegroup for opencocon sound extention"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

inherit packagegroup


RDEPENDS_${PN} = " \
alsa-utils-alsactl \
alsa-utils-alsamixer \
alsa-utils-amixer \
alsa-utils-aplay \
alsa-utils-speakertest \
"

