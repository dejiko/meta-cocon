require recipes-graphics/xorg-driver/xorg-driver-video.inc
LIC_FILES_CHKSUM = "file://COPYING;md5=e7f3e39474aeea5af381a8e103dafc36"

SUMMARY = "X.org server -- Geode GX2/LX display driver"
PR = "${INC_PR}.0"

COMPATIBLE_HOST = "i.86.*-linux"

RDEPENDS_${PN} += "xserver-xorg-module-exa"

SRC_URI[md5sum] = "7d049187ee3640087e99f4267de6baf1"
SRC_URI[sha256sum] = "d6ece9a862a68be3cdf86a87e0e1ba5e199168b8d075129646638f53649ba9e8"

