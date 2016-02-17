
# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"


LIC_FILES_CHKSUM += "file://LICENCE.agere;md5=af0133de6b4a9b2522defd5f188afd31 \
                     file://LICENCE.OLPC;md5=5b917f9d8c061991be4f6f5f108719cd \
                   "

PACKAGES =+ "${PN}-agere-license ${PN}-orinoco \
             ${PN}-iwlwifi-5150-2 ${PN}-iwlwifi-5000-5 \
             ${PN}-iwlwifi-1000-5 ${PN}-iwlwifi-100-5 ${PN}-iwlwifi-105-6 ${PN}-iwlwifi-2000-6 \
             ${PN}-iwlwifi-2030-6 ${PN}-iwlegacy-3945-2 ${PN}-iwlegacy-4965-2 \
             ${PN}-usb8388 ${PN}-usb8388-thinfirm ${PN}-mwl8366 ${PN}-mwl8687 \
             ${PN}-pcie8897 ${PN}-pcie8797 \
             ${PN}-rtl8192de ${PN}-rtl8192se ${PN}-rtl8723ae ${PN}-rtl8192e \
             ${PN}-rtl-nic"

# Agere
FILES_${PN}-agere-license = "/lib/firmware/LICENCE.agere"

LICENSE_${PN}-orinoco = "Firmware:LICENCE.agere"
FILES_${PN}-orinoco = " \
  /lib/firmware/agere_sta_fw.bin \
"
RDEPENDS_${PN}-orinoco += "${PN}-agere-license"

# iwlwifi (Intel)
# some device already supports by upstream.

RDEPENDS_${PN}-iwlwifi-5150-2 = "${PN}-iwlwifi-license"
RDEPENDS_${PN}-iwlwifi-5000-5 = "${PN}-iwlwifi-license"
RDEPENDS_${PN}-iwlwifi-1000-5 = "${PN}-iwlwifi-license"
RDEPENDS_${PN}-iwlwifi-100-5 = "${PN}-iwlwifi-license"
RDEPENDS_${PN}-iwlwifi-105-6 = "${PN}-iwlwifi-license"
RDEPENDS_${PN}-iwlwifi-2000-6 = "${PN}-iwlwifi-license"
RDEPENDS_${PN}-iwlwifi-2030-6 = "${PN}-iwlwifi-license"
RDEPENDS_${PN}-iwlegacy-3945-2 = "${PN}-iwlwifi-license"
RDEPENDS_${PN}-iwlegacy-4965-2 = "${PN}-iwlwifi-license"

FILES_${PN}-iwlwifi-5150-2 = "/lib/firmware/iwlwifi-5150-2.ucode"
FILES_${PN}-iwlwifi-5000-5 = "/lib/firmware/iwlwifi-5000-5.ucode"
FILES_${PN}-iwlwifi-1000-5 = "/lib/firmware/iwlwifi-1000-5.ucode"
FILES_${PN}-iwlwifi-100-5 = "/lib/firmware/iwlwifi-100-5.ucode"
FILES_${PN}-iwlwifi-105-6 = "/lib/firmware/iwlwifi-105-6.ucode"
FILES_${PN}-iwlwifi-2000-6 = "/lib/firmware/iwlwifi-2000-6.ucode"
FILES_${PN}-iwlwifi-2030-6 = "/lib/firmware/iwlwifi-2030-6.ucode"
FILES_${PN}-iwlegacy-3945-2 = "/lib/firmware/iwlwifi-3945-2.ucode"
FILES_${PN}-iwlegacy-4965-2 = "/lib/firmware/iwlwifi-4965-2.ucode"


# Marvell

# -- Libertas
# sd8686 is already propide by upstream
LICENSE_${PN}-usb8388 = "Firmware-Marvell"
LICENSE_${PN}-usb8388-thinfirm = "Firmware-OLPC"

FILES_${PN}-usb8388 = "/lib/firmware/libertas/usb8388_v9.bin \
                       /lib/firmware/libertas/usb8388_v5.bin"
FILES_${PN}-usb8388-thinfirm = "/lib/firmware/lbtf_usb.bin"

# -- Mwl8k
# mwl8363 is non-distributable
LICENSE_${PN}-mwl8366 = "Firmware-Marvell"
LICENSE_${PN}-mwl8687 = "Firmware-Marvell"


FILES_${PN}-mwl8366 = "/lib/firmware/mwl8k/fmimage_8366.fw \
                       /lib/firmware/mwl8k/fmimage_8366_ap-2.fw \
                       /lib/firmware/mwl8k/fmimage_8366_ap-3.fw \
                       /lib/firmware/mwl8k/helper_8366.fw"
FILES_${PN}-mwl8687 = "/lib/firmware/mwl8k/fmimage_8687.fw \
                       /lib/firmware/mwl8k/helper_8687.fw"

# -- Mwifiex
# sd8797, sd8787 is already propide by upstream
# skip : sd8786, sd8897
# TODO : sd8766
LICENSE_${PN}-pcie8897 = "Firmware-Marvell"
LICENSE_${PN}-pcie8797 = "Firmware-Marvell"

FILES_${PN}-pcie8897 = "/lib/firmware/mrvl/pcie8897_uapsta.bin"
FILES_${PN}-pcie8797 = "/lib/firmware/mrvl/usb8797_uapsta.bin"


# Realtek
# 8192cu,ce,su is already propide by upstream
# RTL8192U is non-distributable

LICENSE_${PN}-rtl8192de = "Firmware-rtlwifi"
FILES_${PN}-rtl8192de = "/lib/firmware/rtlwifi/rtl8192defw.bin"

LICENSE_${PN}-rtl8192se = "Firmware-rtlwifi"
FILES_${PN}-rtl8192se = "/lib/firmware/rtlwifi/rtl8192sefw.bin"

LICENSE_${PN}-rtl8723ae = "Firmware-rtlwifi"
FILES_${PN}-rtl8723ae = "/lib/firmware/rtlwifi/rtl8723fw.bin \
                         /lib/firmware/rtlwifi/rtl8723fw_B.bin"

LICENSE_${PN}-rtl8192e = "Firmware-rtlwifi"
FILES_${PN}-rtl8192e = "/lib/firmware/RTL8192E/*"

# already propide by rtl8192su
#LICENSE_${PN}-rtl8712u = "Firmware-rtlwifi"
#FILES_${PN}-rtl8712u = "/lib/firmware/rtlwifi/rtl8712u.bin"

# Disabled
#LICENSE_${PN}-rtl8188eu = "Firmware-rtlwifi"
#FILES_${PN}-rtl8188eu = "/lib/firmware/rtlwifi/rtl8188eufw.bin"

# rtl-nic
LICENSE_${PN}-rtl-nic = "Firmware-rtlwifi"

FILES_${PN}-rtl-nic = " \
  /lib/firmware/rtl_nic/* \
"


