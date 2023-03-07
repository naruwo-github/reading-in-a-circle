# Singleton Pattern

- インスタンスが一個しか存在しないことを保証するパターン
  - あるクラスについて、インスタンスが単一であることを保証する
  - 単一のインスタンスをアプリケーション全体で共有する

## Role

- Singleton：唯一のインスタンスを得るための`static`メソッドを持つ

## Sample Code

### Java

- Singleton.java
  - Singleton クラスを定める
- Main.java
  - Singleton クラスのインスタンスを複数作り、それらが同一かを確認する

### C++

Java に同じ

## Usage/Tips

- `enum`を使った Singleton
  - `enum`の要素は定数としてインスタンスの唯一性が保証されている
    - ex. `java.time.Month.APRIL`は暦の 4 月を表すが、これはシステム内で唯一になっている
  - 要素を一つだけ持つ`enum`によって Singleton Pattern を実現できる
  ```java
  enum Singleton {
    INSTANCE;
    public void hello() {
        // ...
    }
  }
  ```

## Pros and Cons

- Pros
  - グローバル変数の使用を避け、インスタンスを一意に制御できる
    - インスタンスの生成や破棄を制御できるため、アプリケーションの安全性や保守性を向上させられる
  - リソースの効率的な利用ができる
    - 例えば、一意のインスタンスを複数のオブジェクトで共有することで、メモリ使用量を削減できる
- Cons
  - シングルトンインスタンスを参照するオブジェクトが増えると、シングルトンクラスが肥大化し、保守性が低下しやすい
  - マルチスレッド環境下で、複数のスレッドから同時に`getInstance()`メソッドが呼び出された場合、複数のインスタンスが生成される可能性がある
    - この場合、スレッドセーフな実装が必要になる
  - シングルトンインスタンスが生成されるタイミングを制御できないため、アプリケーションの起動時間が遅くなる可能性がある

## Related Patterns

以下で Singleton Pattern が使われることがある

- [Abstract Factory](../08-abstract-factory-pattern/)
- [Builder](../07-builder-pattern/)
- [Facade](../)
- [Flyweight]()
- [Prototype](../06-prototype-pattern/)
- [State](../)
