# State Pattern

- `状態`をクラスで表現するパターン
- 「クラス切り替え」→「状態の変化」

## Role

| Role          | Description                                                                                |
| ------------- | ------------------------------------------------------------------------------------------ |
| State         | 状態に依存した振る舞いをするメソッドの集まり（インタフェース）                             |
| ConcreteState | 具体的な個々の状態を表現するもの                                                           |
| Context       | 現在の状態を表す ConcreteState を持ち、StatePattern の利用者に必要なインタフェースを定める |

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

- 時刻(昼間/夜間)ごとに警備の状態が変化する金庫警備システム

  - 状態の変化を愚直に if 文で判定する場合

  ```java
  class AAA {
    method1() {
      if (昼間) {
      } else if (夜間) {
      }
    }
    method2() {
      if (昼間) {
      } else if (夜間) {
      }
    }
    method3() {
      if (XXX) {
        if (昼間) {
        } else if (夜間) {
        }
      } else if (YYY) {
        if (昼間) {
        } else if (夜間) {
        }
      } else {
        if (昼間) {
        } else if (夜間) {
        }
      }
    }
  }
  ```

  - 状態をクラスとして保持する場合（State Pattern）

  ```java
  class 昼間 {
    method1() {}
    method2() {}
    method3() {}
  }

  class 夜間 {
    method1() {}
    method2() {}
    method3() {}
  }
  ```

### TypeScript

- ① オンラインショップの状態（処理中・受注・キャンセル）を表す例
- ② 電気のスイッチの状態（ON/OFF）を表す例

## Usage/Tips/Pros and Cons

- 新しい状態を追加する必要があるとき、何をプログラムすれば良いかが明確 → 新しいクラスを作る
- 状態遷移（State の切り替え）は誰が管理すべきか
  - 本サンプルコードでは、State は 2 種類と比較的少ないので、各 State 内に切り替え処理を持たせてもコードが複雑にならない
    - しかし、State が増えていく場合は、各 State 内に自身以外の State の情報を保持する必要が生じ、State 同士が相互参照することになる →State の削除・変更がしづらくなる
    - State が多いなら、Mediator パターンのように State 切り替えのための機構を導入することなどを検討すべき
- 同じ一つのインスタンスが複数の顔（クラス・インタフェース）を持つ
  - `this`を渡す場合、受付先型指定によって扱えるメソッドが変わる、これを意味する

## Related Patterns

- [Singleton Pattern](../05-singleton-pattern/)
  - State Pattern において状態を表すクラスはインスタンスフィールドを持たないので、ConcreteState を Singleton で実装する場合が多い
- [Flyweight Pattern](../20-flyweight-pattern/)
  - Flyweight Pattern を使って、ConcreteState を複数の Context で共有できる場合がある
