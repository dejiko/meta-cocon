# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

do_install_qppend() {
  # current opencocon : not need pulseaudio hock
  rm ${D}${datadir}/alsa/alsa.conf.d/*.conf
}

