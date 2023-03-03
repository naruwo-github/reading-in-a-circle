# Adapter Pattern

- 既に提供されているものと必要なもののギャップを埋めるデザインパターンのこと
- Wrapper Pattern と呼ばれることもある
- アダプター：提供されているものと必要なものとの間に入り、その間を埋めるもの
  - ex. 交流 100 ボルトを直流 12 ボルトに変換する PC 用 AC アダプター

## 登場する役

- Target
  - 必要なメソッドを定めるもの
  - ノートパソコンを動かすための直流 12 ボルト
- Client
  - Target のメソッドを使って仕事をするもの
  - 直流 12 ボルトで動くノートパソコン
- Adaptee
  - すでに提供されているもの → 適合される側
  - 交流 100 ボルトの AC 電源
- Adapter
  - Adaptee のメソッドを使って Target を満たすもの
  - 交流 100 ボルトを直流 12 ボルトに変換するアダプター

## 今回実装するサンプルコード

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
