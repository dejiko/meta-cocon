KORG_ARCHIVE_COMPRESSION = "xz"

require recipes-kernel/linux-libc-headers/linux-libc-headers.inc


SRC_URI_append_libc-musl = "\
    file://0001-libc-compat.h-fix-some-issues-arising-from-in6.h-4.4.15.patch \
    file://0002-libc-compat.h-prevent-redefinition-of-struct-ethhdr-4.4.15.patch \
    file://0003-remove-inclusion-of-sysinfo.h-in-kernel.h.patch \
"

SRC_URI[md5sum] = "6f7f4cb7ceaac770eadf0c7a18ef5225"
SRC_URI[sha256sum] = "e4944ca5bb0bdf63a7e97dc7fbdd38bcc820d8b3b57c4a3a7b3bf9c8a48216b7"
