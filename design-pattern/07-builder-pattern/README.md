# Builder Pattern

生成したいインスタンスが複雑な過程を経て生成される際に適したデザインパターン

## Role

| Role              | Description                                                                                |
| ----------------- | ------------------------------------------------------------------------------------------ |
| `Builder`         | インスタンス組み立てに必要な要素のインタフェースを定義する`抽象`クラス                     |
| `ConcreteBuilder` | `Builder` を実装する`具体`クラス                                                           |
| `Director`        | `Builder` のインタフェースを使ってインスタンスを組み立てる、その手順を実装する`具体`クラス |
|                   | `ConcreteBuilder` に依存したプログラミングをしない                                         |
| `Client`          | `Builder` を利用する側                                                                     |

## Sample Code(Java)

- 下記の構造を持つ「文書」を作成するプログラム

  - タイトルを一つ含む
  - 文字列をいくつか含む
  - 箇条書きの項目をいくつか含む

| class name  | description                                              |
| ----------- | -------------------------------------------------------- |
| Builder     | 文書を構成するためのメソッドを定める(`Builder`)          |
| Director    | 一つの文書を作るアルゴリズムを定める(`Director`)         |
| TextBuilder | テキストを使って文書を作る(`ConcreteBuilder`)            |
| HTMLBuilder | HTML ファイルを使って文書を作る(`ConcreteBuilder`)       |
| Main        | (`Client`)                                               |

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
      - 生成過程を`Director`内で一元管理できる、段階的に分解して単純化できる
  - 必要なプロパティやパラメータを指定できるため、生成するオブジェクトの正確性と一貫性を確保できる

- Cons
  - カプセル化によって可読性が低下する場合がある
  - Builder インターフェースと複数の具象 Builder クラスを作成する必要があるため、プロジェクトの規模の拡大に伴い実装が複雑化する

## Related Patterns

- [Template Method Pattern](../03-template-method-pattern/)
  - Template Method Patternではスーパークラスがサブクラスをコントロールするが、BuilderPattern では Director が Builder をコントロールする
- [Composite Pattern](../11-composite-pattern/)
  - BuilderPattern によって作られる生成物は、Composite Pattern になる場合がある
- [Abstract Factory Pattern](../08-abstract-factory-pattern/)
  - 両パターンとも複雑なインスタンスを生成するためのパターンで、類似している
- [Facade Pattern](../15-facade-pattern/)
  - 単純なインタフェースを外部に提供する点で類似している
    - Facade は内部モジュールを組み合わせて、作業を行うための単純なインタフェースを外部に提供する
    - Builder Pattern の Director は、Builder の複雑なメソッドを組み合わせて、インスタンを構築する単純なインタフェースを外部に提供する
