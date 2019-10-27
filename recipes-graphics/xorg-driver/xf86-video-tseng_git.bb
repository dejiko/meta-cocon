require recipes-graphics/xorg-driver/xorg-driver-video.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=0a077234e3915957b0b4a1f0ff3f10b7"

# 1.20 patch from slackware :
# https://mirror.slackbuilds.org/slackware/slackware-current/source/x/x11/patch/xf86-video-tseng/
SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-tseng;protocol=git;branch=master \
          file://xf86-video-tseng.xorg-server-1.20.x.diff"

S = "${WORKDIR}/git"
SRCREV = "ff298ec912de6fe0c2639b604678e5874242af4d"
