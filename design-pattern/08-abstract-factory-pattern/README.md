# Abstract Factory Pattern

- `抽象`的な部品を組み合わせて`抽象`的な製品を作る`抽象`的な工場
- 部品の`具体`的な実装には**注目せず**、インタフェース(`抽象`)に注目することで、そのインタフェースだけを使って部品を組み立てて製品を作り上げる

## Role

| Role              | Description                                                                      |
| ----------------- | -------------------------------------------------------------------------------- |
| `AbstractProduct` | `AbstractFactory` によって作られる`抽象`的な部品や製品のインタフェースを定義する |
| `AbstractFactory` | `AbstractProduct` のインスタンスを作るためのインタフェースを定義する             |
| `Client`          | `AbstractFactory` と `AbstractProduct` のインタフェース`のみ`を使って仕事を行う  |
|                   | 具体的な部品や製品や工場については知らない                                       |
|                   | --- 以降は具体 ↓↓↓ ---                                                           |
| `ConcreteProduct` | `AbstractProduct` のインタフェースを実する                                       |
| `ConcreteFactory` | `AbstractFactory` のインタフェースを実装する                                     |

## Sample Code(Java)

- プログラムの目的：階層構造を持ったリンク集を HTML ファイルとして作る
- 4 つのパッケージで構成される
  - factory：抽象的な工場・部品・製品
  - 無名パッケージ：Main
  - listFactory：具体的な工場・部品・製品
  - divFactory：同上

| Package name | Class name  | Description                                                          |
| ------------ | ----------- | -------------------------------------------------------------------- |
| factory      | Factory     | (`AbstractFactory`)Link, Tray, Page を作る`抽象`クラス               |
| factory      | Item        | (`AbstractProduct`)Lint, Tray を統一的に扱うためのクラス             |
| factory      | Link        | (`AbstractProduct`)`抽象`的な部品：HTML のリンクを表すクラス         |
| factory      | Tray        | (`AbstractProduct`)`抽象`的な部品：Link, Tray を集めたクラス         |
| factory      | Page        | (`AbstractProduct`)`抽象`的な部品：HTML のページを表すクラス         |
|              |             |                                                                      |
| no title     | Main        | (`Client`)                                                           |
|              |             | --- 以降は具体 ↓↓↓ ---                                               |
| listFactory  | ListFactory | (`ConcreteFactory`)ListLink, ListTray, ListPage を作る`具体`クラス   |
| listFactory  | ListLink    | (`ConcreteProduct`)`具体`的な部品：HTML のリンクを表すクラス         |
| listFactory  | ListTray    | (`ConcreteProduct`)`具体`的な部品：ListLink, ListTray を集めたクラス |
| listFactory  | ListPage    | (`ConcreteProduct`)`具体`的な部品：HTML のページを表すクラス         |
|              |             |                                                                      |
| divFactory   | DivFactory  | (`ConcreteFactory`)DivLink, DivTray, DivPage を作る`具体`クラス      |
| divFactory   | DivLink     | (`ConcreteProduct`)`具体`的な部品：HTML のリンクを表すクラス         |
| divFactory   | DivTray     | (`ConcreteProduct`)`具体`的な部品：DivLink, DivTray を集めたクラス   |
| divFactory   | DivPage     | (`ConcreteProduct`)`具体`的な部品：HTML のページを表すクラス         |

## Usage/Tips/Pros and Cons

- Pros

  - 具体的な工場を新規追加するのが簡単
    - どのようなクラスを作り、どのようなメソッドを実装すればいいかがはっきりしている
    - 具体的な工場をいくら追加しても抽象的な工場や Main 処理に変更を加えなくて良い

- Cons

  - 部品を新たに追加するのは困難
    - すでに存在する`具体`的な工場全てに修正を加える必要になる->既存の工場が多いほど、部品追加における拡張性が低下する

- インスタンスの作り方いろいろ
  - new
  - clone
    - [Prototype Pattern](../06-prototype-pattern/)で登場
    - 既存インスタンスをもとに新規インスタンスを作れる
  - newInstance

## Related Patterns

- [Builder Pattern](../07-builder-pattern/)
  - Builder Pattern は段階を追って大きなインスタンスを作る
  - 対して Abstract Factory Pattern はインタフェースが定まっている抽象的な部品を組み合わせて複雑な構造を持つインスタンスを作る
- [Factory Method Pattern](../04-factory-method-pattern/)
  - Abstract Factory Pattern で**製品や部品を作る部分**は、Factory Method Pattern になることがある
- [Composite Pattern](../11-composite-pattern/)
  - Abstract Factory Pattern で作る**製品**は、Composite Pattern になることがある
- [Singleton Pattern](../05-singleton-pattern/)
  - Abstract Factory Pattern で作る**具体的な工場**は、Singleton Pattern になることがある
