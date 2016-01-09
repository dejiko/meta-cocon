# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

#CFLAGS_append = " -liconv "
#LDFLAGS_append += " -liconv "

EXTRA_OECONF += " --with-libiconv=gnu "
