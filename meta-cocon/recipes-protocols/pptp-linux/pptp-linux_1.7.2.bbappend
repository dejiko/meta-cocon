# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# patches from buildroot
SRC_URI_append += "file://pptp-linux-1.7.0-001-susv3-legacy.patch \
                   file://pptp-linux-1.7.2-ip-path.patch \
                   file://pptp-linux-1.7.2-drop-stropts.patch \
"

