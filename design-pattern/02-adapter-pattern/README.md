# Adapter Pattern

- 既に提供されているものと必要なもののギャップを埋めるデザインパターンのこと
  - Wrapper Pattern と呼ばれることもある
- アダプター：既に提供されているものと必要なものとの間に入り、その間を埋めるもの
  - ex. コンセントを通して提供されている交流 100 ボルトを、今目の前の PC で必要な直流 12 ボルトに変換する AC アダプター

## Role

- Target
  - 必要なメソッドを定めるもの
  - ex. PC を動かす直流 12 ボルト
- Client
  - Target のメソッドを使って仕事をするもの
  - ex. 直流 12 ボルトで動く PC
- Adaptee
  - 既に提供されているもの → 適合される側
  - ex. 交流 100 ボルトの電源
- Adapter
  - Adaptee のメソッドを使って Target を満たすもの
  - ex. 交流 100 ボルトを直流 12 ボルトに変換する AC アダプター

## Sample Code

- 内容
  - Banner クラスが提供されている
  - Print インタフェース or クラスが必要なもの
  - PrintBanner クラスをアダプターとする
- 2 種類の実装方法がある
  - クラス（継承）を使うもの
  - インスタンス（委譲）を使うもの

|                    | 電源の比喩      | program                        |
| ------------------ | --------------- | ------------------------------ |
| 提供されているもの | 交流 100 ボルト | Banner クラス                  |
| 変換装置           | アダプター      | PrintBanner クラス             |
| 必要なもの         | 直流 12 ボルト  | Print インタフェース or クラス |

### 継承を使うパターン

- 構成
  - Target: Print.java
  - Client: Main.java
  - Adaptee: Banner.java
    - interface
  - Adapter: PrintBanner.java -> Adapter

### 委譲を使うパターン

- 委譲は、誰かにお任せするということ

  - → あるメソッドの実際の処理を他のインスタンスのメソッドに任せてしまうこと

- 構成
  - Target: Print.java
  - Client: Main.java(継承を使うパターンに同じ)
  - Adaptee: Banner.java(継承を使うパターンに同じ)
    - class
  - Adapter: PrintBanner.java -> Adapter

## Usage/Pros and Cons

- すでに存在する便利で十分にテストされたクラスを活用できるのがメリットの一つ
  - バグがあるなら Adapter 側に問題がある、容易にと問題切り分けができることも
- バージョンアップ時の問題「古い版との互換性」
  - 古い版と新しい版を共存させて、尚且つメンテナンスを楽に行うために Adapter パターンが役立つことがある
    - 古い版を Target とし、新しい版のクラスを使って古い版のメソッドを実装する Adapter クラスを作る
- 親クラスの内部的な振る舞いを理解しないと継承を使いこなせない → 委譲を使って実装する方が認知負荷が低い

## Related Pattern

- Bridge Pattern
  - Adapter Pattern はインタフェースが異なるクラス同士を結びつけるパターンで、Bridge Pattern は機能の階層と実装を結びつけるパターン
- Decorator Pattern
  - Adapter Pattern はインタフェースの連れを埋めるパターンで、Decorator Pattern はインタフェースを変えずに機能を追加するパターン
