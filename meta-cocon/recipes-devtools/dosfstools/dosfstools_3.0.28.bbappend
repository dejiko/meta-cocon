FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_libc-musl += "file://largefile.patch \
                             file://0001-mkfs.fat-fix-incorrect-int-type.patch \
"

CFLAGS += "-D_GNU_SOURCE ${@bb.utils.contains('DISTRO_FEATURES', 'largefile', '-D_LARGEFILE_SOURCE -D_FILE_OFFSET_BITS=64', '', d)}"

