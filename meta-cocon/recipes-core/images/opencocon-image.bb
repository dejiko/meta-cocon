# opencocon thinclient master image (all plathome)

IMAGE_PKGTYPE = "ipk"


IMAGE_NAME = "opencocon-${DISTRO_VERSION}-${MACHINE}"

# TODO : postprocess?
#IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

DISTRO_UPDATE_ALTERNATIVES ?= "${PREFERRED_PROVIDER_virtual/update-alternatives}"

DISTRO_PACKAGE_MANAGER ?= "ipkg ipkg-collateral"
ONLINE_PACKAGE_MANAGEMENT = "no"

# FIXME: We need a distro-indendent way of specifying feed configs.
# Once the RFC for the DISTRO_FEED_CONFIGS variable name is approved,
# we can remove this default definition and set it in the distro config.
#DISTRO_FEED_CONFIGS ?= "${ANGSTROM_FEED_CONFIGS}"


COCON_TC_PACKAGES = " \
packagegroup-opencocon-thinclient \
packagegroup-opencocon-thinclient-${MACHINE} \
packagegroup-opencocon-thinclient-${MACHINE}-xorg \
packagegroup-opencocon-thinclient-caravan \
packagegroup-opencocon-thinclient-sound \
packagegroup-opencocon-thinclient-vpn \
"

RDEPENDS = "${COCON_TC_PACKAGES}"
IMAGE_INSTALL = "${COCON_TC_PACKAGES}"

IMAGE_BASENAME = "opencocon"
IMAGE_FSTYPES += " tar.gz squashfs ext4.gz"

inherit image
