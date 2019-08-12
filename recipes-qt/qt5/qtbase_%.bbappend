# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

#PACKAGECONFIG_X11 = "xcb xcb-xinput glib xkbcommon"
PACKAGECONFIG_FONTS = "freetype fontconfig"
PACKAGECONFIG_DISTRO = "accessibility openssl"
