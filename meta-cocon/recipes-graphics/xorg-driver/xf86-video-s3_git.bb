require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- legacy S3 display driver"

LIC_FILES_CHKSUM = "file://COPYING;md5=0eae1e9f9b6904bf113c02c911019b1a"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-s3;protocol=git;branch=master \
          "
S = "${WORKDIR}/git"
SRCREV = "ed0fbfd27609e897c42d7ab316481a9504746233"
