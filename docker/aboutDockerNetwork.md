本題の前に…
#### そもそもコンピュータネットワークとは
複数のコンピュータを接続し、情報をやり取りするためのシステムのこと。

ネットワークの種類で、一般的には下記のものがある。

- LAN: 同じ建物やオフィス内にある複数のコンピュータを接続するためのネットワーク
    - LAN内のコンピュータ同士は、ケーブルや無線技術を使用して接続される
- WAN: 複数の LAN を接続することで、より広い地域や国をカバーするネットワークを構成するもの
    - WANは、通常、携帯電話や衛星技術を使用して接続される
- MAN(メタファーエリアネットワーク): 市内や大都市圏をカバーするネットワークを構成するもの
    - MANは、通常、光ファイバや無線通信を使用して接続される
- GAN(グローバルエリアネットワーク): 世界中のどこにあるコンピュータも接続することができるネットワーク
    - GANは、主にインターネットと呼ばれ、世界中のほぼすべてのコンピュータが接続される

# Docker Network
- Dockerのコンテナやサービスは、それらを互いに、またはDocker以外のサービスと接続できる。
- Dockerのコンテナやサービスは、自身がDocker上にデプロイされていることや、接続相手もDockerによるものであるかを意識する必要がない。
- Dockerホスト(Docker Engineを動かしている(仮想)マシン)がLinux、Windows、またはその混合で動作していても、Dockerを使用してプラットフォームにとらわれない方法で管理できる。

## 本稿のスコープ
- Docker Networkがどのように動作するか(OS特有の詳細)には触れない。
- DockerがLinux上でiptablesルールを操作する方法やWindowsサーバ上でルーティングルールを操作する方法には説明しない。
    - Dockerがパケットの形成やカプセル化、暗号化を処理する方法の詳細情報も説明しない。
    - これらについては[Docker and iptables](https://docs.docker.com/network/iptables/)を参照。

## Network drivers
Dockerは下記のネットワークドライバを提供する。
- ネットワークドライバ：OSにPCなどに接続されているネットワーク関連の機器を制御させるための対象機器専用のソフトウェア

### bridge
これはDockerデーモンが起動しているホストマシン上で動作するデフォルトのネットワークで、これを使用すると、複数のコンテナを1つのブリッジに接続できる。
- デフォルトのドライバ。
- アプリケーションがスタンドアロンコンテナで動作し、通信する必要がある場合に使用。
    - スタンドアロン：環境や他のリソースに関わらず単独で機能するシステムやコンピュータ
- 複数のコンテナが同じDockerホスト上で通信する必要がある場合に最適。
- see also [bridge networks](https://docs.docker.com/network/bridge/)

![bridge](https://camo.qiitausercontent.com/59dcc3f5d87b1630b7349aa482b88e7f73d9781d/68747470733a2f2f71696974612d696d6167652d73746f72652e73332e616d617a6f6e6177732e636f6d2f302f37303135322f30323038613164612d323437362d353962362d393765332d6338656333396663633866392e706e67)

出典：https://qiita.com/TsutomuNakamura/items/ed046ee21caca4a2ffd9

### host
DockerコンテナはDockerホストと同じネットワークに接続される。つまり、DockerホストのIPアドレスを使用してコンテナをアクセスできる。
- スタンドアロンコンテナに対し、ホストOSと同じネットワークを共有する。
- ネットワークスタックをDockerホストから分離すべきではないが、コンテナの他の側面は分離させたい場合に最適。
- see also [use the host network](https://docs.docker.com/network/host/)

![host](https://camo.qiitausercontent.com/5f7c9b73c3ae97b7d922a5e249217519a04b2d09/68747470733a2f2f71696974612d696d6167652d73746f72652e73332e616d617a6f6e6177732e636f6d2f302f37303135322f66376431346335642d393032332d663535642d336233362d3233643861316239386466372e706e67)

出典：https://qiita.com/TsutomuNakamura/items/ed046ee21caca4a2ffd9

### overlay
複数のDockerホストを接続して、1つの論理的なネットワークを構成することができる。このネットワークを使用すると、複数のホスト間でコンテナを相互に接続できる。
- 複数のDockerデーモンを接続し、Swarmサービス同士を通信可能にする。
- オーバーレイネットワークは、異なるDockerホスト上で動作するコンテナが通信する必要がある場合、または複数のアプリケーションがswarmサービスを使用して一緒に動作する場合に最適。
- Swarmサービスとスタンドアロンコンテナ間、異なるDockerデーモンで動作しているスタンドアロンコンテナ間、これらの通信を可能にする。
- コンテナ間のOSレベルでのルーティングは不要。
- see also [overlay networks](https://docs.docker.com/network/overlay/)

![overlay](https://camo.qiitausercontent.com/fa0702f4680aab11404ae69ce6fc9bd27d7089b9/68747470733a2f2f71696974612d696d6167652d73746f72652e73332e616d617a6f6e6177732e636f6d2f302f37303135322f65303635353131322d356631662d383238622d383038632d3838383832633935383662322e706e67)

出典：https://qiita.com/TsutomuNakamura/items/ed046ee21caca4a2ffd9

### ipvlan
- IPv4とIPv6の両方のアドレッシングを完全に制御することができる。
- VLANドライバは、オペレータにレイヤー2VLANタギングと、アンダーレイネットワークの統合に関心のあるユーザのためのIPvlan L3ルーティングの完全な制御を与える上で、その上に構築されている。
- see also [IPvlan networks](https://docs.docker.com/network/ipvlan/)

### macvlan
- MACアドレスをコンテナに割り当てられ、コンテナをネットワーク上の物理デバイスとして表現できる。
- Macvlanネットワークは、VMセットアップから移行する場合や、コンテナをネットワーク上の物理ホストのように見せ、それぞれ固有のMACアドレスを持たせたい場合に最適。
- Dockerデーモンは、MACアドレスを頼りにトラフィックをルーティングする。
- macvlanドライバの使用は、レガシーなアプリケーションを扱うときに最適解になりえる。
    - レガシーなアプリケーション：Dockerホストのネットワークスタックを通してルーティングされるものではない、物理ネットワークに直接接続されるもののこと。
- see also [Macvlan networks](https://docs.docker.com/network/macvlan/)

### none
コンテナをローカルホストマシン(Dockerホストのローカル環境)の外部と切り離し、コンテナ内でのネットワークアクセスを制限する。

セキュリティ強化に有効で、コンテナをデバッグする際にもnoneネットワークを使用することで問題を特定しやすくなることがある。

- 制限
    - 他のDockerホストやコンテナと通信できない
    - インターネットにアクセスできない
    - ローカルホストマシンのlocalhostにアクセスできない
- 通常、カスタムネットワークドライバと組み合わせて使用。
- Swarmサービスでは使用できない。
- see also [disable container networking](https://docs.docker.com/network/none/)

![none](https://camo.qiitausercontent.com/401a7c14610c05e66e2ef2ec9b57e9a641a19421/68747470733a2f2f71696974612d696d6167652d73746f72652e73332e616d617a6f6e6177732e636f6d2f302f37303135322f30373833323631632d633334652d393139322d336464312d3465626237636235646666392e706e67)

出典：https://qiita.com/TsutomuNakamura/items/ed046ee21caca4a2ffd9

### [Network plugins](https://docs.docker.com/engine/extend/plugins_services/)
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
