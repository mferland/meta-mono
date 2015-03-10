require mono-3.12.inc

inherit native

SRC_URI[md5sum] = "ccab015f0c54ffeccd2924b44885809c"
SRC_URI[sha256sum] = "5d8cf153af2948c06bc9fbf5088f6834868e4db8e5f41c7cff76da173732b60d"

DEPENDS =+ "libgdiplus-native"

EXTRA_OECONF += "mono_cv_uscore=no --with-sigaltstack=no --with-mcs-docs=no "

SRC_URI += "file://fix-basic-mscorlib-dep.patch"

do_compile() {
    make EXTERNAL_MCS="${S}/mcs/class/lib/monolite/basic.exe" EXTERNAL_RUNTIME="${S}/foo/bar/mono"
}