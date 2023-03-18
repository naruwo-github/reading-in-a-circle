# Visitor Pattern

- `visitor`：`訪問者`
- `データ構造`と`処理`を分離する
- `データ構造`の中を巡り歩く主体である`訪問者`を表すクラスを用意し、そのクラスに`処理`を任せる
  - 新しい`処理`を追加したいときは新しい`訪問者`を作れば良い
  - `データ構造`の方は戸を叩いてくる`訪問者`を受け入れてあげれば良い

## Role

| Role            | Description                                                                   |
| --------------- | ----------------------------------------------------------------------------- |
| Visitor         | ConcreteElement ごとに visit メソッドを定義する抽象クラス                     |
| ConcreteVisitor | visit メソッドを実装する具体クラス                                            |
| Element         | Visit の訪問先で、受入用の accept メソッドを定義する抽象クラス                |
| ConcreteElement | Element のインタフェースを実装する具体クラス                                  |
| ObjectStructure | Element の集合を扱う。個々の Element を扱えるよう Iterator を実装することも。 |

## Sample Code

### Java

| Class name  | Description                                                                |
| ----------- | -------------------------------------------------------------------------- |
| Visitor     | 訪問者を表す`抽象`クラス                                                   |
| Element     | Visitor クラスのインスタンスを受け入れるデータ構造を表すインタフェース     |
| ListVisitor | Visitor クラスのサブクラスで、ファイルやディレクトリの一覧を表示するクラス |
| Entry       | File, Directory のスーパークラスとなる`抽象`クラス                         |
| File        | ...                                                                        |
| Directory   | ...                                                                        |
| Main        | ...                                                                        |

- ファイルとディレクトリで構成されたデータ構造の中を訪問者が渡り歩き、ファイルの一覧を表示するプログラムを作成する
  - [Composite Pattern](../11-composite-pattern/)と同じテーマ

### xxx

-

## Usage/Tips/Pros and Cons

- ConcreteVisitor の追加は容易
- ConcreteElement の追加は困難

### ダブルディスパッチ

ちょうど反対の関係になっている

```java
element.accept(visitor)

visitor.visit(element)
```

Visitor Pattern では ConcreteElement と ConcreteVisitor の組によって実際の処理が決まる。
これを一般に double dispatch（二重の振り分け）と呼ぶ。

### なぜこんな複雑なことをする？

繰り返し処理ならループで対処すればいいではないか

Visitor Pattern の目的は、**処理をデータ構造か分離する**こと。
ConcreteElement の**部品としての独立性**を高めている。

### OCP

※詳細省く

既存のクラスを修正せずに拡張できるようにせよ！

クラスに対する要求は頻繁に変化する
→ 大抵の場合は機能拡張
→ すでにテストまで済んでいるクラスに修正を加えるのは嫌
→ デザインパターンの導入で、恩恵を受けれる

## Related Patterns

- [Iterator Pattern](../01-iterator-pattern/)
  - Iterator->データ構造が保持する要素を一つ一つ得るのに使う
  - Visitor->データ構造が保持している要素に特定の処理を施すのに使う
- [Composite Pattern](../11-composite-pattern/)
  - 訪問先となるデータ構造が Composite パターンになる場合がある
- [Interpreter Pattern](../23-interpreter-pattern/)
  - 内部で Visitor Pattern が使われる場合がある
    - ex. 構文木を作った後、構文木の各ノードを巡回しながら処理を行うような場合
