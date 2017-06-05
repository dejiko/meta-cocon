require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

SRC_URI_append_libc-musl = "\
    file://0001-libc-compat.h-fix-some-issues-arising-from-in6.h.patch \
    file://0002-libc-compat.h-prevent-redefinition-of-struct-ethhdr.patch \
    file://0003-remove-inclusion-of-sysinfo.h-in-kernel.h.patch \
   "

SRC_URI[md5sum] = "d8f9218277a3f0d2e1703676002be428"
SRC_URI[sha256sum] = "5bfd9ed52c1ccd8dcd6418646d5a78b0af501cfdcd3e0900f1918ecba1a8af97"

