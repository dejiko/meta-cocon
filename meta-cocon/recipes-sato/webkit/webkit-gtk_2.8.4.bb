SUMMARY = "WebKit web rendering engine for the GTK+ platform"
HOMEPAGE = "http://www.webkitgtk.org/"
BUGTRACKER = "http://bugs.webkit.org/"

LICENSE = "BSD & LGPLv2+"
LIC_FILES_CHKSUM = "file://Source/WebCore/LICENSE-LGPL-2;md5=36357ffde2b64ae177b2494445b79d21 \
                    file://Source/WebCore/LICENSE-APPLE;md5=4646f90082c40bcf298c285f8bab0b12"

# Choice of language backends - icu has issues on Big Endian machines so use pango
ICU_LIB = "harfbuzz"
ICU_LIB_powerpc = "pango"

DEPENDS = "zlib enchant libsoup-2.4 curl libxml2 cairo libxslt libxt libidn gnutls \
           gtk+ gstreamer1.0 gstreamer1.0-plugins-base flex-native gperf-native perl-native-runtime perl-native sqlite3 ${ICU_LIB} libwebp libsecret perl-native ruby-native"
DEPENDS += " ${@base_contains('DISTRO_FEATURES', 'opengl', 'virtual/libgl', '', d)}"

SRC_URI = "\
  http://webkitgtk.org/releases/webkitgtk-${PV}.tar.xz \
 "

SRC_URI[md5sum] = "50bde91beb882250e29dfd6837f56d97"
SRC_URI[sha256sum] = "30bd366bd970d4bac2f9ef5bff0fb935376bf91ea2aaa2a5183fe5fdbec20fbd"

# webkit-gtk can NOT be built on MIPS64 with n32 ABI
COMPATIBLE_HOST_mips64 = "mips64.*-linux$"

inherit cmake perlnative pythonnative

S = "${WORKDIR}/webkitgtk-${PV}/"

EXTRA_OECMAKE = "-DCMAKE_BUILD_TYPE=Release \
                 -DPORT=GTK \
                 -DENABLE_MINIBROWSER=OFF \
                 -DENABLE_GEOLOCATION=OFF \
                 -DUSE_SYSTEM_MALLOC=ON \
                 -DENABLE_GTKDOC=OFF \
"

# ld can run out of memory linking libwebkitgtk!
#
LDFLAGS += "-Wl,--no-keep-memory"

# ARMv5/v6 : disable jit
# http://git.yoctoproject.org/cgit/cgit.cgi/poky/commit/?id=7ecfaaaf5886c1892cc5190f8d632265ffd92f50
## TODO : Rewrite for OECMAKE
## EXTRA_OECONF_append_armv5 = " --disable-jit"
## EXTRA_OECONF_append_armv6 = " --disable-jit"


PACKAGES =+ "${PN}-webinspector ${PN}launcher-dbg ${PN}launcher libjavascriptcore"
FILES_${PN}launcher = "${bindir}/GtkLauncher"
FILES_${PN}launcher-dbg = "${bindir}/.debug/GtkLauncher"
FILES_libjavascriptcore = "${libdir}/libjavascriptcoregtk-1.0.so.*"
FILES_${PN}-webinspector = "${datadir}/webkitgtk-*/webinspector/"
FILES_${PN} += "${datadir}/webkitgtk-*/resources/error.html \
                ${datadir}/webkitgtk-*/images \
                ${datadir}/glib-2.0/schemas"


