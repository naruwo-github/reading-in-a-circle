# Visitor Pattern

- `visitor`：`訪問者`
- `データ構造`と`処理`を分離する
- `データ構造`の中を巡り歩く主体である`訪問者`を表すクラスを用意し、そのクラスに`処理`を任せる
  - 新しい`処理`を追加したいときは新しい`訪問者`を作れば良い
  - `データ構造`の方は戸を叩いてくる`訪問者`を受け入れてあげれば良い

## Role

|     |     |     |
| --- | --- | --- |
|     |     |     |
|     |     |     |

-

## Sample Code

### Java

| Class name  | Description                                                                |
| ----------- | -------------------------------------------------------------------------- |
| Visitor     | 訪問者を表す`抽象`クラス                                                   |
| Element     | Visitor クラスのインスタンスを受け入れるデータ構造を表すインタフェース     |
| ListVisitor | Visitor クラスのサブクラスで、ファイルやディレクトリの一覧を表示するクラス |
| Entry       | File, Directory のスーパークラスとなる`抽象`クラス                         |
| File        | ...                                                                        |
| Directory   | ...                                                                        |
| Main        | ...                                                                        |

- ファイルとディレクトリで構成されたデータ構造の中を訪問者が渡り歩き、ファイルの一覧を表示するプログラムを作成する
  - [Composite Pattern](../11-composite-pattern/)と同じテーマ

### xxx

-

## Usage/Tips

-

## Pros and Cons

- ## Pros
- ## Cons

## Related Patterns

-
