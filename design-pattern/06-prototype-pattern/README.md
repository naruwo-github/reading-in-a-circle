# Prototype Pattern

- インスタンスから別のインスタンスを作り出すパターン

- `new`でインスタンス生成する場合はクラス名を指定する必要があるが、クラス名を指定せずインスタンス生成したい場合がある。その場合、インスタンスを複製して作る。
- 主に、下記のような場合にクラス名を指定したくない。
  - 扱うオブジェクトの種類が多すぎて、一つ一つを別のクラスにするとファイル数が膨大になってしまう場合
  - 複雑な過程を経て作られるものであり、クラスからインスタンスを生成するのが難しい場合
    - ex. ユーザ操作で作られた図形のインスタンス
  - インスタンスを生成するときのフレームワークを、特定のクラスに依存しないように作りたい場合

## Role

- Prototype
  - インスタンスを複製して新たなインスタンスを作るためのメソッドを定める
- ConcretePrototype
  - インスタンスを複製するメソッドを実装する
- Client
  - インスタンスを複製するメソッドを活用する

## Sample Code

### Java

| package name | class/interface name | description                                                         |
| ------------ | -------------------- | ------------------------------------------------------------------- |
| framework    | Product              | 抽象メソッド`use`, `createCopy`を宣言するインタフェース             |
| framework    | Manager              | `createCopy`を使ってインスタンスを複製するクラス                    |
| no title     | MessageBox           | 文字列を枠線で囲って表示するクラス。`use`, `createCopy`を実装する。 |
| no title     | UnderlinePen         | 文字列に架線を引いて表示するクラス。`use`, `createCopy`を実装する。 |
| no title     | Main                 | ...                                                                 |

### Python

-

## Usage/Tips

- prototype: 原型、模範
- Java では複製することを`clone`と呼ぶ

## Pros and Cons

- Pros
  - wip
- Cons
  - wip

## Related Patterns

- x Pattern
- x Pattern
- x Pattern
