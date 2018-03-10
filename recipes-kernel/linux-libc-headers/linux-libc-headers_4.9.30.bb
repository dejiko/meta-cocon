require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

SRC_URI_append_libc-musl = "\
    file://0001-libc-compat.h-fix-some-issues-arising-from-in6.h.patch \
    file://0002-libc-compat.h-prevent-redefinition-of-struct-ethhdr.patch \
    file://0003-remove-inclusion-of-sysinfo.h-in-kernel.h.patch \
   "

SRC_URI[md5sum] = "7b56bb1196642f0f6625906c6720a6b1"
SRC_URI[sha256sum] = "150bb7f2dd4849b5d21b8ccd8d05294a48229e1fcb93a22e7b806a79ec0b0e45"

