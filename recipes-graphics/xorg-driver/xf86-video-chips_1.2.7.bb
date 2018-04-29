require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- Chips display driver"

#SRC_URI += "
#           file://01_default_to_noaccel_on_69k.diff
#           file://02_default_to_swcursor_on_69k.diff

LIC_FILES_CHKSUM = "file://COPYING;md5=d16ab8e6e1c8f1eaca1ef57449f284b2"

SRC_URI[md5sum] = "927104427d9d373141a3bd04b23e39ad"
SRC_URI[sha256sum] = "6ea8688c5eeaba9a34a30071732d3072c31d95ca4b78c9cce0f3cbb9eaf59f58"

