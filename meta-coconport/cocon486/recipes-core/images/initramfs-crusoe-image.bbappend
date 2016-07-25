FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

IMAGE_INSTALL += " \
kernel-module-usb-storage \
kernel-module-ohci-hcd \
kernel-module-uhci-hcd \
kernel-module-ehci-hcd \
kernel-module-ehci-pci \
kernel-module-ehci-platform \
kernel-module-sl811-hcd \
kernel-module-ssb-hcd \
kernel-module-ssb \
kernel-module-xhci-hcd \
kernel-module-c67x00 \
kernel-module-firewire-core \
kernel-module-firewire-ohci \
kernel-module-firewire-sbp2 \
eject \
kernel-module-pata-pcmcia \
kernel-module-pata-ninja32 \
kernel-module-tcic \
kernel-module-pcmcia \
kernel-module-pd6729 \
kernel-module-i82365 \
kernel-module-yenta-socket \
pcmciautils \
"

