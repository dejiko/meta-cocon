KORG_ARCHIVE_COMPRESSION = "xz"

require recipes-kernel/linux-libc-headers/linux-libc-headers.inc


SRC_URI_append_libc-musl = "\
    file://0001-libc-compat.h-fix-some-issues-arising-from-in6.h-4.4.15.patch \
    file://0002-libc-compat.h-prevent-redefinition-of-struct-ethhdr-4.4.15.patch \
    file://0003-remove-inclusion-of-sysinfo.h-in-kernel.h.patch \
"

SRC_URI[md5sum] = "ebf8185c276d94e76eae79aaa778e8da"
SRC_URI[sha256sum] = "53f8cd8b024444df0f242f8e6ab5147b0b009d7a30e8b2ed3854e8d17937460d"
