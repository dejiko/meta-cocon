# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

do_configure_prepend_linux-uclibc() {
        sed -i \
                -e s:'LIBRESOLV=-lresolv':'LIBRESOLV=':g \
                ${S}/lib/configure

#        sed -i \
#                -e s:'WITH_LIBS+=-lresolv':'WITH_LIBS+=':g \
#                ${S}/lib/config.mk
}

