# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DEPENDS += "libiconv"

do_compile_prepend() {
        sed -i \
                -e s:'LDFLAGS = ':'LDFLAGS = -liconv ':g \
                ${WORKDIR}/build/Makefile
}

