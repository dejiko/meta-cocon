FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DEPENDS += "hunspell sqlite3"

EXTRA_OECONF_libc-musl += " --disable-jemalloc --disable-profiling \
                            --disable-profilelocking --disable-cpp-exceptions \
                            --disable-javaxpcom --disable-mochitest \
                            --disable-xprint --disable-skia --disable-debug \
                            --enable-safe-browsing --disable-gio \
                            --enable-system-hunspell --enable-system-sqlite \
                            --enable-system-nspr"

# patches from Void Linux, Gentoo, Sabotage
SRC_URI_append_libc-musl += "file://0002-Use-C99-math-isfinite.patch \
                             file://fix-media.patch \
                             file://fix-fortify-inline.patch \
                             file://fix-netwerk.patch \
                             file://fix-gcc-tests.patch \
                             file://fix-toolkit.patch \
                             file://fix-ipc.patch \
                             file://patch-xpcom_components_Module.h.patch \
                             file://fix-linux-include.patch \
                             file://stat.patch \
                             file://stab.h \
                             file://profiler-uint.patch \
                             file://profiler-gettid.patch \
                             file://basename.patch \
                             file://getprotobyname_r.patch \
                            "

do_configure_prepend() {
  # We don't need a fox logo.
  sed -i -e 's/ac_add_options --enable-official-branding//g' ${WORKDIR}/mozconfig
}

do_configure_prepend_libc-musl() {
  cp ${WORKDIR}/stab.h ${S}/toolkit/crashreporter/google-breakpad/src/
  export ac_cv_sqlite_secure_delete=yes \
         ac_cv_sqlite_threadsafe=yes \
         ac_cv_sqlite_enable_fts3=yes \
         ac_cv_sqlite_dbstat_vtab=yes \
         ac_cv_sqlite_enable_unlock_notify=yes \
         ac_cv_prog_hostcxx_works=1 
}

# v10 is still jethro and gcc-5.x.
PNBLACKLIST[firefox] = ""

