本稿は、下記の記事の内容を翻訳し、私の解釈を加えて作成した。
- [YOUR DOCKER IMAGE MIGHT BE BROKEN](https://phusion.github.io/baseimage-docker/)

# たぶんおまえのDockerイメージ壊れてるよ、おまえの知らないところで。

コンテナの正しい起動の仕方を知っといた方がいいよ。

## Dockerを知るとDockerfile書きたくなる

```dockerfile
FROM ubuntu:16.04

RUN apt-get install all_my_dependencies
ADD my_app_files /my_app

CMD ["/my_app/start.sh"]
```

はい完成、簡単だね！

<img src="https://m.media-amazon.com/images/I/91uO6fqahML._AC_SL1500_.jpg" alt="違う、そうじゃない" width="300"/>

出典：Amazon.co.jp

コンテナ内では、CMD命令で指定したスクリプトしか動かない。

Unixシステムを適切に扱うには、他にも様々なシステム（プロセスやサービス）を動かさなくちゃいけない。
（なのにコンテナ内では動いてないよ）

### どゆこと？単にUbuntuを使ってるんだが。OSがよしなにしてくれるんちゃうの？
確かにコンテナ内にUbuntuはインストールされてるけど、`適切に動作しているわけではない`。

コンテナ起動時は、Dockerfile内のCMD命令で指定したコマンドしか実行されないから、コマンドに紐づいたシステム（プロセスやサービス）しか動かない。

加えて、UbuntuはDockerの内部で実行されるように設計・最適化されているわけではない。
- Upstart: Ubuntuのinitシステム
    - 実際のハードウェアまたは仮想化されたハードウェア上で実行されることを想定
    - Dockerコンテナの内部では実行されない

コンテナは最小限の構成とすべきだから、別にUpstartを実行しないこと自体は問題ではない。

だけど、コンテナ内で動かすシステムを最小限にしようとすると、(Unixシステムモデルに精通していない場合は設定が難しく)意図しないシステムの挙動を数多く引き起こす可能性がある。

### どんなサービスの起動が漏れている？？？
下記のシステム（プロセスやサービス）を考慮した方がいい。
- `適切な`initプロセス
    - initプロセス(PID1)は、CMDで実行したもの
    - initプロセスが止まるとコンテナも止まる
    - initプロセスの一般的な、重要な責任
        - すべての孤児となった子プロセスを適切に終了させること
            - ほとんどの場合、Dockerコンテナで実行されるinitプロセスはそれを想定しておらず、結果、コンテナは時間とともにゾンビプロセスで溢れる
    - `docker stop`はinitプロセスにSIGTERMを送信し、initプロセスはすべてのサービスを停止する
        - initプロセスがアプリである場合、コンテナ内の他のプロセスではなく、自分自身をシャットダウンすることになる
            - カーネルは、他のプロセスを強制的に終了させ、gracefull shutdownする機会を与えず、潜在的にファイルの破損や古い一時ファイルなどを引き起こす可能性がある
- `syslog`
    - Unixの標準ロギングサービスで、`/var/log/syslog`へ出力する
    - warningやerrorを取得するために、syslog daemonは稼働が必須
    - 自動起動しないので、意図的に起動させる必要がある
- `cron`
    - cron daemonは自動起動しないので、意図的に起動させる必要がある
- `SSH daemon(sometimes)`
    - 時折、何かしらの理由でコンテナ内で作業したい場合が発生する
        - 例えば、適切に稼働していないアプリをデバッグしたい場合
            - `docker exec`が使えるが、多くのデメリットがある
                - 例えば、Docker daemonにアクセスする必要があるので、必然的にDockerホスト上のroot権限を持ってしまうこと
                - 権限管理の一環としてSSHでコンテナにログインしてもらう方法があり、この場合はSSH daemonを意図的に起動させる必要がある
                - see also [pros and cons of docker exec](https://github.com/phusion/baseimage-docker#login-to-the-container-or-running-a-command-inside-it-via-docker-exec)

### 他のLinuxディストリビューションでも同じ？CentOSに限った話ではない？
他のもおんなじ。

### Dockerは1コンテナに1プロセスって聞いたんだけど！
システム稼働に必要なプロセスは複数あるから、無理やで。

