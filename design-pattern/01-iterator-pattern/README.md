# Iterator Pattern
- 集合体の要素を、統一した方法で一つ一つ処理していくパターン
- 何かがたくさん集まっているときに、それを順番に指し示し、全体をして処理を繰り返すもの

下記ブログ記事にまとめた↓↓↓
[【5分でわかる！】TypeScriptで学ぶDesign Pattern〜Iterator Pattern〜](https://chan-naru.hatenablog.com/entry/2023/04/12/072309)

## Sample Program
- 本棚の中に本を入れ、その本の名前を順番に表示する

## Memo
- [Q] なぜIterator Patternなんて面倒なことをするのか？
    - [Q] なぜ集合体（インスタンスたち）の外にIterator役を作るのか？
        - [A] 実装と切り離して繰り返しを行えるから。例えば、実装側で配列からリストにデータ構造の変更があったとしても、繰り返し処理の利用側ではIteratorのメソッドだけ使えればいい。
- 具体クラスだけしか使わないと、クラス間の結合が強くなり、再利用しづらくなる→`抽象クラスやインタフェースを使ってプログラミングする`
- `next`メソッドは厳密には`returnCurrentElementAndAdvanceToNextPosition`
- 単一のインスタンスに対し、複数のIteratorを作れる（→拡張for文を何回でも実行できる）

## Related Patterns
- Visitor Pattern
    - たくさんの要素が集まっている中を渡り歩きながら、同じ処理を繰り帰り適用する
- Composite Pattern
    - 再帰的な構造を持ったパターンで、これにIterator Patternを適用するのは困難
- [Factory Method Pattern](../04-factory-method-pattern/)
    - Iteratorインスタンスを作成する際に使われることがある→組み合わせられる
