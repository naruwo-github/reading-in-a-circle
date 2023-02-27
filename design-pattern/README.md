# About Design Pattern
デザインパターンについて知識を深めるリポジトリ
- デザインパターンは共通言語になり、開発者同士のコミュニケーションを効率化させる
- Javaを初め複数の言語でサンプルコードを書いてみる（つもり）
    - C++, Dart, JavaScript/TypeScript, Python...
- インターフェースとは、通常はあるクラスの持っているメソッドの集まりを指す
    - Javaでは、`interface`キーワードを使って宣言されるものも指す

## Reference
- 書籍`JAVA言語で学ぶデザインパターン入門第3版`
- その他多くのWebサイト

## About UML
- UML：システムを視覚化したり、仕様や設計を文書化したりするための表現方法
- クラス図：クラスやインスタンス、インタフェースなどの`静的な関係`（時間の経過によって変化しない）を表現したもの
    - サブクラスからスーパークラスへ矢印を伸ばす
    - 斜体：`抽象`
    - 下線：`静的`
- インタフェースと実装
    - 実装クラスからインタフェースへ矢印を伸ばす
    - UMLでJavaのインタフェースを表現する場合は<<interface>>と書く
- 集約(aggregation)
    - どのような実装であれインスタンスを持っていればその関係は集約
    - 白抜きの菱形で表す
- アクセス制御
    - +：`public`
    - -：`private` クラス外からアクセスできない
    - #：`protected` 同じクラスかサブクラス、および同じパッケージ内のクラスのみアクセス可
    - ~：同じパッケージないからのみアクセスできるメソッドやフィールドを指す
- シーケンス図：プログラムが動く際、どのメソッドがどの順番で実行されるか、どのような事象がどういう順番で起きるかを表現したもの
    - `動的な関係`（時間の経過によって変化する）を表現したもので、上から順に読んでいく
    - ライフライン：インスタンスからした方向に伸びる破線で、インスタンスが存在する期間を示す
    - 黒矢印：メソッドの呼び出し
    - 破線の矢印：メソッドからのリターン

## Before Learning Design Pattern
- デザインパターンは抽象であり、どういう種類のクラスやインタフェースが登場し、それらが互いにどういう関係であるか、である
- デザインパターンの目標の一つは、プログラムを再利用可能にすること
    - 完成品ではなくただの部品であり、今後拡張していくもの、変更を加えていくものと捉える
- UML図は、眺めるものではなく、順を追って読んで理解するもの