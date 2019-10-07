DESCRIPTION = "zd1211 wifi files for the Linux kernel"
HOMEPAGE = "http://zd1211.ath.cx/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=eb723b61539feef013de476e68b5c50a"

inherit allarch

SRC_URI = "${SOURCEFORGE_MIRROR}/zd1211/${PN}-${PV}.tar.bz2"

S = "${WORKDIR}/${PN}/"
FIRMWARE_PATH = "${base_libdir}/firmware/zd1211/"

do_compile() {
	:
}

do_install() {
	install -d ${D}${FIRMWARE_PATH}/zd1211/
	install -m 0644 ${S}/zd1211b_ub ${D}${FIRMWARE_PATH}/zd1211b_ub
	install -m 0644 ${S}/zd1211b_uph ${D}${FIRMWARE_PATH}/zd1211b_uph
	install -m 0644 ${S}/zd1211b_uphm ${D}${FIRMWARE_PATH}/zd1211b_uphm
	install -m 0644 ${S}/zd1211b_uphr ${D}${FIRMWARE_PATH}/zd1211b_uphr
	install -m 0644 ${S}/zd1211b_ur ${D}${FIRMWARE_PATH}/zd1211b_ur
	install -m 0644 ${S}/zd1211_ub ${D}${FIRMWARE_PATH}/zd1211_ub
	install -m 0644 ${S}/zd1211_uph ${D}${FIRMWARE_PATH}/zd1211_uph
	install -m 0644 ${S}/zd1211_uphm ${D}${FIRMWARE_PATH}/zd1211_uphm
	install -m 0644 ${S}/zd1211_uphr ${D}${FIRMWARE_PATH}/zd1211_uphr
	install -m 0644 ${S}/zd1211_ur ${D}${FIRMWARE_PATH}/zd1211_ur
}

PACKAGES = "${PN}"
FILES_${PN} = " \
	${FIRMWARE_PATH}/zd1211b_ub \
	${FIRMWARE_PATH}/zd1211b_uph \
	${FIRMWARE_PATH}/zd1211b_uphm \
	${FIRMWARE_PATH}/zd1211b_uphr \
	${FIRMWARE_PATH}/zd1211b_ur \
	${FIRMWARE_PATH}/zd1211_ub \
	${FIRMWARE_PATH}/zd1211_uph \
	${FIRMWARE_PATH}/zd1211_uphm \
	${FIRMWARE_PATH}/zd1211_uphr \
	${FIRMWARE_PATH}/zd1211_ur \
"

INSANE_SKIP_${PN} = "arch"

SRC_URI[md5sum] = "19f28781d76569af8551c9d11294c870"
SRC_URI[sha256sum] = "866308f6f59f7075f075d4959dff2ede47735c751251fecd1496df1ba4d338e1"
