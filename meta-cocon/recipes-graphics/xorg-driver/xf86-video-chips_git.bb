require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- Chips display driver"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-chips;protocol=git;branch=master \
           file://01_default_to_noaccel_on_69k.diff \
           file://02_default_to_swcursor_on_69k.diff \
          "

S = "${WORKDIR}/git"
SRCREV = "9187d76bd4f8d500fc3403b6d4a7bef55508bf2b"

LIC_FILES_CHKSUM = "file://COPYING;md5=d16ab8e6e1c8f1eaca1ef57449f284b2"
