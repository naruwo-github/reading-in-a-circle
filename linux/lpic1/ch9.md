# CH9 管理タスク

## 9.1 ユーザーとグループの管理
Linuxはマルチユーザシステムで、ユーザ情報はテキストファイルに保存されている

### ユーザーアカウントと/etc/passwd
- ユーザアカウント情報は`/etc/passwd`ファイルへ
    - 書式-> ユーザ名:パスワード:UID:GID(primary group):GECOS:ホームディレクトリ:デフォルトシェル
- 一般ユーザでも参照できてしまうので、パスワード部分はシャドウパスワードにする
- シャドウパスワード：`/etc/shadow`スーパーユーザしか読み出しできない

### グループアカウントと/etc/group
- 書式-> グループ名:グループパスワード:GID:グループメンバー
- 複数のユーザが属している場合は、カンマ区切りで並べる

### コマンドを用いたユーザーとグループの管理
管理用コマンドやファイル
- `useradd`(Ubuntu, Debian/GNU Linuxではadduser使ったほうがいい)
- ホームディレクトリのデフォルトファイル
    - `/etc/skel`に置いたファイルは、ユーザ追加時にそのユーザのホームディレクトリ下へコピーされる
- `usermod`：ユーザアカウント情報編集
- `userdel`：ユーザカウント削除
- `passwd`：パスワード変更。スーパーユーザ以外は自身のパスワードのみ変更できる。
- `groupadd`：グループ作成
- `groupmod`：既存グループ情報の変更
- `groupdel`：グループ削除。削除対象をプライマリグループとするユーザがいる場合、削除できない。
- `id`：ユーザが所属しているグループを調べる。

### シャドウパスワード
ch12でふれる

## 9.2 ジョブスケジューリング
システム管理コストを下げるため、自動実行が必要

### cron
- ジョブの定期実行を実現
- crond：スケジュール管理用のデーモン
    - 1分ごとにcrontabを調べ、実行すべきスケジュールがあればそれを実行する
- crontab：スケジューリングを編集するコマンド
    - ユーザごとのファイルは`/var/spool/cron/<user name>`以下に置かれる
    - ファイルを直接編集するのではなく、コマンドで編集するべし
    - 書式：分　時　日　月　曜日　コマンド
- システム用crontab（/etc/crontab）
    - 一般的に、`/etc/cron.*`ディレクトリに置かれたファイルを呼び出すようになっている

### atコマンド
- 1回限りの実行の設定、確認
    - 確認は`atq`コマンドも同じ
    - 削除は`atrm`コマンドも同じ
- 書式：`at [-f <file name>] <date>`

### cronとatのアクセス制御
ユーザ単位で利用制限できる。

- `*.allow`：ホワイトリスト
- `*.deny`：ブラックリスト

- cron
    - `/etc/cron.allow`, `/etc/cron.deny`の2ファイルを使う
    - 前者があれば前者の内容を評価し、なければ後者の内容を評価する
- at
    - `/etc/at.allow`, `/etc/at.deny`の2ファイルを使う
    - ファイルの評価順はcronに同じ
    - `*`どちらもない場合は、スーパユーザだけが利用できる
    - デフォルトでは空のat.denyがあり、全てのユーザが使えるようになっている

### systemdによるスケジューリング
systemdのタイマーUnitを使うと、スケジューリングできる。

タイマーUnitの機能
- モノトニックタイマー
    - 何らかのイベントから一定時間経過した後に起動し、その後定期実施されるやつ
- リアルタイマー
    - cronと同じ定期実施されるやつ

リアルタイマーはcronと同じ機能だけど、cronより設定が煩雑→`systemd-run`コマンドを使ってより簡単にスケジューリングできる。
- `systemctl list-timers`：スケジュール一覧確認
- `journalctl -u <Unit name>`：コマンドの実行結果の確認
- `systemctl stop <xxx.timer>`：スケジュール削除の例

## 9.3 ローカライゼーションと国際化
- ローカライゼーション：言語や通貨単位、日付の書式などを地域や国に合わせること
- 国際化：多言語、他地域対応でソフトウェアを最初から開発すること

### ロケール
利用者の地域情報のこと。
- ロケールは様々なカテゴリに別れている（形式：`LC_XXX`）
    - 全てのカテゴリに同じ値を設定するには、環境変数LANGまたはLC_ALLに設定する
    - 環境変数LANG：カテゴリごとの設定を上書きしない
    - LC＿ALL：カテゴリごとの設定を上書きする
- `locate`：現在のロケール設定を確認できる
    - ロケールを一時的に変更したい場合、変数名＝ロケール名を実行するコマンドの前に置く
    - Ex. lsのmanを英語で表示：`LANG=C man ls`

### 文字コード
UTF-8が支配的だが、一部そうではないLinuxディストロがある。

また、日本ではいくつかの文字コードが混在しているので、文字化けが起こることがある。

- `iconv [option] [input file name]`：文字コードの変換
    - ex. 日本語EUCで作られたファイルをUTF-8に変換する
        - `iconv -f eucjp -t utf8 report.euc.txt > report.utf8.txt`
    - コマンド内で指定可能な文字コードは、-lオプションで調べれる
- nkf -g <file name>：文字コードを調べられる

### タイムゾーン
- 地域ごとに区分された標準時間帯のこと
- /usr/share/zoneinfo/以下のバイナリファイルに保存されている
- システムで利用するタイムゾーンの設定方法
    - 上記のファイルを`/etc/localtime`にコピーする(or symbolic link)
    - `環境変数TZ`で設定する：`export TZ="Asia/Tokyo"`
    - 全ユーザへ設定するには、`/etc/timezone`ファイルに記述する
    - `tzselect`コマンドに従う

ex on mac
```
❯❯ ls -la /usr/share/zoneinfo
.rw-r--r--    6 root  2 Dec  2022 +VERSION
drwxr-xr-x    - root  7 Dec  2022 Africa
drwxr-xr-x    - root  7 Dec  2022 America
drwxr-xr-x    - root  7 Dec  2022 Antarctica
drwxr-xr-x    - root  7 Dec  2022 Arctic
drwxr-xr-x    - root  7 Dec  2022 Asia
drwxr-xr-x    - root  7 Dec  2022 Atlantic
drwxr-xr-x    - root  7 Dec  2022 Australia
drwxr-xr-x    - root  7 Dec  2022 Brazil
drwxr-xr-x    - root  7 Dec  2022 Canada
.rw-r--r-- 2.1k root  2 Dec  2022 CET
drwxr-xr-x    - root  7 Dec  2022 Chile
.rw-r--r-- 2.3k root  2 Dec  2022 CST6CDT
.rw-r--r-- 2.4k root  2 Dec  2022 Cuba
.rw-r--r-- 1.9k root  2 Dec  2022 EET
.rw-r--r-- 1.9k root  2 Dec  2022 Egypt
.rw-r--r-- 3.5k root  2 Dec  2022 Eire
.rw-r--r--  118 root  2 Dec  2022 EST
.rw-r--r-- 2.3k root  2 Dec  2022 EST5EDT
drwxr-xr-x    - root  7 Dec  2022 Etc
drwxr-xr-x    - root  7 Dec  2022 Europe
.rw-r--r--  120 root  2 Dec  2022 Factory
.rw-r--r-- 3.7k root  2 Dec  2022 GB
.rw-r--r-- 3.7k root  2 Dec  2022 GB-Eire
.rw-r--r--  118 root  2 Dec  2022 GMT
.rw-r--r--  118 root  2 Dec  2022 GMT+0
.rw-r--r--  118 root  2 Dec  2022 GMT-0
.rw-r--r--  118 root  2 Dec  2022 GMT0
.rw-r--r--  118 root  2 Dec  2022 Greenwich
.rw-r--r-- 1.2k root  2 Dec  2022 Hongkong
.rw-r--r--  119 root  2 Dec  2022 HST
.rw-r--r--  156 root  2 Dec  2022 Iceland
drwxr-xr-x    - root  7 Dec  2022 Indian
.rw-r--r-- 1.3k root  2 Dec  2022 Iran
.rw-r--r-- 4.5k root  2 Dec  2022 iso3166.tab
.rw-r--r-- 9.1k root  2 Dec  2022 Israel
.rw-r--r--  481 root  2 Dec  2022 Jamaica
.rw-r--r--  292 root  2 Dec  2022 Japan
.rw-r--r--  309 root  2 Dec  2022 Kwajalein
.rw-r--r-- 3.4k root  2 Dec  2022 leapseconds
.rw-r--r--  641 root  2 Dec  2022 Libya
.rw-r--r-- 2.1k root  2 Dec  2022 MET
drwxr-xr-x    - root  7 Dec  2022 Mexico
.rw-r--r--  118 root  2 Dec  2022 MST
.rw-r--r-- 2.3k root  2 Dec  2022 MST7MDT
.rw-r--r-- 2.4k root  2 Dec  2022 Navajo
.rw-r--r-- 2.4k root  2 Dec  2022 NZ
.rw-r--r-- 2.0k root  2 Dec  2022 NZ-CHAT
drwxr-xr-x    - root  7 Dec  2022 Pacific
.rw-r--r-- 2.7k root  2 Dec  2022 Poland
.rw-r--r-- 3.5k root  2 Dec  2022 Portugal
.rw-r--r-- 3.5k root  2 Dec  2022 posixrules
.rw-r--r--  556 root  2 Dec  2022 PRC
.rw-r--r-- 2.3k root  2 Dec  2022 PST8PDT
.rw-r--r--  764 root  2 Dec  2022 ROC
.rw-r--r--  645 root  2 Dec  2022 ROK
.rw-r--r--  384 root  2 Dec  2022 Singapore
.rw-r--r-- 1.9k root  2 Dec  2022 Turkey
.rw-r--r--  118 root  2 Dec  2022 UCT
.rw-r--r--  118 root  2 Dec  2022 Universal
drwxr-xr-x    - root  7 Dec  2022 US
.rw-r--r--  118 root  2 Dec  2022 UTC
.rw-r--r-- 1.5k root  2 Dec  2022 W-SU
.rw-r--r-- 1.9k root  2 Dec  2022 WET
.rw-r--r--  19k root  2 Dec  2022 zone.tab
.rw-r--r--  118 root  2 Dec  2022 Zulu
```

