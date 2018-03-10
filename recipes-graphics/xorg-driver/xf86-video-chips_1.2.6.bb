require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- Chips display driver"

#SRC_URI += "
#           file://01_default_to_noaccel_on_69k.diff
#           file://02_default_to_swcursor_on_69k.diff

LIC_FILES_CHKSUM = "file://COPYING;md5=d16ab8e6e1c8f1eaca1ef57449f284b2"

SRC_URI[md5sum] = "7c3ac8a7338367b05d9315d65ef91226"
SRC_URI[sha256sum] = "99aef5cf9f58391eefab5b4983814f417fd1cf2e4a0f93564de1e9bd75636b1c"

