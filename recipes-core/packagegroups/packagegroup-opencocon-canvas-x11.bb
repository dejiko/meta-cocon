# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Task for opencocon canvas (X11 related)"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

inherit packagegroup


RDEPENDS_${PN} = " \
xterm \
xuser-account \
xserver-nodm-init \
kernel-modules \
kivy \
kivy-examples \
mtdev \
python-pkgutil \
python-threading \
python-json \
python-compression \
python-imaging \
python-pygame \
"

