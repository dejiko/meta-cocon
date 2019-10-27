DESCRIPTION = "multi-platform screen and application forwarding system"
HOMEPAGE = "http://www.xpra.org/src/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "http://www.xpra.org/src/${PN}-${PV}.tar.xz \
           file://no_use_bash.patch \
"

DEPENDS = "python3-cython-native libx11 libxrandr libxtst libxfixes libxcomposite libxdamage \
           gtk+3 libxext libxkbfile python3-pygobject libvpx jpeg libwebp"

RDEPENDS_${PN} = "python3-rencode python3-pillow"                                                               

# client only (for opencocon distribution)
DISTUTILS_BUILD_ARGS = "--without-html5 --without-minify --without-html5_gzip \
                        --without-html5_brotli --without-example \
                        --without-service --without-cuda_kernels \
                        --without-cuda_rebuild --with-vpx \
                        --without-jpeg_encoder --without-v4l2 \
                        --without-server --without-printing"
# TODO : opengl

PACKAGES += " \
  ${PN}-server \
"

FILES_${PN} += "\
  ${datadir}/appdata/* \
  ${datadir}/applications/* \
  ${datadir}/etc/xpra/* \
  ${datadir}/etc/X11/* \
  ${datadir}/etc/dbus-1/system.d/* \
  ${datadir}/icons/* \
  ${datadir}/mime/packages/* \
  ${datadir}/lib/udev/rules.d/* \
  ${datadir}/lib/xpra/* \
  ${datadir}/lib/tmpfiles.d/* \
  ${datadir}/lib/sysusers.d/* \
  ${datadir}/lib/cups/backend/* \
"

FILES_${PN}-server += "\
  ${datadir}/lib/systemd/system/* \
  ${datadir}/etc/default/xpra \
"

SRC_URI[md5sum] = "fb5057cfc42308092126be3c19c55cd6"
SRC_URI[sha256sum] = "3822b59d248e9b76d65c61ee4cef65e2ca8e5165aaa1d6f3e03a95a2a800d5b3"

inherit setuptools3
