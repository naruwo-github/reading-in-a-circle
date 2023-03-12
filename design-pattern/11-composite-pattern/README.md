# Composite Pattern

- 容器と中身を同一視し、再起的な構造を作る
  - ex. `ディレクトリ`：ディレクトリの中にはディレクトリやファイルが入る（これらをディレクトリエントリとして同一視している）
    - → 容器（ディレクトリ）と中身（ファイル）を同一視することで再起的な木構造を実現している
- composite
  - 混合物、複合物の意

## Role

| Role        | Description                                 |
| ----------- | ------------------------------------------- |
| `Leaf`      | 中身。`Leaf`しか入れれない。                |
| `Composite` | 容器。`Leaf`と`Composite`を入れる。         |
| `Component` | `Leaf`と`Composite`を同一視するためのもの。 |
| `Client`    | Composite Pattern の利用者。                |

## Sample Code

### Java

| Class name | Description                                             |
| ---------- | ------------------------------------------------------- |
| Entry      | `Component`: File と Directory を同一視する`抽象`クラス |
| File       | `Leaf`: （中身）ファイル                                |
| Directory  | `Composite`: 容器（ディレクトリ）                       |
| Main       | `Client`: ...                                           |

### TypeScript

- Java のコードを簡略化したもの

## Usage/Tips/Pros and Cons

- 複数と単数の同一視
  - `容器と中身の同一視`を`複数と単数の同一視` と呼ぶこともできる
    - → 複数個のものを集め、それをあたかも一つのものであるかのように取り扱う
- Pros

  - オブジェクトの構造を再帰的に表現できるため、複雑な構造を持つオブジェクトを簡単に扱える
    - → クライアント側でのコードがシンプルにになる
  - コンポーネントを追加する場合にも、既存のコードを変更する必要がないため、柔軟な拡張が可能
  - 汎用的なインターフェースを使用するため、コンポーネントの実装をクライアント側から隠蔽することができる。

- Cons
  - コンポーネントごとに異なる/特定の処理を行う場合...
    - instanceof や型チェックなどを使用して、処理を分岐する必要がある
    - operation()メソッドを実行する際に、余分な処理が発生する可能性がある
  - コンポーネントを追加する場合、子要素が Leaf オブジェクトであるか、Composite オブジェクトであるかによって、処理が変わってくることがある
    - → クライアント側でのコードが複雑になることがある

## Related Patterns

- [Command Pattern](../22-command-pattern/)
  - マクロコマンドを作る際に Composite Pattern が使われる
- [Visitor Pattern](../13-visitor-pattern/)
  - Composite を巡りながら処理をするために使うパターン
- [Decorator Pattern](../12-decorator-pattern/)
  - 飾り枠と中身を同一視する
