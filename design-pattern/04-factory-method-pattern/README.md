# Factory Method Pattern

- `Template Method Pattern`をインスタンス生成の場面に適用したもの
- スーパークラス側でインスタンスの作り方を定め、具体的な肉付けはサブクラス側で行う
- インスタンス生成の枠組み（フレームワーク）と実際のインスタンス生成のクラスとを分けて考えることができる

## Role

| name            | duty                                                             |
| --------------- | ---------------------------------------------------------------- |
| Product         | 生成されるインスタンスが持つべきインタフェースを定める抽象クラス |
| Creator         | Product を生成する抽象クラス。                                   |
|                 | 実際に生成する ConcreteProduct については何も知らない。          |
| ConcreteProduct | Product に対し、具体的な肉付けをする側                           |
| ConcreteCreator | Creator に対し、具体的な肉付けをする側                           |

## Sample Code

### Java

- 題材：身分証明書カードを作る工場
- 構成
  - framework/
    - Product.java
    - Factory.java
  - idcard/
    - IDCard.java
    - IDCardFactory.java
  - Main.java

### Dart

- 題材：異なるタイプのペットを作成する
- 詳細
  - 抽象クラス`Pet`を定義し、`name`と`speak`の 2 つのプロパティ、また`factory`メソッドを定義する
  - `Cat`と`Dog`クラスは`Pet`クラスを実装する
  - `main`関数では、`Cat`と`Dog`の 2 つのインスタンスを作成し、それぞれの名前と鳴き声を出力する。
    - `Pet`クラスの`factory`に無効なタイプのペットを指定した場合は、`ArgumentError`をスローする。

Dart ってファクトリーメソッドがあるらしい 👀
[公式 factory constructor](https://dart.dev/guides/language/language-tour#factory-constructors:~:text=using%20constructors.-,Factory%20constructors,-Use%20the%20factory)

## Usage/Tips

- `createProduct`メソッドの実装方法は 2 通り

  - 抽象メソッドにする
    - サブクラスは必ず`createProduct`を実装しなければならない

  ```java
  abstract class Factory {
    public abstract Product createProduct(String name);
  }
  ```

  - デフォルト実装を用意しておく
    - Product を直接`new`するので、Product クラスを具体クラスにしなければならない

  ```java
  class Factory {
    public Product createProduct(String name) {
      return new Product(name);
    }
  }
  ```

- 全ての開発者や保守担当者がデザインパターンを知っているとは限らない（むしろ知らない方が多いかも）ので、ソースコード上で加えて欲しくない変更があれば、その Why をコメントとして残しておくべき

## Pros and Cons

- Pros
  - 柔軟性
    - どのようなオブジェクトを作成するかを決定するために複雑なロジックを含めることができる。これにより、クライアントコードは、ファクトリーメソッドに対して必要な引数を提供するだけで、複雑なオブジェクトの作成プロセスを知る必要がない。
  - カプセル化
    - オブジェクトの作成方法を隠蔽する。これにより、作成されたオブジェクトの内部実装の詳細を隠蔽し、外部からの誤用や悪用を防ぐ。
  - コードの重複を防止
    - オブジェクトの作成ロジックを共有する。これにより、コードの重複を防止し、コードの保守性を向上させられる。
- Cons
  - 追加コスト
    - 実装に追加コストがかかる。本パターンを実装するためには、新しいインターフェースを定義する必要があり、クラスの数やコードの複雑さが増加する可能性がある。
  - 柔軟性の欠如
    - ファクトリーメソッドが複雑になりすぎると、追加のオブジェクトタイプをサポートするために、新しいインターフェースの追加が必要になる場合がある。これは、柔軟性を損なう可能性がある。
  - テスト
    - ファクトリーメソッドを使用して、オブジェクトを作成する場合、ユニットテストの実装が困難になる場合がある。これは、ファクトリーメソッドが外部依存関係を持つため、依存関係をモックする必要があるから。

## Related Patterns

- [Iterator Pattern](../01-iterator-pattern/)
  - iterator メソッドが Iterator のインスタンスを生成するときに Factory Method が使われることがある
- [Template Method Pattern](../03-template-method-pattern/)
  - Factory Method Pattern が Template Method を応用している関係
- Singleton Pattern
  - Creator クラスのインスタンスは複数存在することは稀なため、多くの場合、Singleton Pattern で作れる
- Composite Pattern
  - Product や ConcreteProduct に Composite Pattern を当てはめることができる場合がある
