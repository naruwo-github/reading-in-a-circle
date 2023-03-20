# Observer Pattern

- 観察対象の状態が変化したことを検知し、処理を行うパターン
- `Publish-Subscribe` Pattern と呼ばれることもある

## Role

| Role              | Description                                                                          |
| ----------------- | ------------------------------------------------------------------------------------ |
| `Subject`         | 観測される側                                                                         |
|                   | Observer を登録する処理、削除する処理、自身の現在の状態を取得する処理、の 3 つを持つ |
| `ConcreteSubject` | `Subject`の実装                                                                      |
| `Observer`        | `Subject`から状態の変化の通知を受ける側                                              |

## Sample Code

### Java

| Class name            | Description                          |
| --------------------- | ------------------------------------ |
| Observer              | 観察者のインタフェース               |
| NumberGenerator       | 数を生成するオブジェクトの抽象クラス |
| RandomNumberGenerator | ランダムに数を生成するクラス         |
| DigitObserver         | 数字で数を表示する具体クラス         |
| GraphObserver         | グラフで数を表示する具体クラス       |
| Main                  | ...                                  |

- 数をたくさん生成するオブジェクトを観察し、その値を表示するもの
  - 観察者によって表示が異なる

## Usage/Tips/Pros and Cons

- 交換可能性
  - RandomNumberGenerator(`ConcreteSubject`)は、自分を観察しているのがどの`ConcreteObserver`(DigitObserver?GraphObserver?)か知らない
  - 一方 DigitObserver(`ConcreteObserver`)は、自分が観察しているのがどのオブジェクトか気にかけない
  - 交換可能性を高めるために
    - 抽象クラスやインタフェースを使い、具象クラスから抽象メソッドを引き剥がす
    - 引数でインスタンスを渡すときや、フィールドでインタンスを保持するときには、具象クラスではなく抽象クラスやインタフェースの型にする
- Observer 同士は独立するようにするべき
  - 具体的には、ConcreteObserver の update が呼ばれる順序が変わっても、問題が起きないようにするべき
- MVC
  - Model と View の関係は、Observer パターンの`Subject`と`Observer`の関係に対応する
    - 単一の Model に複数の View が対応する

## Related Patterns

- [Mediator Pattern](../16-mediator-pattern/)
  - Mediator と Colleague の通信に Observer Pattern を用いる場合がある
  - 状態変化を通知すると言う点で類似している（パターンの目的や視点は異なる）
    - Mediator Pattern では、Colleague の調停という目的で行う行為の一つ
    - Observer Pattern では、Subject の状態変化を Observer に通知し、**状態の同期をとること**に主眼がある
