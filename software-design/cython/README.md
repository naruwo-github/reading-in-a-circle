# Cythonを学ぶ
CythonはPythonのプログラムをC/C++に変換して処理を高速化するプログラム。
Pythonはライブラリが豊富で便利だが、処理の遅さゆえ使用箇所を選ぶ。

## Pythonのデメリット
インタプリタ言語の中でも特に処理が遅い。
メモリ消費も多く、メモリ不足になることも多々。
大量のデータを高速に処理するような実用的な場面では、ライブラリが対応している場合を除き、「実用できない」と判断されがちな言語である。

## Cythonの使い方
- Pythonコードを書く。モジュール（クラスや関数など）を定義する。
    - C言語の型を用いて静的型付けが可能（これをするとコンパイル後にかなり早くなる）。
- Cythonでコンパイルし、C/C++に変換する。
- モジュールを読み込み、活用する。

## 実践
- Install Cython: `pip install Cython`
    - Cythonファイルの拡張子は.pyx
- Compile Python codes
    - compile.pyを実行することで対象ファイルをコンパイ可能: `python3 compile.py build_ext --inplace`
        - 対象ファイルは`compile.py`にハードコーディングしている。
        - コンパイルによって`.c`, `.so`の2ファイル作られる。
- Target functions
    - 今回実験対象とする処理内容は、1から1億までの総和を計算する処理で、それを示す関数を下記に定義している。
        - `summation.py`: 関数`summation`が定義されている。
        - `summation.pyx`: `summation`が定義されている。この関数はコンパイル対象となる。
        - `summationWithStaticType.pyx`: `summationWithStaticType`が定義されている。この関数はコンパイル対象となる。
        - 定義した関数は、関数呼び出し前後の時間計測とともに`main.py`, `mainWithStaticType.py`内で実行する。
- Evaluation
    - 実行時間の比較をしてみよう！
        - およそ、、、`summation`は1.5倍、`summationWithStaticType`は100倍以上高速化できているはず!(※実行環境に依存します。)

## 参考文献
- [Cython 公式ドキュメント](https://cython.readthedocs.io/en/latest/)
- [Software Design 2022年12月号](https://gihyo.jp/magazine/SD/archive/2022/202212)
