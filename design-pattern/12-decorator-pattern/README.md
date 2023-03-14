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

| Class name    | Description                                                   |
| ------------- | ------------------------------------------------------------- |
| Display       | (`Component`)文字列表示用の抽象クラス                         |
| StringDisplay | (`ConcreteComponent`)一行だけからなる文字列表示用の具体クラス |
| Border        | (`Decorator`)飾り枠を表す抽象クラス                           |
| SideBorder    | (`ConcreteDecorator`)左右にのみ飾りつける                     |
| FullBorder    | (`ConcreteDecorator`) 上下左右に飾りつける                    |
| Main          | ...                                                           |

### Python

- 文字列を飾る〜

## Usage/Tips

- 透過的なインタフェース
  - 透過的：意識しなくても使える
  - wip
- 中身を変えずに機能追加ができる
  - wip
- 動的な機能追加ができる
  - wip
- 単純な品揃えでも、多様な機能追加ができる
  - wip
- 継承と委譲における同一視
  - 継承：サブクラスとスーパークラスとを同一視
    - wip
  - 委譲：自分と委譲先とを同一視
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
