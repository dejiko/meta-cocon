# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_cocon486 += "file://cocon486/defconfig"
SRC_URI_append_ac100 += "file://ac100/defconfig"
SRC_URI_append_coconx64 += "file://coconx64/defconfig"

