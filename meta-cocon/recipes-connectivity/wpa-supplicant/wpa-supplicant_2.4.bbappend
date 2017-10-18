FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

# Backport patches from Debian:
# https://anonscm.debian.org/git/collab-maint/wpa.git/tree/debian/patches?h=debian/stretch&id=32d6b6e16dc1b39f624fab636a59f3c920738d57
SRC_URI_append += " \
file://0001-WPS-Reject-a-Credential-with-invalid-passphrase.patch \
file://0002-Reject-psk-parameter-set-with-invalid-passphrase-cha.patch \
file://0003-Remove-newlines-from-wpa_supplicant-config-network-o.patch \
file://0004-Reject-SET_CRED-commands-with-newline-characters-in-.patch \
file://0005-Reject-SET-commands-with-newline-characters-in-the-s.patch \
file://backported-WNM-Ignore-Key-Data-in-WNM-Sleep-Mode-Response-frame.patch \
file://1001-hostapd-Avoid-key-reinstallation-in-FT-handshake.patch \
file://1002-Prevent-reinstallation-of-an-already-in-use-group-ke.patch \
file://1003-Extend-protection-of-GTK-IGTK-reinstallation-of-WNM-.patch \
file://1004-Fix-TK-configuration-to-the-driver-in-EAPOL-Key-3-4-.patch \
file://1005-Prevent-installation-of-an-all-zero-TK.patch \
file://1006-Fix-PTK-rekeying-to-generate-a-new-ANonce.patch \
file://1007-TDLS-Reject-TPK-TK-reconfiguration.patch \
file://1008-WNM-Ignore-Key-Data-in-WNM-Sleep-Mode-Response-frame.patch \
file://1009-WNM-Ignore-WNM-Sleep-Mode-Response-if-WNM-Sleep-Mode.patch \
file://1010-WNM-Ignore-WNM-Sleep-Mode-Response-without-pending-r.patch \
file://1011-FT-Do-not-allow-multiple-Reassociation-Response-fram.patch \
file://1012-TDLS-Ignore-incoming-TDLS-Setup-Response-retries.patch \
"
