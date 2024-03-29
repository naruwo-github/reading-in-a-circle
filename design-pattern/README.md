# About Design Pattern

デザインパターンについて知識を深めるリポジトリ

- デザインパターンとは、ソフトウェアの設計時に繰り返して起こる問題に対する解法のこと
  - オブジェクト指向プログラミングにおいて、設計上の問題を効率的に解決するためのベストプラクティスとして提案されているもの
  - コードの再利用性、拡張性、メンテナンス性を向上させることを目的としている
  - 共通言語となり、開発者同士のコミュニケーションを効率化させる

## GoF によるデザインパターンの分類

### 生成に関するパターン

- Abstract Factory
- Factory Method
- Singleton
- Builder
- Prototype

### 構造に関するパターン

- Adapter
- Composite
- Facade
- Proxy
- Bridge
- Decorator
- Flyweight

### 振る舞いに関するパターン

- Chain of Responsibility
- Interpreter
- Mediator
- Observer
- Strategy
- Visitor
- Command
- Iterator
- Memento
- State
- Template Method

## Reference

- 書籍`JAVA言語で学ぶデザインパターン入門第3版`
- その他多くの Web サイト

## About UML

- UML：システムを視覚化したり、仕様や設計を文書化したりするための表現方法
- クラス図：クラスやインスタンス、インタフェースなどの`静的な関係`（時間の経過によって変化しない）を表現したもの
  - サブクラスからスーパークラスへ矢印を伸ばす
  - 斜体：`抽象`
  - 下線：`静的`
- インタフェースと実装
  - 実装クラスからインタフェースへ矢印を伸ばす
  - UML で Java のインタフェースを表現する場合は<<interface>>と書く
- 集約(aggregation)
  - どのような実装であれインスタンスを持っていればその関係は集約
  - 白抜きの菱形で表す
- アクセス制御
  - +：`public`
  - -：`private` クラス外からアクセスできない
  - #：`protected` 同じクラスかサブクラス、および同じパッケージ内のクラスのみアクセス可
  - ~：同じパッケージないからのみアクセスできるメソッドやフィールドを指す
- シーケンス図：プログラムが動く際、どのメソッドがどの順番で実行されるか、どのような事象がどういう順番で起きるかを表現したもの
  - `動的な関係`（時間の経過によって変化する）を表現したもので、上から順に読んでいく
  - ライフライン：インスタンスからした方向に伸びる破線で、インスタンスが存在する期間を示す
  - 黒矢印：メソッドの呼び出し
  - 破線の矢印：メソッドからのリターン
