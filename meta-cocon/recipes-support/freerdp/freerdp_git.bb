# Copyright (C) 2010, 2011, O.S. Systems Software Ltda.
# Released under the MIT license

include freerdp.inc

#inherit gitpkgv

#PV = "gitr${SRCPV}"
#PKGV = "${GITPKGVTAG}"
#PR = "${INC_PR}.11"

SRCREV = "ff9d7abf3462debf575999a3f5ae24269a50af78"

# v6
#SRCREV = "15a22eb9c9656fab41cefbe9e39e4b70162bece2"

# Tested v9(first commit of correct keymap)
#SRCREV = "de9156e4a0dd6bf71b88d3c4bbd875ea48cd380a"

# Stable tree (v3?)
##SRCREV = "15069020d398c203df921da93eb1b72f55b6010a"

SRC_URI = "git://anonscm.debian.org/collab-maint/freerdp.git \
           file://futimens_cocon_v2.patch \
           file://cocon-fullscreen-v2.patch \
"

GITPKGVTAG = "${SRCREV}"

S = "${WORKDIR}/git"

#CMAKE_MODULE_PATH += " ${S}/cmake/ "

