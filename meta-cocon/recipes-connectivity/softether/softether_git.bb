require softether.inc

DEPENDS = "zlib ncurses openssl softether-hamcorebuilder-native"

SRC_URI_append_libc-uclibc = "file://internat-uclibc.patch"

EXTRA_OEMAKE += "'PREFIX=${D}${prefix} CC=${CC} -fomit-frame-pointer \
                 ${CFLAGS}'"

do_configure_append() {
    # Modify Makefile (use hamcorebuilder by softether-hamcorebuilder-native)
    sed -i \
        -e "s:tmp/hamcorebuilder src/bin/hamcore/ src/bin/BuiltHamcoreFiles/unix/hamcore.se2:hamcorebuilder src/bin/hamcore/ src/bin/BuiltHamcoreFiles/unix/hamcore.se2:g" \
        ${S}/Makefile

    sed -i \
        -e "s:INSTALL_BINDIR=:INSTALL_BINDIR=${D}:g" \
        ${S}/Makefile

    sed -i \
        -e "s:INSTALL_VPNSERVER_DIR=:INSTALL_VPNSERVER_DIR=${D}:g" \
        ${S}/Makefile

    sed -i \
        -e "s:INSTALL_VPNBRIDGE_DIR=:INSTALL_VPNBRIDGE_DIR=${D}:g" \
        ${S}/Makefile

    sed -i \
        -e "s:INSTALL_VPNCLIENT_DIR=:INSTALL_VPNCLIENT_DIR=${D}:g" \
        ${S}/Makefile

    sed -i \
        -e "s:INSTALL_VPNCMD_DIR=:INSTALL_VPNCMD_DIR=${D}:g" \
        ${S}/Makefile
}

do_configure_append_linux-uclibc () {
    sed -i \
        -e "s:OPTIONS_LINK_RELEASE=:OPTIONS_LINK_RELEASE=-liconv :g" \
        ${S}/Makefile
}

do_compile() {
    oe_runmake
}


do_install() {
    install -d ${D}${bindir}/
    oe_runmake install

    # exclude ${D} from some batch file
    sed -i -e "s:${D}::g" ${D}${bindir}/vpnbridge
    sed -i -e "s:${D}::g" ${D}${bindir}/vpnclient
    sed -i -e "s:${D}::g" ${D}${bindir}/vpncmd
    sed -i -e "s:${D}::g" ${D}${bindir}/vpnserver

    # and move hamcore.se2 to right place ( no duplicate, just symlink )
    install -d ${D}${libdir}/softether/
    install -m 0755 ${S}/src/bin/BuiltHamcoreFiles/unix/hamcore.se2 ${D}${libdir}/softether/hamcore.se2
    
    rm ${D}/usr/vpnbridge/hamcore.se2
    ln -s ${libdir}/softether/hamcore.se2 ${D}/usr/vpnbridge/hamcore.se2
    rm ${D}/usr/vpnclient/hamcore.se2
    ln -s ${libdir}/softether/hamcore.se2 ${D}/usr/vpnclient/hamcore.se2
    rm ${D}/usr/vpncmd/hamcore.se2
    ln -s ${libdir}/softether/hamcore.se2 ${D}/usr/vpncmd/hamcore.se2
    rm ${D}/usr/vpnserver/hamcore.se2
    ln -s ${libdir}/softether/hamcore.se2 ${D}/usr/vpnserver/hamcore.se2

}

PACKAGES = " \
  ${PN}-vpnbridge \
  ${PN}-vpnclient \
  ${PN}-vpncmd \
  ${PN}-vpnserver \
  ${PN}-hamcore \
  ${PN}-dbg \
"

FILES_${PN}-vpnbridge = "\
  ${bindir}/vpnbridge \
  /usr/vpnbridge/vpnbridge \
"

FILES_${PN}-vpnclient = "\
  ${bindir}/vpnclient \
  /usr/vpnclient/vpnclient \
"

FILES_${PN}-vpncmd = "\
  ${bindir}/vpncmd \
  /usr/vpncmd/vpncmd \
"

FILES_${PN}-vpnserver = "\
  ${bindir}/vpnserver \
  /usr/vpnserver/vpnserver \
"

FILES_${PN}-hamcore = "\
  ${libdir}/softether/hamcore.se2 \
  /usr/vpnbridge/hamcore.se2 \
  /usr/vpnclient/hamcore.se2 \
  /usr/vpncmd/hamcore.se2 \
  /usr/vpnserver/hamcore.se2 \
"

FILES_${PN}-dbg = "\
  /usr/vpnbridge/.debug/* \
  /usr/vpnclient/.debug/* \
  /usr/vpncmd/.debug/* \
  /usr/vpnserver/.debug/* \
"


