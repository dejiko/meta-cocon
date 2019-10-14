DESCRIPTION = "opencocon thin-client focused desktop environment"
SECTION = "base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
DEPENDS = "cocon-data dialog"

SRC_URI = "file://panel \
	   file://gtkrc \
	   file://cocon-caravan-launch \
	   file://cocon-freerdp-launch \
	   file://cocon-cnf-copynm \
	   file://cocon-menu \
	   file://cocon-menu-launch \
	   file://cocon-netset-launch \
	   file://cocon-vnc-launch \
	   file://cocon-xephyr-launch \
	   file://cocon-spice-launch \
	   file://lxterminal.conf \
	   file://xinitrc \ 
	   file://cocon-pre-startx \
	   file://cocon-option-menu \
	   file://spicy-settings \
           file://cocon-x-session \
           file://50-org.freedesktop.NetworkManager.rules \
           file://cocon-select-kbd \
           file://dialogrc \
           file://cocon-vpn-menu \
           file://cocon-softether-launch \
"


S="${WORKDIR}"

do_install() {
	set -ex

        install -d ${D}${bindir}/
	install -d ${D}${sysconfdir}/init.d/
        install -m 0755    ${WORKDIR}/cocon-cnf-copynm          ${D}${sysconfdir}/init.d/cocon-cnf-copynm
	install -m 0755    ${WORKDIR}/cocon-caravan-launch     ${D}${bindir}/cocon-caravan-launch
	install -m 0755    ${WORKDIR}/cocon-freerdp-launch     ${D}${bindir}/cocon-freerdp-launch
	install -m 0755    ${WORKDIR}/cocon-menu     ${D}${bindir}/cocon-menu
	install -m 0755    ${WORKDIR}/cocon-menu-launch     ${D}${bindir}/cocon-menu-launch
	install -m 0755    ${WORKDIR}/cocon-netset-launch     ${D}${bindir}/cocon-netset-launch
	install -m 0755    ${WORKDIR}/cocon-vnc-launch     ${D}${bindir}/cocon-vnc-launch
	install -m 0755    ${WORKDIR}/cocon-xephyr-launch     ${D}${bindir}/cocon-xephyr-launch
	install -m 0755    ${WORKDIR}/cocon-pre-startx     ${D}${sysconfdir}/init.d/cocon-pre-startx
	install -m 0755    ${WORKDIR}/cocon-option-menu     ${D}${bindir}/cocon-option-menu
        install -m 0755    ${WORKDIR}/cocon-spice-launch    ${D}${bindir}/cocon-spice-launch
        install -m 0755    ${WORKDIR}/cocon-x-session    ${D}${bindir}/cocon-x-session
        install -m 0755    ${WORKDIR}/cocon-select-kbd   ${D}${bindir}/cocon-select-kbd
        install -m 0755    ${WORKDIR}/cocon-vpn-menu   ${D}${bindir}/cocon-vpn-menu
        install -m 0755    ${WORKDIR}/cocon-softether-launch   ${D}${bindir}/cocon-softether-launch

        install -d ${D}${sysconfdir}/
        install -m 0644 ${WORKDIR}/dialogrc ${D}${sysconfdir}/dialogrc
	install -d ${D}${sysconfdir}/gtk-2.0
	install -m 0644 ${WORKDIR}/gtkrc ${D}${sysconfdir}/gtk-2.0/gtkrc

	# TODO : to global settings...
	install -d ${D}${sysconfdir}/skel
	install -d ${D}${sysconfdir}/skel/.config/lxpanel/default/panels	
	install -d ${D}${sysconfdir}/skel/.config/lxterminal
	install -d ${D}${sysconfdir}/skel/.config/spicy
        install -d ${D}${sysconfdir}/polkit-1/
        install -d ${D}${sysconfdir}/polkit-1/rules.d/
	# v10 : moved from skel/.xinitrc
	install -m 0755 ${WORKDIR}/xinitrc ${D}${bindir}/x-window-manager
	install -m 0644 ${WORKDIR}/panel ${D}${sysconfdir}/skel/.config/lxpanel/default/panels/panel
	install -m 0644 ${WORKDIR}/lxterminal.conf ${D}${sysconfdir}/skel/.config/lxterminal/lxterminal.conf
	install -m 0644 ${WORKDIR}/spicy-settings ${D}${sysconfdir}/skel/.config/spicy/settings
        install -m 0644 ${WORKDIR}/50-org.freedesktop.NetworkManager.rules ${D}${sysconfdir}/polkit-1/rules.d/50-org.freedesktop.NetworkManager.rules

}

PACKAGES =+ "${PN}-copynm ${PN}-pre-startx"
FILES_${PN}-copynm = "${sysconfdir}/init.d/cocon-cnf-copynm"
FILES_${PN}-pre-startx = "${sysconfdir}/init.d/cocon-pre-startx"

inherit update-rc.d

INITSCRIPT_PACKAGES = "${PN}-copynm ${PN}-pre-startx"
INITSCRIPT_NAME_${PN}-copynm = "cocon-cnf-copynm"
INITSCRIPT_PARAMS_${PN}-copynm = "start 45 S ."
INITSCRIPT_NAME_${PN}-pre-startx = "cocon-pre-startx"
INITSCRIPT_PARAMS_${PN}-pre-startx = "start 00 5 ."

FILES_${PN} = "/"

