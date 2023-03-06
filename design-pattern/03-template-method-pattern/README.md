# Template Method Pattern
- スーパークラスで処理の枠組みを定め、サブクラスでその具体的内容を定める

## Role
- AbstractClass
    - テンプレートメソッドを実装する
    - テンプレートメソッドで使っている抽象メソッドを宣言する 
- ConcreteClass
    - AbstractClassで宣言された抽象メソッドを具体的に実装する

## Sample Code

| name | content |
| --- | --- |
| AbstractDisplay | メソッドdisplay飲み実装している抽象クラス |
| CharDisplay | 具体クラス |
| StringDisplay | 具体クラス |
| Main | 動作確認用クラス |

## Usage/Pros and Cons
- Usage
    -
- Pros
    -
- Cons
    -

## Related Pattern
- Factory Method Pattern
    - Template Method Patternをインスタンス生成に応用したもの
- Strategy Pattern
    - Template Method Patternでは継承を利用してプログラムの動作を変更できる
        - 対してStrategy Patternでは、委譲を利用してプログラムの動作を変更できる
    - プログラムの一部分を変更するというよりも、アルゴリズム全体をごっそり切り替えるもの
