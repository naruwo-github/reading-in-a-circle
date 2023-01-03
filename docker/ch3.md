# Docker Community Edition
Dockerを導入する前にホストOSについて理解を深める

## メモリおよびディスクに関する留意点
- メモリ
    - 全コンテナで動作する全てのアプリケーションのメモリ使用量と、それに必要なホストOS側のメモリ使用量を算出しておく
    - コンテナへ制限を与える
- ディスク
    - ホストOSの使用量、コンテナのOSイメージ（10GBが標準）の使用量、アプリケーションが必要とする量を考慮する

## Docker CEのインストール
本番環境においては、Dockerエンジンのインストール後にパラメータ調整が必要になる

インストールざっくり流れ（CentOSの例）
- 必要なぺっケージのインストール
- DockerCEのリポジトリ設定
- DockerCEのインストール
- プロキシサーバの設定(HTTP/HTTPS_PROXY, NO_PROXYを設定
- ストレージドライバの設定(`/etc/docker/daemon.json`内の設定
- systemdに設定の更新を通知し、Dockerエンジンを起動
- `docker info`で起動したDockerの状態を確認
- `docker version`でDockerクライアント/サーバ/APIのバージョン確認
    - OS/Arch(server): linux/amd64となっているが、これはx86-64アーキテクチャであることを示しているだけである。AMD社製かIntel社製かはここではわからない。`cat /proc/cpuinfo`で確認すべし。

## Dockerの各種コンポーネント
- Dockerエンジン：アプリケーションのパッケージ化やコンテナの実行を担う
- Dockerイメージ：OSやアプリケーションを含んだテンプレートのベースイメージ
    - コンテナの状態を保存したい場合は、イメージをcommitする
- Docker Hubレジストリ：公開されているDockerイメージをSaaS経由で提供する
- Dockerプライベートレジストリ：ローカルで作成・保管したイメージの保管庫
- Dockerコンテナ：分離された名前空間とアプリケーションの実行環境
    - runコマンドに-h(--host)オプションを指定することで、コンテナ内のホスト名を設定できる
        - `/etc/sysconfig/network`にホスト名を指定してもコンテナ起動時にはロードされないため、コンテナ起動時のオプションで指定する必要がある
- Dockerクライアント：ユーザがコマンドを発行し、Dockerデーモンと通信を行う

## Column コンテナIDをシェル変数に入れると便利かも
- docker container runの結果をコマンドラインのシェル変数に代入する
    - ex. `ID003=$(docker run -d --name test003 -it ubuntu:xxx /bin/bash)`
- 他コマンドで使いまわせる
- ex. `docker container commit $ID003 ubuntu:003`

## systemdに対応したコンテナの利用

## a

## a

## a

