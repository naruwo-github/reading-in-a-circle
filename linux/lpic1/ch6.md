# CH6 101 exam

## 一回目
32/60涙

| 回答 | 結果 | 振り返り |
| --- | --- | --- |
| A,C | × | /proc/hddや/proc/usbなんてものはない |
| A,D | ○ |  |
| C,D | ○ |  |
| D | ○ |  |
| E | × | GRUBは、カーネル選択メニューでAかEのキーを押せば、オプション編集できる |
| shutdown -r 30 | × | +忘れ |
| B,D | × | systemctl start/enable <unit name> |
| D | × | -kは実際にシャットダウンせず、メッセージを表示させるオプション |
| B,D | × | 肥大化しやすいディレクトリはパーティション分けよう。/homeとか/var |
| C | ○ |  |
| grub install /dev/sda | × | grub-install |
| grub save | × | grub-mkconfig |
| lsio /bin/bash | × | ldd <absolute path> |
| C | × | dpkg-reconfigure |
| update | ○ |  |
| search | × | apt-cache depends |
| B | ○ |  |
| D | × | -q(--query), -R(--requires) |
| upgrade | × | yum check-updateで、yum update時にアプデ対象となるパッケージの一覧を表示する |
| C | ○ |  |
| E | ○ |  |
| E | × | 変数に”を含める場合は文字列の終わりと解釈されないように\をつけ、\を表示させたいなら\\ |
| D | ○ |  |
| man mount 1 | × | man 8 mount |
| B,E | ○ |  |
| uniq | ○ |  |
| A | ○ |  |
| mv -rf /home/staff/tmp /home/staff/doc | × | mv `-f` /home/staff/tmp/* /home/staff/doc |
| C,D,E | ○ |  |
| C | ○ |  |
| export | ○ |  |
| E | ○ |  |
| dmesg > dmesg.log | ○ |  |
| ループ実行させるみたいなやつ | × | xargsコマンドは、標準入力から取得したデータを引数として、指定されたコマンドを実行する |
| tee | ○ |  |
| C,D | × | kill,killall,pkillでプロセスにシグナル送信できる。シグナルの種類は-sか「-シグナルID」「-シグナル名」 |
| d | × | & |
| top | ○ |  |
| わからんぞ | × | nohup。ある端末で実行したプロセスは、通常その端末からログアウトしたら終了しちゃう。 |
| nice | × | renice <priority> -p <process id> |
| A,C | × | ps,top |
| D | × | grepで、特定の文字列が入っている/入ってない(-v)行を抽出できる |
| D | ○ |  |
| editor | × | EDITOR |
| 3dd | ○ |  |
| / | ○ |  |
| C,E | × | mke2fsに-jオプションをつけても同じ |
| C,D,E | ○ |  |
| D | ○ |  |
| A,B | ○ |  |
| A | ○ |  |
| C | ○ |  |
| mount -t ext4 /dev/sda9 /var/data | ○ |  |
| chown | ○ |  |
| C,E | × | スティッキービットが設定されたファイルのアクセス権は1000を加えた値。3755=2000(SGIDを指す)+1000+755 |
| D | × | デフォルトパーミッションは、666からunmask値を引いたものになる。644にしたいならunmaskは022 |
| C | ○ |  |
| A,E | ○ |  |
| B | ○ |  |
| where | × | whereisは、コマンド実行ファイルのパス、manページのファイルの場所を表示してくれる |

## 二回目
