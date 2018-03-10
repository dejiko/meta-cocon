# Almost part of this recipe based PKGBUILD from Arch Linux.
# https://aur.archlinux.org/cgit/aur.git/tree/PKGBUILD?h=xf86-video-sisimedia
# A lot of thanks to Arch maintainers that made buildable recipe!

require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- X.org SiS 671 video driver"
DEPENDS += "xf86miscproto xf86dgaproto drm xf86driproto util-macros"

LIC_FILES_CHKSUM = "file://COPYING;md5=cbbdd887d04deb501076c22917e2030d"

SRC_URI = "https://sources.archlinux.org/other/xf86-video-sisimedia/xf86-video-sisimedia-0.9.1_20091203.tar.bz2 \
           git://aur.archlinux.org/xf86-video-sisimedia.git;protocol=https;name=patches"

SRCREV_patches = "ca7f7401d0f0b4b47a7b010b0e0ff8b40f7332b1"

SRC_URI[md5sum] = "daefc4cff89369c8d8cb19e2c0e10392"
SRC_URI[sha256sum] = "e2084179ba06634311cdac295ce18a61226bbbe04c3567b5b7f59af37e07560d"

# This source directory is correct : not sisimedia, just sis.
S = "${WORKDIR}/xf86-video-sis-${PV}"
PATCHES = "${WORKDIR}/git"

do_patch() {
  cd ${S}
  patch -Np1 -i ${PATCHES}/xf86-video-sis-0.9.1-20102701.patch
  patch -Np1 -i ${PATCHES}/0002-Remove-XFree86-Misc-PassMessage-support.patch
  patch -Np1 -i ${PATCHES}/0003-Fix-build-with-Werror-format-security.patch
  patch -Np1 -i ${PATCHES}/0005-Fix-backlight-off-on-SiS30x.-video-bridges.patch
  patch -Np1 -i ${PATCHES}/0006-Add-IgnoreHotkeyFlag-driver-option.patch
  patch -Np1 -i ${PATCHES}/xf86-video-sis-0.9.1-dump-regs-after-video-init.patch
  patch -Np1 -i ${PATCHES}/0007-Remove-useless-loader-symbol-lists.patch
  patch -Np1 -i ${PATCHES}/0008-update-to-xextproto-7-1-support.patch
  patch -Np1 -i ${PATCHES}/0009-update-for-rac-removal.patch
  patch -Np1 -i ${PATCHES}/0010-change-to-use-abi-version-check.patch
  patch -Np1 -i ${PATCHES}/0011-more-rac-removal.patch
  patch -Np1 -i ${PATCHES}/0001-Remove-xorgconfig-xorgcfg-from-See-Also-list-in-man-.patch
  patch -Np1 -i ${PATCHES}/0004-Make-sisRegs3D4-big-enough-to-hold-all-values-writte.patch
  patch -Np1 -i ${PATCHES}/0005-Correct-bounds-check-of-blitClip-array-access.patch
  patch -Np1 -i ${PATCHES}/xserver19.patch
  patch -Np1 -i ${PATCHES}/xserver112.patch
  patch -Np1 -i ${PATCHES}/pciTag-removal-workaround.patch
  patch -Np1 -i ${PATCHES}/Untangle-XF86DRI.patch
  patch -Np1 -i ${PATCHES}/swap-func-rename.patch
  patch -Np1 -i ${PATCHES}/xf86MapDomainMemory-pci_device_map_legacy.patch
  patch -Np1 -i ${PATCHES}/sync-with-freedesktop.patch
  patch -Np0 -i ${PATCHES}/fix-xv-crash.patch
  patch -Np1 -i ${PATCHES}/sisimedia-no-xaa.patch
  patch -Np1 -i ${PATCHES}/sisimedia-xorg-1.13.patch
  patch -Np1 -i ${PATCHES}/remove_mibstore.h.patch

  patch -Np1 -i ${PATCHES}/deprecated-sym2.patch
  patch -Np1 -i ${PATCHES}/disable-UploadToScreen-DownloadFromScreen.patch

  sed -i -e 's,sis_drv,sisimedia_drv,g' src/Makefile.am
  sed -i -e 's,\"sis\",\"sisimedia\",g' src/sis.h
  sed -i -e 's,sisModuleData,sisimediaModuleData,g' src/sis_driver.c

  sed -i -e 's/AM_CONFIG_HEADER/AC_CONFIG_HEADERS/' configure.ac

  patch -Np1 -i ${PATCHES}/remove-ImplicitPointerConversions.patch
  patch -Np1 -i ${PATCHES}/xserver117.patch

  autoreconf --verbose --install --force --exclude=autopoint ${S}

  cp ${PATCHES}/COPYING ${S}
}

EXTRA_OECONF += " --disable-dri"

