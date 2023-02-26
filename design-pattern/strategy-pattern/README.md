# About Strategy Pattern
## Feature
- データ構造に対して適用する一連のアルゴリズムをカプセル化し、アルゴリズムの切り替えを容易にする
- ポリモーフィズムを利用し、種別ごとにコロなる挙動をさせたい時に便利なパターン

## Difference between state pattern
※ステートパターンと似ているが、あえて違いを言語化すると

- strategy pattern
    - アルゴリズムの切り出しをポリモーフィズムで解決する
- state pattern
    - 状態による分岐をポリモーフィズムで解決する

→着目点が違うが、ポリモーフィズムを活用している点は同じ

→起点となる思想は異なるがコードレベルに落とし込むと類似する

# Reference
- https://zenn.dev/nekoniki/articles/396ebc523930c196dc13
- 書籍 learning design patterns es6+JavaScript
