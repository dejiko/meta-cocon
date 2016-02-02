# Copyright (C) 2010, 2011 O.S. Systems Software Ltda. All Rights Reserved
# Released under the MIT license

DESCRIPTION = "FreeRDP RDP client"
HOMEPAGE = "http://www.freerdp.com"
DEPENDS = "virtual/libx11 openssl libxcursor libxv alsa-lib pulseaudio libxkbfile"
#DEPENDS_cocon486 = "libav"
#DEPENDS_raspberrypi = "libav"
SECTION = "x11/network"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"


inherit pkgconfig cmake

EXTRA_OECMAKE += " -DWITH_XINERAMA=OFF -DWITH_CUPS=OFF -DWITH_PULSEAUDIO=ON \
		-DWITH_MANPAGES=OFF -DWITH_XKBFILE=ON  -DWITH_ALSA=ON \
"
EXTRA_OECMAKE += " -DWITH_FFMPEG=OFF "

PACKAGES =+ "libfreerdp"

LEAD_SONAME = "libfreerdp.so"
FILES_libfreerdp = "${libdir}/lib*${SOLIBS}"

PACKAGES_DYNAMIC = "libfreerdp-plugin-*"


do_patch() {
    # patch from Debian
    cd ${S}
    patch -Np1 -i ${WORKDIR}/0003-dont-use-unavailable-c99-math-debian.patch
    patch -Np1 -i ${S}/debian/patches/1001_hide-internal-symbols.patch
    patch -Np1 -i ${S}/debian/patches/1002_update-pkg-config-file.patch
    # TODO
    patch -Np1 -i ${S}/debian/patches/1003_multi-arch-include-path.patch
    patch -Np1 -i ${S}/debian/patches/1004_64-bit-architectures.patch
    patch -Np1 -i ${S}/debian/patches/1005_parse-buffer-endianess.patch
    patch -Np1 -i ${S}/debian/patches/1006_test-unicode-endianess.patch
    patch -Np1 -i ${S}/debian/patches/1007_detect-arm-arch-correctly.patch
    patch -Np1 -i ${S}/debian/patches/1008_gcc-fPIC-on-arm64.patch

    # opencocon-local patches
    patch -Np1 -i ${WORKDIR}/futimens_cocon_v2.patch
    # based on https://github.com/FreeRDP/FreeRDP/issues/1361
    patch -Np1 -i ${WORKDIR}/cocon-fullscreen-v2.patch
}

do_configure_prepend() {

    # opencocon-local fixes
    sed -i \
        -e s:'set( CMAKE_MODULE_PATH ':'set( CMAKE_MODULE_PATH ${S}/cmake/ ':g \
        ${S}/../toolchain.cmake

    sed -i \
        -e s:'check_include_files(sys/eventfd.h HAVE_EVENTFD_H)':'':g \
        ${S}/CMakeLists.txt

    # Ad-hoc fix :
    # http://h30499.www3.hp.com/t5/Workstations-Thin-Clients/Installing-FreeRDP-on-ThinPro-3-3-Take-Three-The-Automated-Way/td-p/5547859

    sed -i \
        -e '24a\#include <stdio.h>' \
        ${S}/include/freerdp/utils/pcap.h
}



# TODO : useless on newer FreeRDP.
python populate_packages_prepend () {
    freerdp_root = bb.data.expand('${libdir}/freerdp', d)

    do_split_packages(d, freerdp_root, '^(audin_.*)\.so$',
        output_pattern='libfreerdp-plugin-%s',
        description='FreeRDP plugin %s',
        prepend=True, extra_depends='libfreerdp-plugin-audin')

    do_split_packages(d, freerdp_root, '^(rdpsnd_.*)\.so$',
        output_pattern='libfreerdp-plugin-%s',
        description='FreeRDP plugin %s',
        prepend=True, extra_depends='libfreerdp-plugin-rdpsnd')

    do_split_packages(d, freerdp_root, '^(tsmf_.*)\.so$',
        output_pattern='libfreerdp-plugin-%s',
        description='FreeRDP plugin %s',
        prepend=True, extra_depends='libfreerdp-plugin-tsmf')

    do_split_packages(d, freerdp_root, '^([^-]*)\.so$',
        output_pattern='libfreerdp-plugin-%s',
        description='FreeRDP plugin %s',
        prepend=True, extra_depends='')
}
