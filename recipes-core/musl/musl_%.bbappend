FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# math-round.patch : https://bugs.alpinelinux.org/issues/4248
SRC_URI += "file://math-round.patch \
"

