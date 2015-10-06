# opencocon build 方法

opencocon v9系統のビルド手順
※ メジャーリリースが異なると、ビルド方法が異なることがある。

### 事前の準備

- 動作環境

OpenEmbedded が正常に動作する Linux ディストリビューション
100GB 以上のストレージ
6GB 以上のメモリ


- OpenEmbeddedに必要な環境を準備

以下のページを参照のうえ、必要なパッケージをインストールする

http://www.openembedded.org/wiki/Getting_started

Deban/Ubuntu では、 /bin/sh を dash から bash に変更する必要がある。

http://www.crashcourse.ca/wiki/index.php/Yocto_Project_Quick_Start#Setting_up_your_development_host

### 構築

- cocon-setup-scriptsのダウンロード

	$ git clone -b opencocon-v9 https://github.com/dejiko/cocon-setup-scripts.git

- cocon-cdcreator, coconfrm-downloader のダウンロード

(cocon486のみ)

	$ git clone -b opencocon-v9 https://github.com/dejiko/cocon-cdcreator
	$ cd cocon-cdcreator/coconcd/
	$ git clone -b opencocon-v9 https://github.com/dejiko/coconfrm-downloader
	$ cd ../../

- local.conf の編集

	$ cd cocon-setup-scripts

ここで、 conf/local.conf を開き、最後の方にある以下の部分のコメントを外す。

	# ---- opencocon local ----
	# Uncomment these parameters
	# Machine
	MACHINE="cocon486"
	
	# Use uclibc or eglibc
	OPENCOCON_LIBC = "uclibc"
	
	# Kernel Version
	LINUX_LIBC_HEADERS_VERSION = "3.10.42"


(パラメータ解説)

MACHINE
ターゲットマシン。v9時点では、 cocon486 と raspberrypi がサポートされている。

OPENCOCON_LIBC
使用するlibc。現在は uclibc のみサポートされている。

LINUX_LIBC_HEADERS_VERSION
使用するLinuxカーネル。これはメジャーリリース・マイナーリリースによって値が度々変わるため、meta-cocon リポジトリの以下の場所を確認の上、指定する。

-- cocon486
https://github.com/dejiko/meta-cocon/tree/master/meta-coconport/cocon486/recipes-kernel/linux

-- raspberrypi
https://github.com/dejiko/meta-cocon/tree/master/meta-coconport/raspberrypi/recipes-kernel/linux


- oebb.sh の実行

この段階で、meta-cocon 等のツリーのダウンロードが行われる。

	$ ./oebb.sh config cocon486

- 環境変数の設定

これは、新しいshellを開いてビルドする毎に行う

	$ .  ./opencocon


- 5  ビルド

(cocon486の場合)

	$ bitbake opencocon-image initramfs-crusoe-image

(raspberrypiの場合)

	$ bitbake coconrpi-image

- 6  CDイメージの作成

(cocon486のみ)

cocon-cdcreator を実行する。3番目のパラメータは、isoイメージのバージョン記号などを指定できる。


	$ cd ..
	$  ./cocon-cdcreator  ../cocon-setup-scripts/deploy/uclibc/images/cocon486/  ./coconcd/  v9h-test2


- 確認されているバグ

webkit-gtk のビルド途中、libANGLEのビルド中にmakeプロセスでCPUが100%になったまま続行できなくなることがある。その場合はいったん Ctrl+C を数回押してビルドを中断し、再度ビルドを試行する。

具体的には以下の過程で固まる模様。

	i486-pc-linux-uclibc-libtool: link: i486-pc-linux-uclibc-ar cruT .libs/libANGLE.a Source/ThirdParty/ANGLE/src/compiler/.libs/libANGLE_la-BuiltInFunctionEmulator.o Source/ThirdParty/ANGLE/src/compiler/.libs/libANGLE_la-CodeGen.o Source/ThirdParty/ANGLE/src/compiler/.libs/libANGLE_la-Compiler.o Source/ThirdParty/ANGLE/src/compiler/.libs/libANGLE_la-debug.o Source/ThirdParty/ANGLE/src/compiler/depgraph/.libs/libANGLE_la-DependencyGraphBuilder.o Source/ThirdParty/ANGLE/src/compiler/depgraph/.libs/libANGLE_la-DependencyGraph.o Source/ThirdParty/ANGLE/src/compiler/depgraph/.libs/libANGLE_la-DependencyGraphOutput.o Source/ThirdParty/ANGLE/src/compiler/depgraph/.libs/libANGLE_la-DependencyGraphTraverse.o Source/ThirdParty/ANGLE/src/compiler/.libs/libANGLE_la-DetectCallDepth.o Source/ThirdParty/ANGLE/src/compiler/.libs/libANGLE_la-Diagnostics.o Source/ThirdParty/ANGLE/src/compiler/.libs/libANGLE_la-DirectiveHandler.o Source/ThirdParty/ANGLE/src/compiler/.libs/libANGLE_la-DetectDiscontinuity.o Source/ThirdParty/ANGLE/src/compiler/.libs/libANGLE_la-ForLoopUnroll.o Source/ThirdParty/ANGLE/src/compiler/.libs/libANGLE_la-InfoSink.o Source/ThirdParty/ANGLE/src/compiler/.libs/libANGLE_la-Initialize.o Source/ThirdParty/ANGLE/src/compiler/.libs/libANGLE_la-InitializeDll.o Source/ThirdParty/ANGLE/src/compiler/.libs/libANGLE_la-InitializeGLPosition.o Source/ThirdParty/ANGLE/src/compiler/.libs/libANGLE_la-InitializeParseContext.o Source/ThirdParty/ANGLE/src/compiler/.libs/libANGLE_la-Intermediate.o Source/ThirdParty/ANGLE/src/compiler/.libs/libANGLE_la-intermOut.o Source/ThirdParty/ANGLE/src/compiler/.libs/libANGLE_la-IntermTraverse.o Source/ThirdParty/ANGLE/src/compiler/.libs/libANGLE_la-MapLongVariableNames.o Source/ThirdParty/ANGLE/src/compiler/.libs/libANGLE_la-ossource_posix.o Source/ThirdParty/ANGLE/src/compiler/.libs/libANGLE_la-OutputESSL.o Source/ThirdParty/ANGLE/src/compiler/.libs/libANGLE_la-OutputGLSLBase.o Source/ThirdParty/ANGLE/src/compiler/.libs/libANGLE_la-OutputGLSL.o Source/ThirdParty/ANGLE/src/compiler/.libs/libANGLE_la-OutputHLSL.o 