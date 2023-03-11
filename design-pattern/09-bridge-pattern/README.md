# Bridge Pattern

- `機能の階層`と`実装の階層`の 2 つ階層を分けつつ、それらがバラバラにならないよう繋がりを明示して橋渡しするパターン
  - 階層 ①：機能のクラス階層
    - 新しい機能を追加するために、クラス階層の中から自分の目的に近いクラスを探し、そのサブクラスを作って目的の機能を追加したクラスを産む構成のこと
  - 階層 ②：実装のクラス階層
    - 新しい実装を作るために AbstractClass のサブクラスを作って抽象メソッドを実装する、この構成のこと
  - クラス階層の混在とクラス階層の分離
    - クラス階層が一つだと、機能のクラス階層と実装のクラス階層とが一つの階層構造の中に混在することになる → クラス階層を複雑にし、見通しが悪くなってしまう
    - 2 つの独立したクラス階層に分け、バラバラにならないようそれらの間を橋渡しするのが魂胆

## Role

| Role                  | Description                                                       |
| --------------------- | ----------------------------------------------------------------- |
| `Abstraction`         | `機能のクラス階層`の最上位クラス                                  |
|                       | `Implementor`のメソッドを使って基本的な機能だけが記述されるクラス |
|                       | `Implementor`を保持する                                           |
| `RefinedAbstraction`  | `Abstraction`に対して機能を追加するもの                           |
| `Implementor`         | `実装のクラス階層`の最上位クラス                                  |
|                       | `Abstraction`のインタフェースを実装するためのメソッドを規定する   |
| `ConcreteImplementor` | `Implementor`のインタフェースを実装する                           |

## Sample Code

### Java

|     |     |     |
| --- | --- | --- |
|     |     |     |
|     |     |     |

-

### xxx

-

## Usage/Tips

- 分けておけば拡張が容易になる
- 継承は固い結びつき、委譲はゆるやかな結びつき

## Pros and Cons

- Pros
- Cons

## Related Patterns

- [Template Method Pattern](../03-template-method-pattern/)
- wip
- [Abstract Factory Pattern](../08-abstract-factory-pattern/)
- wip
- [Adapter Pattern](../02-adapter-pattern/)
- wip
