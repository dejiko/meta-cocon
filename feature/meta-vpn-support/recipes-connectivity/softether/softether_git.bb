require softether.inc

DEPENDS += "zlib ncurses softether-hamcorebuilder-native virtual/libiconv readline openssl"
RDEPENDS-${PN} += "virtual/libiconv readline openssl"

do_install_append() {
    # move hamcore.se2 to right place ( no duplicate, just symlink )
    install -d ${D}${libdir}/softether/
    install -m 0755 ${S}/build/vpnclient/hamcore.se2 ${D}${libdir}/softether/hamcore.se2
    
    rm ${D}${libexecdir}/softether/vpnbridge/hamcore.se2
    ln -s ${libdir}/softether/hamcore.se2 ${D}${libexecdir}/softether/vpnbridge/hamcore.se2
    rm ${D}${libexecdir}/softether/vpnclient/hamcore.se2
    ln -s ${libdir}/softether/hamcore.se2 ${D}${libexecdir}/softether/vpnclient/hamcore.se2
    rm ${D}${libexecdir}/softether/vpncmd/hamcore.se2
    ln -s ${libdir}/softether/hamcore.se2 ${D}${libexecdir}/softether/vpncmd/hamcore.se2
    rm ${D}${libexecdir}/softether/vpnserver/hamcore.se2
    ln -s ${libdir}/softether/hamcore.se2 ${D}${libexecdir}/softether/vpnserver/hamcore.se2
}

PACKAGES = " \
  ${PN}-vpnbridge \
  ${PN}-vpnclient \
  ${PN}-vpncmd \
  ${PN}-vpnserver \
  ${PN}-list-cpu-features \
  ${PN}-hamcore \
  ${PN}-list-cpu-features-dev \
  ${PN}-list-cpu-features-staticdev \
  ${PN}-dbg \
  ${PN}-systemd \
"

FILES_${PN}-vpnbridge = "\
  ${bindir}/vpnbridge \
  ${libexecdir}/softether/vpnbridge/vpnbridge \
"

FILES_${PN}-vpnclient = "\
  ${bindir}/vpnclient \
  ${libexecdir}/softether/vpnclient/vpnclient \
"

FILES_${PN}-vpncmd = "\
  ${bindir}/vpncmd \
  ${libexecdir}/softether/vpncmd/vpncmd \
"

FILES_${PN}-vpnserver = "\
  ${bindir}/vpnserver \
  ${libexecdir}/softether/vpnserver/vpnserver \
"

FILES_${PN}-list-cpu-features = "\
  ${bindir}/list_cpu_features \
"

FILES_${PN}-hamcore = "\
  ${libdir}/softether/hamcore.se2 \
  ${libexecdir}/softether/vpnbridge/hamcore.se2 \
  ${libexecdir}/softether/vpnclient/hamcore.se2 \
  ${libexecdir}/softether/vpncmd/hamcore.se2 \
  ${libexecdir}/softether/vpnserver/hamcore.se2 \
"

FILES_${PN}-list-cpu-features-dev = "\
  ${includedir}/cpu_features/* \
  ${libdir}/cmake/* \
"

FILES_${PN}-list-cpu-features-staticdev = "\
  ${libdir}/libcpu_features.a \
"

FILES_${PN}-dbg = "\
  ${exec_prefix}/src/debug/* \
"

FILES_${PN}-systemd = "\
  ${base_libdir}/systemd/* \
"

