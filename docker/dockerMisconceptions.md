# Docker Misconceptions
`訳: Dockerに関するよくある勘違い`

本稿は、下記の参考文献を日本語で適当にまとめたものである。
- Reference: https://hvops.com/articles/docker-misconceptions/
    - Dockerの作者による、Dockerの設計でミスったと思っていることが書かれている記事
    - 2017年に更新された内容であり、技術発達により改善された部分もあるがまだ欠陥と言える部分もあるとのこと

## Narrowly focused advice!
このDockerに関する議論は、ミッションクリティカルなシステム（主にウェブサービス）のマルチホストセットアップを対象としている。

Dockerを使用できる他の多くのシナリオには、必ずしも当てはまらない。ご留意を。

## Background on Docker
Docker辞退の説明はスコープ外だから、下記の記事見てね。
- [What is Docker?](https://www.docker.com/resources/what-container/)
- [Understanding Docker](https://docs.docker.com/get-started/overview/)

## Misconceptions

### Misconception: If I learn Docker then I don't have to learn the other systems stuff!
`訳: 勘違い①：Dockerさえ学べば他の技術の知識は必須ではない！`

現状はまだそうは言えない。より多くのシステム専門知識が必要。
Dockerは高度な最適化/抽象化手法の一つであると捉えるのが良い。
非常に強力なツールだがシステムの複雑さを著しく増大させる。
ミッションクリティカルなシステムの本番環境でDockerを使う場合は、安全に使用する方法をすべて理解しているエキスパートが主導するべき。

Dockerに関する記事の多くは、シンプルなユースケースのみを紹介し、マルチホストのプロダクションシステムでDockerを使用する際の複雑さを無視している。
これはDockerを実運用するために必要な情報を十分に提供できてない。

一般的なマルチホストの本番環境でDockerを安全に堅牢に実行するには、下記を管理する必要がある。
- 安全なプライベートイメージリポジトリ(index)
- ダウンタイムなしのコンテナデプロイのオーケストレーション
- コンテナデプロイのロールバックのオーケストレーション
- 複数のホスト上のコンテナ間のネットワーク接続
- コンテナ・ログの管理
- コンテナデータ（DBなど）の管理
- init、ログなどを適切に処理するイメージの作成
- その他多数

### Misconception: You should have only one process per Docker container!
`訳: 一つのDockerコンテナ内では、一つのプロセスを動かすべき！`

- 管理がエグい大変になる
- 巨大なシステム構成なら功を奏するかもだけど、通常は役割ごと(Ex. Webサーバ、DBサーバ、プロキシサーバ、、、)にコンテナ分けをして、その中で動くプロセス数は特に気にしない

### Misconception: If I use Docker then I don't need a configuration management (CM) tool!
`訳: Dockerを使えば、構成管理(CM)ツールは不要！`

Dockerを搭載したサーバをプロビジョニング、デプロイ、管理するには、オーケストレーションツールが絶対に必要。
- 構成管理ツールとは（参考Qiita記事〜）
- [2022年度最新版構成管理ツール(IaCツール)の比較](https://qiita.com/cocoa-maemae/items/8595246f444b1c08e479)

### Misconception: I should use Docker right now!
`訳: いますぐDocker使うべき！`

Docker移行する前にインフラ面を固めておくべし
- 安全な最小特権アクセス（キーベースのログイン、ファイアウォール、フェイル2バンなど）
- 復元可能な安全なオフサイトデータベースバックアップ
- 自動化されたシステム設定（Ansible、Puppetなどの使用）
- 自動デプロイ
- 自動プロビジョニング
- すべての重要なサービスの監視
- その他（ドキュメント作成など）

### Misconception: I have to use Docker in order to get these speed and consistency advantages!
`訳: スピードや安定性を得るためにDocker使うんや！`

Docker以外の手段でスピードや安定性を得る最適化手法があるし、それをやろう
- CM Tools
- Cloud Images
    - イメージからサーバインスタンス立てたほうが構成管理ツールでインスタンス立てるより早い
    - 1つの方法として、CMツールを使用してサーバーの役割（app、db、cache など）のベースイメージを作成し、そのイメージから新しいサーバーを立ち上げる際に、CMツールで検証・管理するといったことができる
    - サーバの設定を更新するたび、そのイメージサイズは適切かを見直すべき
        - 複数の仕事をするようになったら単一責任になるようにイメージ分割をするべし
            - これにより、イメージの拡張、また、イメージからインスタンス再作成の時のアジリティ向上になる
- Version Pinning
    - バージョン固定してクレメンス
- Version Control Deploys
- Packaged Deploys
    - デプロイするコードのプリコンパイルとパッケージ化を検討
        - これは、コードの*.zipファイルを作成し、その方法でデプロイするのと同じくらい簡単
        - もう一つの選択肢は、dpkgやrpmのような実際のパッケージマネージャを使用して、デプロイを管理すること
    - コンパイルされた資産だけのリポジトリ（コードと同じか別）を作って、それを使うことも手段の一つ
    - より高速にするには、パッケージがサーバーと同じネットワーク上にあることを確認すべし
        - 同じネットワーク上にあることは、時にはわずかなスピードアップにしかならないので、サーバーのネットワーク外のリソースをダウンロードするのがボトルネックになっている場合のみ考慮しよう

## When to use Docker
Docker導入による複雑さとメリットをちゃんと天秤にかけようや。
本番稼働のシステムに関しては、先述した最適化ができてるかどうかをまず確認しようや。

## Conclusion
When to use Dockerに同じ

## P.S.
### A few tips for simplifying Docker use in production
`訳: シンプルに本番環境でDockerを利用するためポイント！`

もしあなたがインフラ有識者ニキで、かつあなたのシステムがDockerのメリットを享受できるくらいスケールしているならば、以下の点を抑えつつDocker使うとさらにシステム最適化になるかも〜
- You don't need to Dockerize everything
- Use role based Docker images
- Be explicit (avoid magic) as long as possible
- Don't store data in containers
- Use a private index provider
- Build on the expertise of others

