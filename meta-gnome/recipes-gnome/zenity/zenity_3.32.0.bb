SUMMARY = "Display dialog boxes from the command line and shell scripts"
SECTION = "x11/gnome"
LICENSE = "GPLv2+"

LIC_FILES_CHKSUM = "file://COPYING;md5=3bf50002aefd002f49e7bb854063f7e7"

inherit distro_features_check gnomebase gettext

DEPENDS = "gtk+3"

REQUIRED_DISTRO_FEATURES = "x11"

SRC_URI = "${GNOME_MIRROR}/${GNOMEBN}/${@gnome_verdir("${PV}")}/${GNOMEBN}-${PV}.tar.${GNOME_COMPRESS_TYPE};name=archive \
    file://0001-build-don-t-generate-manual.patch \
"

SRC_URI[archive.md5sum] = "ba2b2a13248773b4ec0fd323d95e6d5a"
SRC_URI[archive.sha256sum] = "e786e733569c97372c3ef1776e71be7e7599ebe87e11e8ad67dcc2e63a82cd95"
GNOME_COMPRESS_TYPE="xz"

do_install_append() {
    # Remove gdialog compatibility helper - we don't want to pull in perl
    rm ${D}${bindir}/gdialog
}
