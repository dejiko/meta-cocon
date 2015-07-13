# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

USERADD_PARAM_${PN} = "--create-home \
                       --groups video,tty,audio,input,shutdown,disk,netdev \
                       --user-group xuser"
