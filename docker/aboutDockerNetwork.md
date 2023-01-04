# Docker Network
Dockerコンテナやサービスは、それらを互いに、またはDocker以外のワークロードと接続することができる。
Dockerコンテナやサービスは、自分がDocker上にデプロイされていることや、そのピアもDockerワークロードであるかどうかを意識する必要すらない。
DockerホストがLinux、Windows、またはその混合で動作していても、Dockerを使用してプラットフォームにとらわれない方法で管理できる。

## Scope of this topic
このトピックではDockerネットワークがどのように動作するかというOS特有の詳細には触れない。
なので、DockerがLinux上でiptablesルールを操作する方法やWindowsサーバ上でルーティングルールを操作する方法についての情報はなく、Dockerがパケットの形成やカプセル化、暗号化を処理する方法の詳細情報もない。
これらについては[Docker and iptables](https://docs.docker.com/network/iptables/)を参照。

## Network drivers
Dockerは下記のネットワークドライバを提供する。
- bridge
    - デフォルトのドライバ。
    - アプリケーションがスタンドアロンコンテナで動作し、通信する必要がある場合に使用。
    - 複数のコンテナが同じDockerホスト上で通信する必要がある場合に最適。
    - see also [bridge networks](https://docs.docker.com/network/bridge/)
![bridge]()
出典：https://qiita.com/TsutomuNakamura/items/ed046ee21caca4a2ffd9

- host
    - スタンドアロンコンテナに対し、ホストOSと同じネットワークを共有する。
    - ネットワークスタックをDockerホストから分離すべきではないが、コンテナの他の側面は分離させたい場合に最適。
    - see also [use the host network](https://docs.docker.com/network/host/)
![host](https://camo.qiitausercontent.com/5f7c9b73c3ae97b7d922a5e249217519a04b2d09/68747470733a2f2f71696974612d696d6167652d73746f72652e73332e616d617a6f6e6177732e636f6d2f302f37303135322f66376431346335642d393032332d663535642d336233362d3233643861316239386466372e706e67)
出典：https://qiita.com/TsutomuNakamura/items/ed046ee21caca4a2ffd9

- overlay
    - 複数のDockerデーモンを接続し、Swarmサービス同士を通信可能にする。
    - オーバーレイネットワークは、異なるDockerホスト上で動作するコンテナが通信する必要がある場合、または複数のアプリケーションがswarmサービスを使用して一緒に動作する場合に最適。
    - Swarmサービスとスタンドアロンコンテナ間、異なるDockerデーモンで動作しているスタンドアロンコンテナ間、これらの通信を可能にする。
    - コンテナ間のOSレベルでのルーティングは不要。
    - see also [overlay networks](https://docs.docker.com/network/overlay/)
![overlay]()
出典：https://qiita.com/TsutomuNakamura/items/ed046ee21caca4a2ffd9

- ipvlan
    - IPv4とIPv6の両方のアドレッシングを完全に制御することができる。
    - VLANドライバは、オペレータにレイヤー2VLANタギングと、アンダーレイネットワークの統合に関心のあるユーザのためのIPvlan L3ルーティングの完全な制御を与える上で、その上に構築されている。
    - see also [IPvlan networks](https://docs.docker.com/network/ipvlan/)
![ipvlan]()
出典：https://qiita.com/TsutomuNakamura/items/ed046ee21caca4a2ffd9

- macvlan
    - MACアドレスをコンテナに割り当てられ、コンテナをネットワーク上の物理デバイスとして表現できる。
    - Macvlanネットワークは、VMセットアップから移行する場合や、コンテナをネットワーク上の物理ホストのように見せ、それぞれ固有のMACアドレスを持たせたい場合に最適。
    - Dockerデーモンは、MACアドレスを頼りにトラフィックをルーティングする。
    - macvlanドライバの使用は、レガシーなアプリケーションを扱うときに最適解になりえる。
        - レガシーなアプリケーション：Dockerホストのネットワークスタックを通してルーティングされるものではない、物理ネットワークに直接接続されるもののこと。
    - see also [Macvlan networks](https://docs.docker.com/network/macvlan/)
![macvlan]()
出典：https://qiita.com/TsutomuNakamura/items/ed046ee21caca4a2ffd9

- none
    - 全てのネットワーキングが無効になる。
    - 通常、カスタムネットワークドライバと組み合わせて使用します。
    - Swarmサービスでは使用できない。
    - see also [disable container networking](https://docs.docker.com/network/none/)
![none](https://camo.qiitausercontent.com/401a7c14610c05e66e2ef2ec9b57e9a641a19421/68747470733a2f2f71696974612d696d6167652d73746f72652e73332e616d617a6f6e6177732e636f6d2f302f37303135322f30373833323631632d633334652d393139322d336464312d3465626237636235646666392e706e67)
出典：https://qiita.com/TsutomuNakamura/items/ed046ee21caca4a2ffd9

- [Network plugins](https://docs.docker.com/engine/extend/plugins_services/)
    - サードパーティのネットワークプラグインを使用すると、Dockerを特殊なネットワークスタックと統合することができる。
    - サードパーティ製のカスタムプラグインがDockerHub上、またはベンダーサイト上で利用できる。

## Networking tutorials
- [Standalone networking tutorial](https://docs.docker.com/network/network-tutorial-standalone/)
- [Host networking tutorial](https://docs.docker.com/network/network-tutorial-host/)
- [Overlay networking tutorial](https://docs.docker.com/network/network-tutorial-overlay/)
- [Macvlan networking tutorial](https://docs.docker.com/network/network-tutorial-macvlan/)

# Reference
- [Overview of Docker Engine's Networking](https://docs.docker.com/network/)
- [About docker network commands](https://docs.docker.com/engine/reference/commandline/network/)
- []()
- []()
