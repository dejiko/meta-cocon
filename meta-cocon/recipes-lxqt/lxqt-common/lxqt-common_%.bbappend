# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# opencocon don't use oxygen.
RRECOMMENDS_${PN} = "qtsvg-plugins"

# delete some files unneed on opencocon
do_install_append() {
  rm ${D}${datadir}/kdm/sessions/lxqt.desktop
  rm ${D}${sysconfdir}/xdg/autostart/*.desktop
}
