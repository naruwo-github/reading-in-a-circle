# Decorator Pattern

- オブジェクトにどんどんデコレーションを施していくデザインパターン
  - 中心にあるスポンジケーキに対し
    - クリームを塗るとショートケーキへ
    - イチゴを載せるとストロベリーショートケーキへ
    - 板チョコを乗せて名前を書き、キャンドルを立てればバースデーケーキへ

## Role

| Role                | Description                                              |
| ------------------- | -------------------------------------------------------- |
| `Component`         | スポンジケーキのインタフェース                           |
| `ConcreteComponent` | `Component`を実装する具体的なスポンジケーキ              |
| `Decorator`         | `Component`と同じインタフェースを持ち、`Component`も持つ |
|                     | 自身が飾る対象を知っている                               |
| `ConcreteDecorator` | 具体的な`Decorator`                                      |

## Sample Code

### Java

- 内容：文字列 xxx の周りに飾り枠をつけて表示する

```
+-----+
| xxx |
+-----+
```

| Class name    | Description |
| ------------- | ----------- |
| Display       |             |
| StringDisplay |             |
| Border        |             |
| SideBorder    |             |
| FullBorder    |             |
| Main          |             |

### Python

- 文字列を飾る〜

## Usage/Tips/Pros and Cons

- wip
  - wip
- Pros
  - wip
- Cons
  - wip

## Related Patterns

- [Adapter Pattern](../02-adapter-pattern/)
  - Adapter はズレのある二つのインタフェースをつなぐ
  - Decorator は中身のインタフェースを変えずに外枠を作る（透過的）
- [Strategy Pattern](../10-strategy-pattern/)
  - Strategy はアルゴリズムを切り替えて機能実現する
  - Decorator は外枠を取り替えたり、外枠を重ねたりして機能を追加する
- [Composite Pattern](../11-composite-pattern/)
  - Composite は機能を追加するところでなく、容器と中身を同一視するところに主眼がある
  - Decorator は機能を柔軟に追加するために再帰的な構造を利用する
