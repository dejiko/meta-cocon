# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGECONFIG = "alsa pulseaudio gstreamer gtk"
