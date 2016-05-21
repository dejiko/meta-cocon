# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_libc-musl += "file://0001-backtrace-Use-only-with-glibc-and-uclibc.patch \
                             file://0001-x86-Stub-out-x86_local_resume.patch \
                             file://0001-disable-tests.patch \
"

