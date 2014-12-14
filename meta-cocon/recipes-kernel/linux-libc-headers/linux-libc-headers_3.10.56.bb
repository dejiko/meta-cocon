require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

#SRC_URI += "file://0001-ptrace.h-remove-ptrace_peeksiginfo_args.patch"
#SRC_URI += "file://scripts-Makefile.headersinst-install-headers-from-sc.patch"

KORG_ARCHIVE_COMPRESSION = "xz"

SRC_URI[md5sum] = "97505772fb888d755185403e905e6bb1"
SRC_URI[sha256sum] = "2a7d0df1efec4731199346568345de0f4c0a1d4ae3dbd1447457e91654cb000b"

