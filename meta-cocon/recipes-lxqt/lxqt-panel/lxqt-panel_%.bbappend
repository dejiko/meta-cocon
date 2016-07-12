# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGECONFIG = "volume_alsa_plugin volume_pulse_plugin"

RDEPENDS_${PN} += "libxcomposite"
