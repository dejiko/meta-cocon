KORG_ARCHIVE_COMPRESSION = "xz"

require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

SRC_URI[md5sum] = "fb3ef8da32a25607807887b9567a6927"
SRC_URI[sha256sum] = "2c6aec73fd868db12d29dfa2dc34d6cfa04b0e3e5ae65be34c2cb30243470e2e"

SRC_URI_append_libc-musl += "file://glibc-specific-inclusion-of-sysinfo.h-in-kernel.h.patch \
                             file://linux-3.18.26-libc-compat.h-fix-some-issues-arising-from-in6.h.patch \
                             file://libc-compat.h-prevent-redefinition-of-struct-ethhdr.patch \
"

