FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_libc-musl += "file://1.2.5-musl-fix.diff"

# Overwrite SRCREV
SRCREV = "2a3e9996b33d1299ee5322e6f3f0a54e594ae8ee"

DEPENDS_append_libc-musl += "bsd-headers"
