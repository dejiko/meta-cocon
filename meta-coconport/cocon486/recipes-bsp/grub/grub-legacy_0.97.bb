SUMMARY = "GRUB is the GRand Unified Bootloader"
DESCRIPTION = "GRUB is a GPLed bootloader intended to unify bootloading across x86 \
operating systems. In addition to loading the Linux kernel, it implements the Multiboot \
standard, which allows for flexible loading of multiple boot images."
HOMEPAGE = "http://www.gnu.org/software/grub/"
SECTION = "bootloaders"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=c93c0550bd3173f4504b2cbd8991e50b \
                    file://grub/main.c;beginline=3;endline=9;md5=22a5f28d2130fff9f2a17ed54be90ed6"

RDEPENDS_${PN} = "diffutils ncurses-libncurses ncurses-libtinfo"
DEPEND += "ncurses"

SRC_URI = "ftp://alpha.gnu.org/gnu/grub/grub-${PV}.tar.gz; \
	   http://ftp.debian.org/debian/pool/main/g/grub/grub_0.97-70.diff.gz;name=debian-patch \
	   file://autohell.patch \
	   file://grub_fix_for_automake-1.12.patch \
           file://grub-support-256byte-inode.diff \
           file://ext4.patch \
           file://grub-0.97-gpt.patch \
           file://intelmac.patch \
	   file://menu.lst \
            "
SRC_URI_append_libc-musl += "file://grub-legacy-musl.patch"

SRC_URI[debian-patch.md5sum] = "f035bfbdc8548f57237abc9ca30ed007"
SRC_URI[debian-patch.sha256sum] = "8346cf2bf39ce1f0275869a686d61939ec91997cd2ce4b4be95adb28e6fd1dca"

SRC_URI[md5sum] = "cd3f3eb54446be6003156158d51f4884"
SRC_URI[sha256sum] = "4e1d15d12dbd3e9208111d6b806ad5a9857ca8850c47877d36575b904559260b"

S = "${WORKDIR}/grub-${PV}"

inherit autotools

# x86_64-linux
COMPATIBLE_HOST = ".*86.*-linux"


do_install_append_vmware() {
	mkdir -p ${D}/boot/
	ln -sf ../usr/lib/grub/{$TARGET_ARCH}{$TARGET_VENDOR}/ ${D}/boot/grub
}



do_configure_prepend() {
        # Patch same as no-reorder-functions.patch
        sed -i \
                -e s:'-fno-builtin -nostdinc':'-fno-builtin -nostdinc -fno-reorder-functions':g \
                ${S}/stage2/Makefile.am
}

do_configure_append() {
        # ADHOC : Turn off optimize in gcc
	sed -i -e s:'-O2':'-O0':g \
            -i -e s:'-O1':'-O0':g ${B}/Makefile
        sed -i -e s:'-O2':'-O0':g \
            -i -e s:'-O1':'-O0':g ${B}/grub/Makefile
        sed -i -e s:'-O2':'-O0':g \
            -i -e s:'-O1':'-O0':g ${B}/lib/Makefile
        sed -i -e s:'-O2':'-O0':g \
            -i -e s:'-O1':'-O0':g ${B}/stage1/Makefile
        sed -i -e s:'-O2':'-O0':g \
            -i -e s:'-O1':'-O0':g ${B}/stage2/Makefile
        sed -i -e s:'-O2':'-O0':g \
            -i -e s:'-O1':'-O0':g ${B}/util/Makefile
}

do_install_append() {
        install -m 0644 -D ${WORKDIR}/menu.lst ${D}/boot/grub/menu.lst

        # Copy stage1/1_5/2 files to /boot/grub
        GRUB_TARGET_ARCH=$(echo ${TARGET_ARCH} | sed -e 's/.86/386/')

        mkdir -p ${D}/boot/grub
        mkdir -p ${D}/${libdir}/grub/${GRUB_TARGET_ARCH}${TARGET_VENDOR}

        install -m 0644 \
                ${D}/${datadir}/grub/* \
                ${D}/boot/grub/
        install -m 0644 \
                ${D}/${datadir}/grub/* \
                ${D}/${libdir}/grub/${GRUB_TARGET_ARCH}${TARGET_VENDOR}/

}

# TODO : remove dupliate
FILES_${PN} += "/boot/* \
                ${datadir}/grub/* \
                ${libdir}/grub/i386-pc/*"

