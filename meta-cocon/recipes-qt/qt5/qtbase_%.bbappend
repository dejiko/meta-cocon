# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_libc-musl += "file://qt-musl-iconv-no-bom.patch \
                             file://qtgui-5.5.1-crash.patch \
"

PACKAGECONFIG_X11 = "xcb xvideo xsync xshape xrender xrandr xfixes xinput2 xinput xinerama xcursor glib xkb"
PACKAGECONFIG_FONTS = "freetype fontconfig"

