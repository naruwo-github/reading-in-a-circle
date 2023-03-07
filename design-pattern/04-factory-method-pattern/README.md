# Factory Method Pattern

- Template Method Pattern をインスタンス生成の場面に適用したもの
- インスタンスの作り方をスーパークラス側で定めるが、具体的なクラス名までは定めない
- 具体的な肉付けは全てサブクラス側で行う
- インスタンス生成の枠組み（フレームワーク）と実際のインスタンス生成のクラスとを分けて考えることができる

## Role

- Product
  - フレームワーク側
  - 生成されるインスタンスが持つべきインタフェースを定める抽象クラス
- Creator
  - フレームワーク側
  - Product を生成する抽象クラス
  - 実際に生成する ConcreteProduct については何も知らない
  - new による実際のインスタンス生成を、インスタンス生成のためのメソッド呼び出しに代える → 具体的なクラス名による束縛からスーパークラスを解放する
- ConcreteProduct
  - 具体的な肉付けをする側
- ConcreteCreator
  - 具体的な肉付けをする側

## Sample Code

- 題材：身分証明書カードを作る工場
- 構成
  - framework package
    - Product
    - Factory
  - idcard package
    - IDCard
    - IDCardFactory
  - Main.java

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

## Pros and Cons

- Pros
  - framework 側は具体クラスに依存していないため、何も変更を加えることなく framework を使い回すことができる
- Cons

## Related Patterns

- [Iterator Pattern](../01-iterator-pattern/)
  - iterator メソッドが Iterator のインスタンスを生成するときに Factory Method が使われることがある
- [Template Method Pattern](../03-template-method-pattern/)
  - Factory Method Pattern が Template Method を応用している関係
- Singleton Pattern
  - Creator クラスのインスタンスは複数存在することは稀なため、多くの場合、Singleton Pattern で作れる
- Composite Pattern
  - Product や ConcreteProduct に Composite Pattern を当てはめることができる場合がある
