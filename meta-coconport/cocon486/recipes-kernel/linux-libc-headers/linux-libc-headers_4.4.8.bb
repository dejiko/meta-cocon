KORG_ARCHIVE_COMPRESSION = "xz"

require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

SRC_URI[md5sum] = "d6430ac57c5f1830798095b7147908e4"
SRC_URI[sha256sum] = "d2a7a7536a5012cc2e6ab1ddf3d31320b4420cc4de3a4c2cda1daed8663bee09"

SRC_URI_append_libc-musl = "\
    file://libc-4.3-portability.patch \
"

