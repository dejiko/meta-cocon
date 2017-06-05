# linux-sunxi-common (Mainline)

require recipes-kernel/linux/linux-dtb.inc


# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

# Default is to use stable kernel version
# If you want to use latest git version set to "1"
#DEFAULT_PREFERENCE = "-1"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

