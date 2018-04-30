require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X11 driver supporting cards based on the V1000 or the V2x00."

LIC_FILES_CHKSUM = "file://COPYING;md5=1f82ff47b53d054af9757517c438fabb"

# v*0002d.uc is firmware : sepalate this
PACKAGES =+ "firmware-${PN}" 
FILES_firmware-${PN} += "${libdir}/xorg/modules/v*0002d.uc"
INSANE_SKIP_firmware-${PN} = "arch"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-rendition;protocol=git;branch=master \
          "
S = "${WORKDIR}/git"
SRCREV = "70dd6c22b8af58c415ee142468d19dc8b428fffd"

