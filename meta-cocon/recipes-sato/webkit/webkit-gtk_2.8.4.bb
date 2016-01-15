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
           gtk+ gstreamer1.0 gstreamer1.0-plugins-base flex-native gperf-native perl-native-runtime perl-native sqlite3 ${ICU_LIB} libwebp libsecret"
DEPENDS += " ${@base_contains('DISTRO_FEATURES', 'opengl', 'virtual/libgl', '', d)}"

SRC_URI = "\
  http://webkitgtk.org/releases/webkitgtk-${PV}.tar.xz \
 "

SRC_URI[md5sum] = "50bde91beb882250e29dfd6837f56d97"
SRC_URI[sha256sum] = "30bd366bd970d4bac2f9ef5bff0fb935376bf91ea2aaa2a5183fe5fdbec20fbd"

# webkit-gtk can NOT be built on MIPS64 with n32 ABI
COMPATIBLE_HOST_mips64 = "mips64.*-linux$"

#inherit autotools lib_package pkgconfig
inherit cmake

S = "${WORKDIR}/webkitgtk-${PV}/"

#EXTRA_OECONF = "\
#                --enable-debug=no \
#                --enable-svg \
#                --with-gtk=2.0 \
#                --enable-video=no \
#                --enable-web-audio=no \
#                --disable-geolocation \
#                --enable-webkit2=no \
#                ${@base_contains('DISTRO_FEATURES', 'opengl', '--enable-webgl', '--disable-webgl', d)} \
#                UNICODE_CFLAGS=-D_REENTRANT \
#               "

EXTRA_OECMAKE = "-DCMAKE_BUILD_TYPE=Release \
                 -DPORT=GTK \
                 -DENABLE_MINIBROWSER=OFF \
                 -DENABLE_GEOLOCATION=OFF \
                 -DUSE_SYSTEM_MALLOC=ON \
                 -DENABLE_GTKDOC=OFF \
"

#default unicode backend icu breaks in cross-compile when target and host are different endian type
#EXTRA_OECONF_append_powerpc = " --with-unicode-backend=glib"

#CPPFLAGS_append_powerpc = " -I${STAGING_INCDIR}/pango-1.0 \
#                            -I${STAGING_LIBDIR}/glib-2.0/include \
#                            -I${STAGING_INCDIR}/glib-2.0"

# ld can run out of memory linking libwebkitgtk!
#
LDFLAGS += "-Wl,--no-keep-memory"

#EXTRA_AUTORECONF = " -I Source/autotools "


#| ./Source/JavaScriptCore/heap/HandleTypes.h: In static member function 'static T* JSC::HandleTypes<T>::getFromSlot(JSC::HandleSlot) [with T = JSC::Structure, JSC::HandleTypes<T>::ExternalType = JSC::Structure*, JSC::HandleSlot = JSC::JSValue*]':
#| ./Source/JavaScriptCore/heap/Handle.h:141:79:   instantiated from 'JSC::Handle<T>::ExternalType JSC::Handle<T>::get() const [with T = JSC::Structure, JSC::Handle<T>::ExternalType = JSC::Structure*]'
#| ./Source/JavaScriptCore/runtime/ScopeChain.h:39:75:   instantiated from here
#| ./Source/JavaScriptCore/heap/HandleTypes.h:38:130: warning: cast from 'JSC::JSCell*' to 'JSC::HandleTypes<JSC::Structure>::ExternalType {aka JSC::Structure*}' increases required alignment of target type [-Wcast-align]
#| {standard input}: Assembler messages:
#| {standard input}:28873: Error: invalid immediate: 983040 is out of range
#| {standard input}:28873: Error: value of 983040 too large for field of 2 bytes at 15110
#| /OE/shr-core/tmp/sysroots/x86_64-linux/usr/libexec/armv4t-oe-linux-gnueabi/gcc/arm-oe-linux-gnueabi/4.6.2/as: BFD (GNU Binutils) 2.21.1 assertion fail /OE/shr-core/tmp/work/armv4t-oe-linux-gnueabi/binutils-cross-2.21.1a-r0/binutils-2.21.1/bfd/elf.c:2819
#| arm-oe-linux-gnueabi-g++: internal compiler error: Segmentation fault (program as)
#| Please submit a full bug report,
#| with preprocessed source if appropriate.
#| See <http://gcc.gnu.org/bugs.html> for instructions.
#| make[1]: *** [Source/JavaScriptCore/jit/libjavascriptcoregtk_1_0_la-JIT.lo] Error 1
#| make[1]: Leaving directory `/OE/shr-core/tmp/work/armv4t-oe-linux-gnueabi/webkit-gtk-1.5.1+svnr90727-r0'
#ARM_INSTRUCTION_SET = "arm"

#CONFIGUREOPT_DEPTRACK = ""

#do_configure_append() {
#	# somethings wrong with icu, fix it up manually
#	for makefile in $(find ${B} -name "GNUmakefile") ; do
#		sed -i s:-I/usr/include::g $makefile
#	done
#}

#do_install_append() {
#	rmdir ${D}${libexecdir}
#}

PACKAGES =+ "${PN}-webinspector ${PN}launcher-dbg ${PN}launcher libjavascriptcore"
FILES_${PN}launcher = "${bindir}/GtkLauncher"
FILES_${PN}launcher-dbg = "${bindir}/.debug/GtkLauncher"
FILES_libjavascriptcore = "${libdir}/libjavascriptcoregtk-1.0.so.*"
FILES_${PN}-webinspector = "${datadir}/webkitgtk-*/webinspector/"
FILES_${PN} += "${datadir}/webkitgtk-*/resources/error.html \
                ${datadir}/webkitgtk-*/images \
                ${datadir}/glib-2.0/schemas"


