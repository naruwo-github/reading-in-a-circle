# State Pattern

- `状態`をクラスで表現するパターン
- 「クラス切り替え」→「状態の変化」

## Role

|     |     |     |
| --- | --- | --- |
|     |     |     |
|     |     |     |

-

## Sample Code

### Java

| Class name | Description                                                  |
| ---------- | ------------------------------------------------------------ |
| State      | 金庫の状態を表すインタフェース                               |
| DayState   | 昼間の状態を実装するクラス                                   |
| NightState | 夜間の状態を実装するクラス                                   |
| Context    | 金庫の状態を管理し、警備センターとの連絡を取るインタフェース |
| SafeFrame  | Context を実装するクラス。ボタンや画面表示などの GUI を持つ  |
| Main       | ...                                                          |

- 時刻ごとに警備の状態が変化する金庫警備システム
  - 状態の変化を愚直に if 文で判定する場合
  ```java
  // wip
  ```
  - 状態をクラスとして保持する場合（State Pattern）
  ```java
  // wip
  ```

## Usage/Tips/Pros and Cons

- 新しい状態を追加する必要があるとき、何をプログラムすれば良いかが明確
  - wip
- Pros
  - wip
- Cons
  - wip

## Related Patterns

- [x Pattern]()
  - wip
- [x Pattern]()
  - wip
- [x Pattern]()
  - wip
