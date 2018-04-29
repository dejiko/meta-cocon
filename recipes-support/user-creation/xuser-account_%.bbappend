# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

USERADD_PARAM_${PN} = "--create-home \
                       --groups audio,video,tty,input,shutdown,disk \
                       --user-group xuser"
