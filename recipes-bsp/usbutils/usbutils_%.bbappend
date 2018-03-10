# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DEPENDS += "virtual/libiconv"

do_compile_prepend_linux-uclibc() {
        sed -i \
                -e s:'LDFLAGS = ':'LDFLAGS = -liconv ':g \
                ${WORKDIR}/build/Makefile
}

