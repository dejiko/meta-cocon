DEFAULTTUNE ?= "genericx64-64"

include conf/machine/include/x86-base.inc
require conf/machine/include/tune-core2.inc

TUNEVALID[genericx64] = "Generic older x64 cpu tunes"
TUNE_CCARGS .= "${@bb.utils.contains("TUNE_FEATURES", "genericx64", " -march=x86-64 -mtune=generic -mfpmath=sse ", "", d)}"

AVAILTUNES += "genericx64-64"
TUNE_FEATURES_tune-genericx64-64 = "${TUNE_FEATURES_tune-x86-64} genericx64"
BASE_LIB_tune-genericx64-64 = "lib64"
TUNE_PKGARCH_tune-genericx64-64 = "genericx64-64"
PACKAGE_EXTRA_ARCHS_tune-genericx64-64 = "${PACKAGE_EXTRA_ARCHS_tune-x86-64} genericx64-64"

