FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

SRC_URI_append = " \
    file://Xserver_xuser.patch \
"
