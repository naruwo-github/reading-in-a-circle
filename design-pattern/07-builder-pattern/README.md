# Builder Pattern

複雑な構造を持ったインスタンスを組み立てていくパターン

## Role

| Role            | Description                                                                              |
| --------------- | ---------------------------------------------------------------------------------------- |
| Builder         | インスタンス組み立てに必要な要素のインタフェースを定義する`抽象`クラス                   |
| ConcreteBuilder | Builder を実装する`具体`クラス                                                           |
| Director        | Builder のインタフェースを使ってインスタンスを組み立てる、その手順を実装する`具体`クラス |
|                 | ConcreteBuilder に依存したプログラミングをしない                                         |
| Client          | Builder を利用する側                                                                     |

## Sample Code(Java)

- 書きの構造を持つ「文書」を作成するプログラム

  - タイトルを一つ含む
  - 文字列をいくつか含む
  - 箇条書きの項目をいくつか含む

| class name  | description                                            |
| ----------- | ------------------------------------------------------ |
| Builder     | 文書を構成するためのメソッドを定めた`Builder`クラス    |
| Director    | 一つの文書を作る`Director`クラス                       |
| TextBuilder | テキストを使って文書を作る`ConcreteBuilder`クラス      |
| HTMLBuilder | HTML ファイルを使って文書を作る`ConcreteBuilder`クラス |
| Main        | 動作確認用の`Client`                                   |

## Usage/Tips

- オブジェクトの生成プロセスが複雑な場合に有効...すなわちシンプルなオブジェクトの場合は、パフォーマンスの面で、ビルダーパターンは適さない
- OOP では、誰が何を知っているか/知らないかが大事
  - 知らないようにする（カプセル化）により、交換可能性が高まる
- `DI(Dependency Injection)`
  - 「ソースコードには書かれてないけど実際はこのインスタンス使ってね」という意を込めてインスタンスを渡すこと

## Pros and Cons

- Pros

  - オブジェクトの生成プロセスをカプセル化するため…
    - オブジェクトの生成方法が変更しやすい
    - オブジェクトの生成過程が複雑な場合に対処できる
      - 生成過程を Director 内で一元管理できる、段階的に分解して単純化できる
    - 生成されたオブジェクトの品質を高めやすい
      - 必要なプロパティやパラメータを指定することができるため、生成されたオブジェクトの正確性と一貫性を確保できる

- Cons
  - カプセル化によって可読性が低下する場合がある
  - Builder インターフェースと複数の具象 Builder クラスを作成する必要があるため、プロジェクトの規模の拡大に伴い実装が複雑化する

## Related Patterns

- [Template Method Pattern](../03-template-method-pattern/)
  - スーパークラスがサブクラスをコントロールするが、BuilderPattern では Director が Builder をコントロールする
- [Composite Pattern](../11-composite-pattern/)
  - BuilderPattern によって作られる生成物は、Composite Pattern になる場合がある
- [Abstract Factory Pattern](../08-abstract-factory-pattern/)(->類似している)
  - 両パターンとも複雑なインスタンスを生成するためのパターン
- Facade Pattern(->類似している)
  - Facade は内部モジュールを組み合わせて、作業を行うための単純なインタフェースを外部に提供する
  - Builder Pattern の Director は、Builder の複雑なメソッドを組み合わせて、インスタンを構築する単純なインタフェースを外部に提供する
