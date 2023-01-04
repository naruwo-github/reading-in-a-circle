# YOUR DOCKER IMAGE MIGHT BE BROKEN
Without you knowing it.
Learn the right way to build your Dockerfile.

## So you're building a Docker image. What might be wrong with it?
Dockerを知ったらDockerfileが作りたくなるだろう。

```dockerfile
FROM ubuntu:16.04

RUN apt-get install all_my_dependencies
ADD my_app_files /my_app

CMD ["/my_app/start.sh"]
```

これで動く。簡単だね。

いや、実はそうではない。

コンテナ内では指定したアプリしか動いてない。適切なUnixシステムは複数の重要なシステムを動かさなくてはならず、それができてない。

### "What do you mean? I'm just using Ubuntu in Docker. Doesn't the OS inside the container take care of everything automatically?"
確かにコンテナ内にUbuntuはインストールされているが、適切に動作しているわけではない。

コンテナ起動時はCMDで指定したコマンドしか実行されないため、コマンドに紐づいたプロセス・サービスしか動かない。

さらに、UbuntuはDockerの内部で実行されるように設計されていない。
そのinitシステムであるUpstartは、実際のハードウェアまたは仮想化されたハードウェア上で実行されることを想定しているが、Dockerコンテナの内部では実行されない。
コンテナは最小限の構成とするべきなので（Upstartを実行したくない）、これは通常問題でない。
しかし、コンテナ内で使用するシステムを最小限に設定することは多くのコーナーケースがあり、Unixシステムモデルに精通していない場合は正しく設定することが困難。
故に、多くの問題を引き起こす可能性がある。

### "What important system services am I missing?"
- A correct init process
    - initプロセス、PID1は、CMDで実行したもの
        - initプロセスが止まるとコンテナも止まる
    - initプロセスには余分な責任がある
        - すべてのorphaned(孤児となった)子プロセスを継承することで、initプロセスがそれらを刈り取ることが期待されている
        - ほとんどの場合、initプロセスはそれを想定しておらず、結果、コンテナは時間とともにゾンビプロセスで溢れる
    - `docker stop`はinitプロセスにSIGTERMを送信し、initプロセスはすべてのサービスを停止することになっている
        - initプロセスがアプリである場合、コンテナ内の他のプロセスではなく、自分自身をシャットダウンすることになる
            - カーネルは、他のプロセスを強制的に終了させ、gracefull shutdownする機会を与えず、潜在的にファイルの破損や古い一時ファイルなどを引き起こす可能性がある
- syslog
    - Unixの標準ロギングサービスで、`/var/log/syslog`へ出力する
    - warningやerrorを取得するために、syslog daemonは稼働が必須
    - 自動起動しないので、意図的に起動させる必要がある
- cron
    - cron daemonは自動起動しないので、意図的に起動させる必要がある
- SSH daemon(sometimes)
    - 時折、何かしらの理由でコンテナ内で作業したい場合が発生する
        - 例えば、適切に稼働していないアプリをデバッグしたい場合
            - `docker exec`が使えるが、多くのデメリットがある
                - 例えば、Docker daemonにアクセスする必要があるので、必然的にDockerホスト上のroot権限を持ってしまうこと
                - 権限管理の一環としてSSHでコンテナにログインしてもらう方法があり、この場合はSSH daemonを意図的に起動させる必要がある
### "Does all this apply too if I'm using CentOS inside the container, or another Linux distribution?"
他のLinuxディストリビューションでも同じ。

### "But I thought Docker is about running a single process in a container?"
システム稼働に必要なプロセスは複数あるので、無理やで。

# Reference
- [YOUR DOCKER IMAGE MIGHT BE BROKEN](https://phusion.github.io/baseimage-docker/)
