# Facade Pattern

- クラスの制御を一挙に担い、Client からの要求の窓口になるデザインパターン
  - 背景：プログラムは徐々に肥大化していく
    - たくさんのクラスが作られ、相互に関係し、複雑になっていく
      - たくさんのクラスを個別に制御するのではなく制御するための「窓口」を用意しておくのが良い
      - 「窓口」に要求を出すだけで仕事が済むので

## Role

| Role                             | Description                                                                   |
| -------------------------------- | ----------------------------------------------------------------------------- |
| Facade                           | その他大勢の役への「窓口」となり、Client にシンプルなインタフェースを提供する |
| システムを構成するその他大勢の役 | Facade から呼び出されるが Facade を意識しない                                 |
| Client                           | Facade を使う役                                                               |

## Sample Code

### Java

| Package   | Class name | Description                                           |
| --------- | ---------- | ----------------------------------------------------- |
| pagemaker | Database   | メールアドレスからユーザ名を得るクラス                |
| pagemaker | HtmlWriter | HTML ファイルを作成するクラス                         |
| pagemaker | PageMaker  | メールアドレスからユーザの Web ページを作成するクラス |
| ...       | Main       | ...                                                   |

- テーマ：ユーザの Web ページを作成する

### Python

- テーマ：コンピュータを操作するためのインターフェースを提供する ComputerFacade クラス
  - このクラスは、CPU、メモリ、ハードドライブなどのサブシステムを操作し、ユーザーが操作しやすい単一のメソッドを提供する
    - サブシステム：CPU、Memory、HardDrive クラス
  - ComputerFacade クラスは、これらのサブシステムをラップし、start_computer()メソッドを提供する

## Usage/Tips/Pros and Cons

- Facade のやっていること
  - 複雑なものを単純に見せる
    - 複雑なもの：裏方で動いているたくさんのクラス
    - 単純に見せる：インタフェースを少なくすること
- インタフェースが少ない
  - 外部との結合が疎であることを意味する
    - 部品としての再利用性が高まる
- 再帰的な Facade の適用
  - Facade 役を持ったクラスの集合が複数あるときに、それらの集合をまとめた Facade 役を作る
  - 多数のクラス、多数のパッケージを抱える巨大なシステムでは、要所要所に FacadePattern を適用することでソフトウェア品質を高められる

## Related Patterns

- [Abstract Factory Pattern](../08-abstract-factory-pattern/)
  - オブジェクトを生成するにはこれを呼べば OK というインタフェースを提供しているので、オブジェクト生成という点で Facade Pattern を使っているとみなせる
- [Singleton Pattern](../05-singleton-pattern/)
  - Facade 役は Singleton Pattern で作られる場合がある
- [Mediator Pattern](../16-mediator-pattern/)
  - Facade は一方的(`一方向`)に他の役を利用して高レベルかつシンプルなインタフェースを提供する
  - Mediator は Colleague 役の仲介者としてやり取りを行う →`一方向`ではなく`双方向`
