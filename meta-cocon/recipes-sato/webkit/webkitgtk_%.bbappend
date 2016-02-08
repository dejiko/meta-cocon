# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# use newer make : 3.x is freeze during make
DEPENDS += "make-native"

