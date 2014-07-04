DESCRIPTION = "opencocon thin-client focused desktop environment"
SECTION = "base"
LICENSE = "MIT"
DEPENDS = "cocon-data spmachine-486 dialog lxterminal"
LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://COPYING.MIT \
	   file://panel \
	   file://gtkrc \
	   file://cocon-caravan-launch \
	   file://cocon-freerdp-launch \
	   file://cocon-init \
	   file://cocon-menu \
	   file://cocon-menu-launch \
	   file://cocon-netset-launch \
	   file://cocon-vnc-launch \
	   file://cocon-xephyr-launch \
	   file://cocon-spice-launch \
	   file://lxterminal.conf \
	   file://midori-config \
	   file://xinitrc \ 
	   file://cocon-startx \
	   file://cocon-option-menu \
	   file://spicy-settings \
           file://cocon-x-session \
           file://50-org.freedesktop.NetworkManager.rules \
           file://cocon-select-kbd \
           file://dialogrc \
"


S="${WORKDIR}"

do_install() {
	set -ex

        install -d ${D}${base_bindir}/
        install -m 0755    ${WORKDIR}/cocon-init          ${D}${base_bindir}/cocon-init

	install -d ${D}${bindir}/
	install -m 0755    ${WORKDIR}/cocon-caravan-launch     ${D}${bindir}/cocon-caravan-launch
	install -m 0755    ${WORKDIR}/cocon-freerdp-launch     ${D}${bindir}/cocon-freerdp-launch
	install -m 0755    ${WORKDIR}/cocon-menu     ${D}${bindir}/cocon-menu
	install -m 0755    ${WORKDIR}/cocon-menu-launch     ${D}${bindir}/cocon-menu-launch
	install -m 0755    ${WORKDIR}/cocon-netset-launch     ${D}${bindir}/cocon-netset-launch
	install -m 0755    ${WORKDIR}/cocon-vnc-launch     ${D}${bindir}/cocon-vnc-launch
	install -m 0755    ${WORKDIR}/cocon-xephyr-launch     ${D}${bindir}/cocon-xephyr-launch
	install -m 0755    ${WORKDIR}/cocon-startx     ${D}${bindir}/cocon-startx
	install -m 0755    ${WORKDIR}/cocon-option-menu     ${D}${bindir}/cocon-option-menu
        install -m 0755    ${WORKDIR}/cocon-spice-launch    ${D}${bindir}/cocon-spice-launch
        install -m 0755    ${WORKDIR}/cocon-x-session    ${D}${bindir}/cocon-x-session
        install -m 0755    ${WORKDIR}/cocon-select-kbd   ${D}${bindir}/cocon-select-kbd

        install -d ${D}${sysconfdir}/
        install -m 0644 ${WORKDIR}/dialogrc ${D}${sysconfdir}/dialogrc
	install -d ${D}${sysconfdir}/gtk-2.0
	install -m 0644 ${WORKDIR}/gtkrc ${D}${sysconfdir}/gtk-2.0/gtkrc

	# TODO : to global settings...
	install -d ${D}${sysconfdir}/skel
	install -d ${D}${sysconfdir}/skel/.config/lxpanel/default/panels	
	install -d ${D}${sysconfdir}/skel/.config/lxterminal
	install -d ${D}${sysconfdir}/skel/.config/midori
	install -d ${D}${sysconfdir}/skel/.config/spicy
        install -d ${D}${sysconfdir}/polkit-1/
        install -d ${D}${sysconfdir}/polkit-1/rules.d/
	install -m 0755 ${WORKDIR}/xinitrc ${D}${sysconfdir}/skel/.xinitrc
	install -m 0644 ${WORKDIR}/panel ${D}${sysconfdir}/skel/.config/lxpanel/default/panels/panel
	install -m 0644 ${WORKDIR}/lxterminal.conf ${D}${sysconfdir}/skel/.config/lxterminal/lxterminal.conf
	install -m 0644 ${WORKDIR}/midori-config ${D}${sysconfdir}/skel/.config/midori/config
	install -m 0644 ${WORKDIR}/spicy-settings ${D}${sysconfdir}/skel/.config/spicy/settings
        install -m 0644 ${WORKDIR}/50-org.freedesktop.NetworkManager.rules ${D}${sysconfdir}/polkit-1/rules.d/50-org.freedesktop.NetworkManager.rules

}


FILES_${PN} = "/"

