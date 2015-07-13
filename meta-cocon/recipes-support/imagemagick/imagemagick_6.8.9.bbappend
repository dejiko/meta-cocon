# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

EXTRA_OECONF += "--without-perl \
		--without-wmf \
		--without-openexr \
		--without-jp2 \
		--without-jbig \
		--without-gvc \
		--without-djvu \
		--without-dps \
		--without-gslib \
		--without-fpx \
		--without-x \
		--disable-assert \
		--disable-cipher \
                --without-fftw \
"
