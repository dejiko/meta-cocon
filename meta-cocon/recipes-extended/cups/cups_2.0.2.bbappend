# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

LIBS += " -liconv "
export LIBS

DEPENDS_append_libc-uclibc = " virtual/libiconv "

