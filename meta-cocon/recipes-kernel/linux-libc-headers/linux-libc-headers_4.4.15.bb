KORG_ARCHIVE_COMPRESSION = "xz"

require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

SRC_URI[md5sum] = "7b59c25c783173969bfb62cac4f057ce"
SRC_URI[sha256sum] = "303634711f0f39806fdbfaae69f59be26b46ef45f080c7d801a26864e264acb0"

SRC_URI_append_libc-musl = "\
    file://0001-libc-compat.h-fix-some-issues-arising-from-in6.h-4.4.15.patch \
    file://0002-libc-compat.h-prevent-redefinition-of-struct-ethhdr-4.4.15.patch \
    file://0003-remove-inclusion-of-sysinfo.h-in-kernel.h.patch \
"

