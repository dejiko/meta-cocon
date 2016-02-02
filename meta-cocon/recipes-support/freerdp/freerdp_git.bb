# Copyright (C) 2010, 2011, O.S. Systems Software Ltda.
# Released under the MIT license

include freerdp.inc

# Currently opencocon uses debian branch.
SRCREV = "160c3dad43f5ece0c11a22003b058820dea6a869"

SRC_URI = "git://anonscm.debian.org/collab-maint/freerdp.git \
           file://futimens_cocon_v2.patch \
           file://cocon-fullscreen-v2.patch \
           file://0003-dont-use-unavailable-c99-math-debian.patch \
"

GITPKGVTAG = "${SRCREV}"

S = "${WORKDIR}/git"

