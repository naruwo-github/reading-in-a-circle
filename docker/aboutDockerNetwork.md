本題の前に…
#### そもそもコンピュータネットワークとは
複数のコンピュータを接続し、情報をやり取りするためのシステムのこと。

ネットワークの種類で、一般的には下記のものがある。

- LAN: 同じ建物やオフィス内にある複数のコンピュータを接続するためのネットワーク
    - コンピュータ同士を、ケーブルや無線技術を使用して接続
- WAN: 複数の LAN を接続することで、より広い地域や国をカバーするネットワークを構成するもの
    - 通常、携帯電話や衛星技術を使用して接続
- MAN(メタファーエリアネットワーク): 市内や大都市圏をカバーするネットワークを構成するもの
    - 通常、光ファイバや無線通信を使用して接続
- GAN(グローバルエリアネットワーク): 世界中のどこにあるコンピュータも接続することができるネットワーク
    - 主にインターネットと呼ばれる
    - 世界中のほぼすべてのコンピュータを接続

# Docker Network
- Dockerのコンテナやサービスは、
    - 互いに、またはDocker以外のサービスと接続できる
    - 自身がDocker上にデプロイされていることや、接続相手もDockerによるものであるかを意識する必要がない
- Dockerホスト(Docker Engineを動かしている(仮想)マシン)がLinux、Windows、またはその混合で動作していても、Docker NetworkはDocker側で（プラットフォームにとらわれない方法で）管理できる。

## 本稿のスコープ
- Docker Networkがどのように動作するか(OS特有の詳細)には触れない。
- DockerがLinux上でiptablesの設定を操作する方法や、Windowsサーバ上でルーティングの設定を操作する方法は説明しない。
    - Dockerがパケットの形成やカプセル化、暗号化を処理する方法の詳細情報も説明しない。
        - これらについては[Docker and iptables](https://docs.docker.com/network/iptables/)を参照。

## Network drivers
Dockerは下記のネットワークドライバを提供する。
- ネットワークドライバ：PCなどに接続されているネットワーク関連の機器をOSに制御させるために用いる（対象機器専用の）ソフトウェア

### bridge
Dockerデーモンが起動しているホストマシン上で動作するデフォルトのネットワークで、これを使用すると複数のコンテナを接続させられる。
- アプリケーションがスタンドアロンコンテナで動作していて、他コンテナと通信する必要がある場合に使用する
    - スタンドアロン：環境や他のリソースに関わらず単独で機能するシステムやコンピュータ
- 複数のコンテナが同じDockerホスト上で通信する必要がある場合に最適
- see also: https://docs.docker.com/network/bridge/

![bridge](https://camo.qiitausercontent.com/59dcc3f5d87b1630b7349aa482b88e7f73d9781d/68747470733a2f2f71696974612d696d6167652d73746f72652e73332e616d617a6f6e6177732e636f6d2f302f37303135322f30323038613164612d323437362d353962362d393765332d6338656333396663633866392e706e67)

出典：https://qiita.com/TsutomuNakamura/items/ed046ee21caca4a2ffd9

### host
DockerコンテナはDockerホストと同じネットワークに接続される。つまり、DockerホストのIPアドレスを使用してコンテナをアクセスできる。
- スタンドアロンコンテナに対し、ホストOSと同じネットワークを共有させられる
    - コンテナ間でのポートバッティングはNG
        - つまり、複数コンテナで同一ポートを使いたい場合（httpdコンテナ等）はhostネットワークを採用できない
- 使いどき：ネットワークスタックをDockerホストから分離すべきではないが、コンテナの他の側面は分離させたい場合
- see also: https://docs.docker.com/network/host/

![host](https://camo.qiitausercontent.com/5f7c9b73c3ae97b7d922a5e249217519a04b2d09/68747470733a2f2f71696974612d696d6167652d73746f72652e73332e616d617a6f6e6177732e636f6d2f302f37303135322f66376431346335642d393032332d663535642d336233362d3233643861316239386466372e706e67)

出典：https://qiita.com/TsutomuNakamura/items/ed046ee21caca4a2ffd9

### overlay
複数のDockerホストを接続して1つの論理的なネットワークを構成できる。このネットワークを使用すると複数のDockerホスト間でコンテナを相互に接続できる(Swarmサービスとスタンドアロンコンテナ間、異なるDockerデーモンで動作しているスタンドアロンコンテナ間、これらの通信を可能にする)。
- 複数のDockerデーモンを接続し、Swarmサービス同士を通信可能に
- コンテナ間のOSレベルでのルーティングは不要。
- 使いどき：オーバーレイネットワークは、異なるDockerホスト上で動作するコンテナが通信する必要がある場合、または複数のアプリケーションがswarmサービスを使用して一緒に動作する場合
- see also: https://docs.docker.com/network/overlay/

![overlay](https://camo.qiitausercontent.com/fa0702f4680aab11404ae69ce6fc9bd27d7089b9/68747470733a2f2f71696974612d696d6167652d73746f72652e73332e616d617a6f6e6177732e636f6d2f302f37303135322f65303635353131322d356631662d383238622d383038632d3838383832633935383662322e706e67)

出典：https://qiita.com/TsutomuNakamura/items/ed046ee21caca4a2ffd9

### ipvlan（※理解できてない
- IPv4とIPv6両方に対応
- 複数のコンテナ用に独立した(レイヤ2)ネットワークを提供することで、複数のコンテナが同じネットワーク名前空間を共有でき、別々のレイヤ2ネットワークセグメントを持つことができる。
    - ネットワークのパフォーマンスやセキュリティが向上し、ネットワーク構成においてもより柔軟性が得られる
    - レイヤ2ネットワーク：OSIモデルの2番目のレイヤであるデータリンク層に該当するネットワーク
        - 通信デバイス間でデータの転送を行うために必要な、MACアドレスを使ったアドレス指定やフレームのフォワーディングなどの機能を提供
            - (余談)対して、レイヤ3ネットワークは、OSIモデルの3番目のレイヤであるネットワーク層に該当し、IPアドレスを使ったルーティングなどの機能を提供する
- see also: https://docs.docker.com/network/ipvlan/
- 使用例
    - マルチテナンシー環境で、複数の顧客やテナントが同じホスト上でそれぞれのコンテナを実行し、それらのネットワークを互いに隔離する必要がある場合
        - マルチテナンシー環境：複数のテナント（顧客、組織、グループなど）が同じインフラストラクチャ上で、独自のリソースやアプリケーションを使用することを可能にする環境
            - 各テナントのリソースやアプリケーションが干渉しないよう分離や隔離を行うために、仮想化技術やDockerなどのコンテナ技術が使われる
    - セキュリティやパフォーマンス上の理由でネットワークを複数の独立したセグメントに分割したい場合
    - 複数のアプリケーションをホスティングする場合
        - 同じホスト上で複数のアプリケーションを実行しながら、それらのネットワークをセキュリティやパフォーマンスの理由で互いに隔離したい場合
    - 異なるVLANタグを持つ複数の独立したネットワークを作成したい場合
    - 特定のIP範囲を持つ別のネットワークを作成したい場合
※これらはIPVLANネットワークの使用例の一部であり、特定の実装は環境の要件によって異なる

### macvlan（※理解できてない
各コンテナに独自のMACアドレス(物理デバイスの識別子)を割り当て、ホストのネットワーク上にあたかも個別に存在する物理デバイスのように認識させることができる。

これにより、コンテナに物理ネットワークへ直接レイヤ2接続させることができ、既存の物理インフラやVLANに接続させることができる。

- 使用例
    - コンテナが物理ネットワークとそのリソースに直接アクセスできるようにしたい場合
    - 既存のVLANにコンテナを接続したい場合
    - スイッチ、ルータ、ファイアウォールなどの特定のネットワークデバイスにコンテナを接続したい場合
    - 特定のMACアドレスをコンテナに割り当てたい場合
        - 例えば、不明なデバイスからのトラフィックをブロックするセキュリティポリシーを回避するために使う
    - 特定のIPアドレスをコンテナに割り当てたい場合
        - ネットワークインフラストラクチャ上でコンテナのMACアドレスとIPアドレスのマッピングを作成することで
※適切に設定されていない場合、MACVLANネットワークは他のダイレクトレイヤ2接続と同様にセキュリティ上の問題を持つ可能性があるため、ネットワークインフラストラクチャを理解し、適切なセキュリティ対策を設定することが重要
- see also: https://docs.docker.com/network/macvlan/

### none
Dockerホストのローカル環境の外部からDockerコンテナを切り離し、コンテナ内でのネットワークアクセスを制限する。

セキュリティ強化に有効で、コンテナをデバッグする際にもnoneネットワークを使用することで問題を特定しやすくなることも多々。

- 通常、カスタムネットワークドライバと組み合わせて使用する。
- 制限
    - 他のDockerホストやコンテナと通信できない
    - インターネットにアクセスできない
    - ホストマシンのlocalhostにアクセスできない
    - Swarmサービスでは使用できない
- 使いどき：外部影響を遮断して調査をしたい場合、他にあるかしら、、、、
- see also: https://docs.docker.com/network/none/

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
