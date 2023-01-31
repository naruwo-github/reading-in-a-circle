# Hardware
## システムハードウェア
- cpu
- メモリ
- ハードディスク
- 入力装置
- 拡張カード
- USB機器

## BIOS/UEFI
- basic input output system
    - フラッシュROMに書き込まれているデバイス制御プログラム
- unified extensible firmware interface
    - GUIサポートするなど、BIOSの拡張版
    - まとめてBIOSと呼ばれることも

## デバイス情報の確認
- /devディレクトリ：デバイスファイルがある
- /procディレクトリ(procfs)：デバイス情報がある
- /sysディレクトリ(sysfs)：https://www.wdic.org/w/TECH/sysfs
- PCIデバイス：PCIバスで通信を行うデバイスのこと

## USBデバイス
- universal serial bus
- ホットプラグ
- プラグ＆プレイ：「繋ぐだけですぐに使える」機能や仕組みの総称

## udev
- userspace DEVice managementという仕組み
- デバイスの情報は、D-Bus(Desktop Bus)によってアプリケーションに伝えられる

## デバイスドライバのロード
- デバイスドライバ：デバイス制御プログラム
- `lsmod`: カーネルにロードされているカーネルモジュール（デバイスドライバを含む）を確認する

# Linuxの起動とシャットダウン
## システムが起動するまでの流れ
- BIOS/UEFI→ブートローダ→カーネル→init/systemd
- boot/bootstrap: 電源入れてからシステムが起動するまでの処理の流れ

## 起動時のイベント確認
- `dmesg` or `journalctl -kb`

## システムのシャットダウンと再起動
- シャットダウン：動作中のプログラム群を適切に終了してシステムを安全に停止すること（電源OFF伴うことが多い）

### column
- ACPI(advanced configuration and power interface): コンピュータの電力を管理する規格
    - 電源関連が不調の場合はこいつを疑うべし
    - acpid：ACPIデーモン。電源関連のイベントを処理する。
- systemdを採用したシステムでは、shutdownでなく`systemctl reboot/poweroff`の使用が推奨されている

# SysVinit
システム起動の仕組みのこと。現在主流なのはsystemd。

## SysVinitによる起動
- initが`/etc/inittab`の内容に従ってシステムに必要なサービスを順次起動していく
    - init: 最初に実行されるプロセス
- サービス起動は同期処理→起動完了まで時間がかかることがある

### column
- 最近はSysVinitを使わず、systemdやUpstartが使われる。どちらもサービスの起動が非同期処理なので時間短縮もできてる。
    - `/etc/inittab`ファイルが存在しないか、あっても中身が空である
- Upstart
    - イベント駆動型で、起動させるサービス間の依存関係を管理できる
        - イベント：ランレベルの変更やファイルシステムのマウントといったシステム上の変化を指す
    - 一時的にRHELやUbuntuで使われていたけどsystemdに移行されつつある

## ランレベル
- 動作のモードのこと

## ランレベルの確認と変更
- `runlevel`: show now level
- rootユーザで`init`や`telinit`でレベル変更ができる

## 起動スクリプトによるサービスの管理
- `/etc/init.d`: SysVinitで各種サービスの起動に使われるスクリプト置き場
- ex. httpdサービス起動：`/etc/init.d/httpd start`

## デフォルトのランレベルの設定
- `/etc/inittab`に記載あり

# systemd
## systemdの概要
- 最初のプロセスはsystemd
- 複数のデーモンプロセス(名前はsystemd-xxxx)が連携して各サービスを管理する
- Unit: システム起動処理を構成する処理のひと単位
    - Unitを定義したファイルは、`/lib/systemd/system`以下と`/etc/systemd/system`以下にある
    - ex. httpd.serviceはhttpdサービスの起動に使われるUnitである
- 起動させるサービス間の依存関係を管理できるので、並列実行→システム起動が早い

## systemdの起動手順
- システムが起動すると、まずdefault.targetという(`/etc/systemd/system`下にある)Unitが処理される

## systemctlによるサービスの管理
- ex. `systemctl start postfix.service`
- `/etc/systemd/system/multi-user.target.wants`: 自動起動するサービスのシンボリックリンクがまとまっている
    - 自動起動するサービスの確認：`sudo systemctl list-unit-files -t service --state=enabled`

