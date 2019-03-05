# for build hamcorebuiler (not full softether)

require softether.inc

inherit native

DEPENDS += "zlib-native ncurses-native openssl-native readline-native"

do_install() {
        install -d ${D}${bindir}/
        install -m 0755    ${S}/tmp/hamcorebuilder     ${D}${bindir}/hamcorebuilder
}
