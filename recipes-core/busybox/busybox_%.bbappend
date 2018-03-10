# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append += "file://opencocon.cfg"

# jethro isn't include init.d support, then add on this part.

SRC_URI_append += " \
  file://inittab \
  file://rcS \
  file://rcK \
  file://runlevel \
"

do_install_append () {
  install -d ${D}${sysconfdir}/init.d

  if grep "CONFIG_INIT=y" ${B}/.config; then
    install -D -m 0777 ${WORKDIR}/rcS ${D}${sysconfdir}/init.d/rcS
    install -D -m 0777 ${WORKDIR}/rcK ${D}${sysconfdir}/init.d/rcK
    install -D -m 0755 ${WORKDIR}/runlevel ${D}${base_sbindir}/runlevel
    if grep "CONFIG_FEATURE_USE_INITTAB=y" ${B}/.config; then
      install -D -m 0777 ${WORKDIR}/inittab ${D}${sysconfdir}/inittab
    fi
  fi

  # Remove the sysvinit specific configuration file for systemd systems to avoid confusion
  if ${@bb.utils.contains('DISTRO_FEATURES', 'sysvinit', 'false', 'true', d)}; then
    rm -f ${D}${sysconfdir}/syslog-startup.conf.${BPN}
  fi
}
