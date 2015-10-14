# From Angstrom tree
# https://gitorious.org/angstrom/openembedded/source/7e5ea0e6826d138349c40ff296e5b86cf46fead7:recipes/openswan/openswan_2.6.31.bb

SECTION = "console/network"
DESCRIPTION = "Openswan is an Open Source implementation of IPsec for the \
Linux operating system."
HOMEPAGE = "http://www.openswan.org"
LICENSE = "GPLv2"
DEPENDS = "gmp flex-native bison-native"
RRECOMMENDS_${PN} = "kernel-module-ipsec"
RDEPENDS_append_nylon = "perl"
LIC_FILES_CHKSUM = "file://COPYING;md5=67b604758dd265c185ce36fcf76a889d"

SRC_URI = "http://www.openswan.org/download/openswan-${PV}.tar.gz"

EXTRA_OEMAKE = "DESTDIR=${D} \
                USERCOMPILE="${CFLAGS}" \
                USERLINK="${LDFLAGS}" \
                FINALCONFDIR=${sysconfdir}/ipsec \
                FINALLIBDIR=${libdir}/ipsec \
                FINALLIBEXECDIR=${libexecdir}/ipsec \
                FINALSBINDIR=${sbindir} \
                INC_RCDEFAULT=${sysconfdir}/init.d \
                INC_USRLOCAL=${prefix} \
                INC_MANDIR=share/man WERROR=''"

do_compile () {
	oe_runmake programs
}

do_install () {
	oe_runmake install
}

PACKAGES =+ "${PN}-examples ${PN}-test ${PN}-klips"

FILES_${PN} = "${sysconfdir} ${libdir}/ipsec/* ${sbindir}/* ${libexecdir}/ipsec/*"
FILES_${PN}-dbg += "${libdir}/ipsec/.debug ${libexecdir}/ipsec/.debug"

CONFFILES_${PN} = "${sysconfdir}/ipsec/ipsec.conf"

FILES_${PN}-examples = "${sysconfdir}/ipsec.d/examples"

# KLIPS requires some binaries and scripts that NETKEY users don't need.
FILES_${PN}-klips = " \
        ${libexecdir}/ipsec/eroute \
        ${libexecdir}/ipsec/klipsdebug \
        ${libexecdir}/ipsec/spi \
        ${libexecdir}/ipsec/spigrp \
        ${libexecdir}/ipsec/tncfg \
        ${libdir}/ipsec/_updown.klips \
"

FILES_${PN}-test = " \
        ${libexecdir}/ipsec/showpolicy \
        ${libexecdir}/ipsec/verify \
"

SRC_URI[md5sum] = "077346ed785be3415234ca8ba6c6a758"
SRC_URI[sha256sum] = "b657b4a3828fc6e9830aabeabec047a71993daeb9dd2607f321e355bc5a53e1e"

