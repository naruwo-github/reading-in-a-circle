# Abstract Factory Pattern

- 部品の具体的な実装には注目せず、インタフェースに注目する->そのインタフェースだけを使って部品を組み立て、製品にまとめる

## Role

| Role            | Description                                                                  |
| --------------- | ---------------------------------------------------------------------------- |
| AbstractProduct | AbstractFactory によって作られる抽象的な部品や製品のインタフェースを定義する |
| AbstractFactory | AbstractProduct のインスタンスを作るためのインタフェースを定義する           |
| Client          | AbstractFactory と AbstractProduct のインタフェース`のみ`を使って仕事を行う  |
|                 | 具体的な部品や製品や工場については知らない                                   |
| ConcreteProduct | AbstractProduct のインタフェースを実する                                     |
| ConcreteFactory | AbstractFactory のインタフェースを実装する                                   |

## Sample Code(Java)

- プログラムの目的：階層構造を持ったリンク集を HTML ファイルとして作る
- 3 つのパッケージで構成される
  - factory：抽象的な工場・部品・製品
  - 無名パッケージ：Main
  - listfactory：具体的な工場・部品・製品

| Package name | Class name  | Description                                     |
| ------------ | ----------- | ----------------------------------------------- |
| factory      | Factory     | Link, Tray, Page を作る`抽象`クラス             |
| factory      | Item        | Lint, Tray を統一的に扱うためのクラス           |
| factory      | Link        | `抽象`的な部品：HTML のリンクを表すクラス       |
| factory      | Tray        | `抽象`的な部品：Link, Tray を集めたクラス       |
| factory      | Page        | `抽象`的な部品：HTML のページを表すクラス       |
| no title     | Main        | ...                                             |
| listfactory  | ListFactory | ListLink, ListTray, ListPage を作る`具体`クラス |
| listfactory  | ListLink    | `具体`的な部品：HTML のリンクを表すクラス       |
| listfactory  | ListTray    | `具体`的な部品：Link, Tray を集めたクラス       |
| listfactory  | ListPage    | `具体`的な部品：HTML のページを表すクラス       |

## Usage/Tips/Pros and Cons

- 具体的な工場を新規追加するのが簡単
  - どのようなクラスを作り、どのようなメソッドを実装すればいいかがはっきりしている
  - 具体的な工場をいくら追加しても抽象的な工場や Main 処理に変更を加えなくて良い
- 部品を新たに追加するのは困難

  - すでに存在する具体的な工場全てに修正を加える必要になる->既存の工場が多いほど、部品追加における拡張性が低下する

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