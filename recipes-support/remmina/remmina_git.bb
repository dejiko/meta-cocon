LICENSE = "GPLv2"
DEPENDS = "libvncserver xserver-xorg freerdp libgcrypt zlib gettext "
PR = "r0"

#DEFAULT_PREFERENCE = "-1"

SRC_URI = "git://github.com/FreeRDP/Remmina.git;protocol=git;branch=master" 

SRCREV = "b6a55ae6f4633d55f8f03e7ce2eeb5899514a8fc"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += " -DWITH_VTE=OFF -DWITH_TELEPATHY=OFF -DWITH_AVAHI=OFF \
		   -DWITH_GNOMEKEYRING=OFF -DWITH_LIBSSH=OFF -DCMAKE_BUILD_TYPE=Release"
LDFLAGS += " -lintl "
OECMAKE_C_FLAGS += " -lintl "

inherit cmake gettext

#PACKAGES = "${PN}" 
FILES_${PN} += "${datadir}/icons"
FILES_${PN}-dbg += "${libdir}/remmina/plugins/.debug"

LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

