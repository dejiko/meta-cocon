# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append += "file://python3.patch"

# force enable python3 instead python2
RDEPENDS_${PN}-spy = ""
RDEPENDS_${PN}-spy_remove = "python"
RDEPENDS_${PN}-spy += "python3-core"
