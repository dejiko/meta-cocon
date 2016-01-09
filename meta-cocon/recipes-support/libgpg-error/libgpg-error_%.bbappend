# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# Workaround : opencocon use TARGET_ARCH=i486
do_compile_prepend() {
  cp ${S}/src/syscfg/lock-obj-pub.i486-pc-linux-gnu.h \
      ${S}/src/syscfg/lock-obj-pub.${TARGET_ARCH}-unknown-linux-gnu.h
}

