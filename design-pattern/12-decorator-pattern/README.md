# Decorator Pattern

透過的なインタフェースを保ったまま、オブジェクトに次々に機能追加していくパターン

- インタフェースが透過的である
  - 透過的: 意識しなくても使える
  - サブクラスでスーパークラスを包んでも、そのインタフェースは全て隠されることなく他クラスから参照できる状態のこと
- ex...
  - 中心にあるスポンジケーキに対し
    - クリームを塗るとショートケーキへ
    - イチゴを載せるとストロベリーショートケーキへ
    - 板チョコを乗せて名前を書き、キャンドルを立てればバースデーケーキへ
    - ...

## Role

| Role                | Description                                                              |
| ------------------- | ------------------------------------------------------------------------ |
| `Component`         | 装飾される側のインタフェース(スポンジケーキ)                             |
| `ConcreteComponent` | 装飾される側の実装(スポンジケーキの具体)                                 |
| `Decorator`         | 装飾する側のインタフェース(デコレーションの材料)                         |
|                     | 装飾される側のインタフェースを持ち、その実体(スポンジケーキの具体)も持つ |
| `ConcreteDecorator` | 具体的なデコレーション材料(クリーム、板イチゴ、板チョコなど)             |

```mermaid
classDiagram

class Component {
  <<abstract>>
}

class ConcreteComponent

class Decorator {
  <<abstract>>
  -Component
}

class ConcreteDecorator1 {
  -Component
}
class ConcreteDecorator2 {
  -Component
}
class ConcreteDecorator3 {
  -Component
}

Component <|-- ConcreteComponent
Component <|-- Decorator
Component <-- Decorator
Decorator <|-- ConcreteDecorator1
Decorator <|-- ConcreteDecorator2
Decorator <|-- ConcreteDecorator3
```

## Sample Code

### ① Java

<details>
<summary>文字列 xxx の周りに飾り枠をつけて表示する</summary>

出力の例

```
+-----+
| xxx |
+-----+
```

| Class name    | Description                              |
| ------------- | ---------------------------------------- |
| Display       | `Component`                              |
|               | 文字列表示用の抽象クラス                 |
| StringDisplay | `ConcreteComponent`                      |
|               | 一行だけからなる文字列表示用の具体クラス |
| Border        | `Decorator`                              |
|               | 飾り枠を表す抽象クラス                   |
| SideBorder    | `ConcreteDecorator`                      |
|               | 左右にのみ飾りつける                     |
| FullBorder    | `ConcreteDecorator`                      |
|               | 上下左右に飾りつける                     |
| Main          | ...                                      |

</details>

### ② TypeScript

- 文字列を飾るプログラム
  - baseLabel: `Hello, World!`
  - boldLabel: `<b>Hello, World!</b>`
  - underlineLabel: `<u>Hello, World!</u>`
  - boldUnderlineLabel: `<b><u>Hello, World!</u></b>`

```mermaid
classDiagram

class TextComponent {
  <<interface>>
  +getText()* string
}

class TextLabel {
  -string text
  +getText() string
}

class TextDecorator {
  -TextComponent textComponent
  +getText() string
}

class BoldDecorator {
  +getText() string
}

class UnderlineDecorator {
  +getText() string
}

class XXXXDecorator {
  +getText() string
}

TextComponent <|.. TextLabel
TextComponent <|.. TextDecorator
TextComponent <-- TextDecorator
TextDecorator <|-- BoldDecorator
TextDecorator <|-- UnderlineDecorator
TextDecorator <|-- XXXXDecorator
```

## Usage/Tips

- 中身を変えずに機能追加ができる
  - 包まれるものを変更することなく、機能の追加ができる
- 動的な機能追加ができる
  - 委譲（インスタンスの DI）でクラス間を結合しているので、Client 側のソース変更だけで別オブジェクトを生成できる
- 単純な品揃えでも、多様な機能追加ができる
  - ConcreteDecorator をたくさん用意しておくことで、それらを自由に組み合わせたオブジェクトを生成できる

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
