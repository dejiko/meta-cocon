require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X11 driver supporting cards based on the V1000 or the V2x00."

LIC_FILES_CHKSUM = "file://COPYING;md5=1f82ff47b53d054af9757517c438fabb"

# v*0002d.uc is firmware : sepalate this
PACKAGES =+ "firmware-${PN}" 
FILES_firmware-${PN} += "${libdir}/xorg/modules/v*0002d.uc"
INSANE_SKIP_firmware-${PN} = "arch"

SRC_URI[md5sum] = "405dd1acba9c2e43d7aa67b631762495"
SRC_URI[sha256sum] = "660ecf21f65a4d6002c1b603d62c314f8e9624d208db5b346850b0df9dc2f9a8"

