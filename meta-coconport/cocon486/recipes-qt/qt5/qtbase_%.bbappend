# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# cocon486 : do not use SSE, AVX for support Geode, Classic Pentium.
QT_CONFIG_FLAGS += " -no-sse2 -no-ssse3 -no-sse4.1 -no-sse4.2 -no-avx -no-avx2 "

