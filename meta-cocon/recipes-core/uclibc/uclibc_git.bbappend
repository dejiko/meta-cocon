FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

# opencocon local : add some flag.
do_configure_prepend() {
    echo "UCLIBC_HAS_CRYPT_IMPL=y" >> ${WORKDIR}/uClibc.distro
    echo "UCLIBC_HAS_SHA512_CRYPT_IMPL=y" >> ${WORKDIR}/uClibc.distro
    echo "UCLIBC_HAS_UTMP=y" >> ${WORKDIR}/uClibc.distro
}

