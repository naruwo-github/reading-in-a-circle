# Mediator Pattern

- 複数のメンバーがいる状況において、仲介者をたて、メンバー間同士のコミュニケーションは行わず、必ず仲介者を介して意思決定するパターン
- 複雑に絡み合うオブジェクトたちの相互通信をやめ、Mediator に情報を集中させることで処理を整理するパターン

## Role

| Role              | Description                                              |
| ----------------- | -------------------------------------------------------- |
| Mediator          | Colleague と連携して調整するためのインタフェースを定める |
| ConcreteMediator  | Mediator を実装し、具体的な連携・調整内容を定める        |
| Colleague         | Mediator と連携するインタフェースを定める                |
| ConcreteColleague | Colleague を実装する                                     |

## Sample Code

### Java

| Class name         | Description              |
| ------------------ | ------------------------ |
| Mediator           | 仲介者のインタフェース   |
| Colleague          | メンバーのインタフェース |
| ColleagueButton    | ...                      |
| ColleagueTextField | ...                      |
| ColleagueCheckbox  | ...                      |
| LoginFrame         | Mediator を実装する      |
| Main               | ...                      |

- テーマ：「名前とパスワードを入力するログインダイアログ」という GUI アプリを作る
  - 多数のオブジェクト間の調整を行わなければならないときこそ Mediator の出番

## Usage/Tips/Pros and Cons

- 今回の例で言うと、GUI の状態の管理を`colleagueChanged`メソッド内で集中管理することで、複雑なロジックを単一のメソッド内に隠蔽して各クラス内に分散するのを防いだことになる
  - オブジェクト指向では、一極集中を避け、処理を分散させることが多い（分割統治）が、メリハリをつけるのが大事
- Pros
- Cons

## Related Patterns

- [Facade Pattern](../15-facade-pattern/)
  - Mediator は双方向、Facade は一方向
- [Observer Pattern](../17-observer-pattern/)
  - Mediator と Colleague の連携部分に使われる場合がある
