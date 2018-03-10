# for build hamcorebuiler (not full softether)

require softether.inc

inherit native

DEPENDS += "zlib-native ncurses-native openssl-native"

EXTRA_OEMAKE += 'PREFIX=${STAGING_DIR}/${BUILD_SYS}'


do_configure_append() {

    # Modify Makefile
    sed -i \
        -e "s:OPTIONS_COMPILE_RELEASE=:OPTIONS_COMPILE_RELEASE=-I${STAGING_INCDIR_NATIVE} :g" \
        ${S}/Makefile

    sed -i \
        -e "s:OPTIONS_LINK_RELEASE=:OPTIONS_LINK_RELEASE=-L${STAGING_LIBDIR_NATIVE} -L${STAGING_BASE_LIBDIR_NATIVE} :g" \
        ${S}/Makefile

}

do_compile() {
    oe_runmake tmp/hamcorebuilder
}


do_install() {
        install -d ${D}${bindir}/
        install -m 0755    ${S}/tmp/hamcorebuilder     ${D}${bindir}/hamcorebuilder
}



