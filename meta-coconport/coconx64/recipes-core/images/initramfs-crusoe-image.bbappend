FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

IMAGE_FSTYPES += "cramfs.gz"

IMAGE_INSTALL += " \
kernel-module-usb-storage \
kernel-module-ohci-hcd \
kernel-module-uhci-hcd \
kernel-module-ehci-hcd \
kernel-module-ehci-pci \
kernel-module-ehci-platform \
kernel-module-xhci-hcd \
kernel-module-firewire-core \
kernel-module-firewire-ohci \
kernel-module-firewire-sbp2 \
eject \
kernel-module-pata-pcmcia \
kernel-module-pata-ninja32 \
kernel-module-pcmcia \
kernel-module-yenta-socket \
pcmciautils \
"

