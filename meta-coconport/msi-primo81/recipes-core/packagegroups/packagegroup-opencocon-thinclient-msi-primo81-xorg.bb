# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Task for opencocon canvas (X11 related)"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

inherit packagegroup


RDEPENDS_${PN} = " \
xf86-video-fbdev \
xf86-video-modesetting \
xf86-input-evdev \
xserver-xorg-fbdev \
"
