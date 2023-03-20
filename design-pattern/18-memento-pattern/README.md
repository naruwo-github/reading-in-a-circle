# Memento Pattern

- **カプセル化の破壊**を防ぎつつインスタンスの保存・復元を行うためのパターン
  - オブジェクトの状態をできるだけ公開せずに保存する方法
- オブジェクト指向プログラミングで Undo を行うには、インスタンスの持つ情報を保存しておく必要がある
  - インスタンスを復元するためには、インスタンス内部の情報に自由にアクセスできる必要がある
    - しかし、情報にアクセスする処理がシステムの至る所に点在すると拡張性が著しく低下する →**カプセル化の破壊**
- Memento Pattern を利用すると、プログラムに対して下記のことを行える
  - Undo
  - Redo
  - History
  - Snapshot

## Role

| Role       | Description                                                                                                            |
| ---------- | ---------------------------------------------------------------------------------------------------------------------- |
| Originator | snapshot の作成や undo を行う役                                                                                        |
| Memento    | Originator の内部情報をまとめる（内部情報は公開しない）                                                                |
|            | 次の 2 種類のインタフェースを持つ                                                                                      |
|            | ①wide interface: オブジェクトの情報を復元するために必要な情報が全て得られるメソッドの集合。Originator にのみ公開する。 |
|            | ②narrow interface: わずかな内部情報を公開するもの。Caretaker に公開する。                                              |
| Caretaker  | Originator の状態を保存したいときに、それを Originator に伝える                                                        |
|            | narrow interface しか使えないため、Memento の内部情報にアクセスできるわけではない                                      |
|            | ただ単に、作成してもらった Memento をブラックボックスとして保存しておくのみ                                            |

## Sample Code

### Java

| Package | Class name | Description                                                |
| ------- | ---------- | ---------------------------------------------------------- |
| game    | Memento    | Gamer の状態を表すクラス                                   |
| game    | Gamer      | ゲームを行う主人公のクラスで、Memento のインスタンスを作る |
|         | Main       | ...                                                        |

- フルーツを集めるサイコロゲーム

## Usage/Tips/Pros and Cons

- Memento は複数保持できる
- Memento をファイルとして永久保存しようとすると、賞味期限が問題になる
  - プログラムや関連ライブラリのバージョンアップにより、ファイル保存された Memento と現稼働の Memento の状態の整合性が取れなくなる可能性がある
- Caretaker と Originator を分ける意味 →**役割分担**
  - Caretaker は、snapshot 作成や undo 実施のタイミングを決めたり、Memento を保持したりする
  - Originator は、Memento を作ったり、与えられた Memento を使って自分の状態を元に戻す仕事をする
  - **役割分担**すると、Originator を変更する頻度を減らせる
    - 複数ステップの undo がしたい
    - undo だけでなく現在の状態をファイル保存したい
    - ...

## Related Patterns

- [Command Pattern](../22-command-pattern/)
  - Command Pattern で命令を処理する場合に、Memento パターンを使って undo/redo ができる
- [Prototype Pattern](../06-prototype-pattern/)
  - Memento Pattern では、現在のインスタンスの状態の中で復元時に必要な情報のみを保存する
  - Prototype Pattern では、インスタンスの内容を全てコピーする
- [State Pattern](../19-state-pattern/)
  - Memento Pattern では、インスタンスが状態を表す
  - State Pattern では、クラスが状態を表す
