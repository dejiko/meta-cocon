# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

LDFLAGS_prepend_libc-uclibc = " -lrt -lpthread -liconv "

DEPENDS_append_libc-uclibc = " virtual/libiconv "

