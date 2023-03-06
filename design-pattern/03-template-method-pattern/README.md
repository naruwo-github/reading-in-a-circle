# Template Method Pattern

- スーパークラスで処理の枠組みを定め、サブクラスでその具体的内容を定める

## Role

- AbstractClass
  - テンプレートメソッドを実装する
  - テンプレートメソッドで使っている抽象メソッドを宣言する
- ConcreteClass
  - AbstractClass で宣言された抽象メソッドを具体的に実装する

## Sample Code

| name            | content                                     |
| --------------- | ------------------------------------------- |
| AbstractDisplay | メソッド display 飲み実装している抽象クラス |
| CharDisplay     | 具体クラス                                  |
| StringDisplay   | 具体クラス                                  |
| Main            | 動作確認用クラス                            |

## Usage/Tips

- スーパークラス型の変数に、サブクラスのインスタンスを代入する
  - どのサブクラスのインスタンスを代入しても動作するようにする LSP を満たせているかがわかりやすい
- スーパークラスで記述を増やす->サブクラスでの記述は少なるなるが自由度が落ちる
- スーパークラスの記述を減らす->サブクラスでの自由度が増えるが記述量が増え、管理コストが増える

## Pros and Cons

- Pros
  - スーパークラス側でアルゴリズムを記述しており、サブクラス側でアルゴリズムを記述しなくて良い
- Cons
  - スーパークラスで宣言された抽象メソッドをサブクラスで実装する際は、そのメソッドがどういうタイミングで呼ばれるかを理解しておく必要がある

## Related Pattern

- [Factory Method Pattern](../04-factory-method-pattern/)
  - Template Method Pattern をインスタンス生成に応用したもの
- Strategy Pattern
  - Template Method Pattern では継承を利用してプログラムの動作を変更できる
    - 対して Strategy Pattern では、委譲を利用してプログラムの動作を変更できる
  - プログラムの一部分を変更するというよりも、アルゴリズム全体をごっそり切り替えるもの
