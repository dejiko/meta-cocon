# opencocon thinclient master image (all plathome)

IMAGE_PKGTYPE = "ipk"


IMAGE_NAME = "opencocon-canvas-${DISTRO_VERSION}-${MACHINE}"

# TODO : postprocess?
#IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

DISTRO_UPDATE_ALTERNATIVES ?= "${PREFERRED_PROVIDER_virtual/update-alternatives}"

DISTRO_PACKAGE_MANAGER ?= "ipkg ipkg-collateral"
ONLINE_PACKAGE_MANAGEMENT = "no"

# FIXME: We need a distro-indendent way of specifying feed configs.
# Once the RFC for the DISTRO_FEED_CONFIGS variable name is approved,
# we can remove this default definition and set it in the distro config.
#DISTRO_FEED_CONFIGS ?= "${ANGSTROM_FEED_CONFIGS}"


# TODO : packagegroup-opencocon-thinclient-${MACHINE} to be packagegroup-opencocon-${MACHINE}
COCON_CANVAS_PACKAGES = " \
packagegroup-opencocon-canvas \
packagegroup-opencocon-canvas-x11 \
packagegroup-opencocon-thinclient-${MACHINE} \
packagegroup-opencocon-thinclient-${MACHINE}-xorg \
packagegroup-opencocon-debug-${MACHINE} \
packagegroup-opencocon-thinclient-caravan \
packagegroup-opencocon-debug \
packagegroup-opencocon-common \
packagegroup-opencocon-common-xorg \
packagegroup-opencocon-thinclient-sound \
"

RDEPENDS = "${COCON_CANVAS_PACKAGES}"
IMAGE_INSTALL = "${COCON_CANVAS_PACKAGES}"

PACKAGE_EXCLUDE = "linux-firmware \
pulseaudio-module-null-source \
"

IMAGE_BASENAME = "coconcanvas"
IMAGE_FSTYPES += "tar.gz squashfs"

inherit image
