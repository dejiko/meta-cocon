# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DEPENDS_remove = "gtk+3"
DEPENDS_append += " gtk+"

# force GTK+2 from Arch
do_configure_prepend() {
  sed -e 's/2.90/2.24/' -e 's/gtk+-3.0/gtk+-2.0/' -i ${S}/configure.ac
}

