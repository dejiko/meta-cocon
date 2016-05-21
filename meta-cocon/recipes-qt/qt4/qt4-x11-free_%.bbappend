# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_libc-musl += "file://qtcore-4.8.5-honor-ExcludeSocketNotifiers-in-glib-event-loop.patch \
                             file://qtcore-4.8.5-moc-boost-lexical-cast.patch \
                             file://qtcore-4.8.7-fix-socklent-for-musl.patch \
"
