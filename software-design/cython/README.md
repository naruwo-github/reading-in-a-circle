# Learning Cython
CythonはPythonのプログラムをC/C++に変換して処理を高速化するプログラム。
Pythonはライブラリが豊富で便利だが、処理の遅さゆえ使用箇所を選ぶ。

## Weak points of Python
インタプリタ言語の中でも特に処理が遅い。
メモリ消費も多く、メモリ不足になることも多々。
大量のデータを高速に処理するような実用的な場面では、ライブラリが対応している場合を除き、「実用できない」と判断されがちな言語である。

## Reference
- [Cython 公式ドキュメント](https://cython.readthedocs.io/en/latest/)

## Tutorial1
- Cythonのインストール: `pip install Cython`
    - Cythonファイルの拡張子は.pyx: `<file name>.pyx`
    - 今回実験対象とするファイルは`summation.py/pyx`の2つである。
        - どちらも処理内容は同じで、1から1億までの総和を計算する関数を定義している。
        - 定義した関数は`main.py`内で呼び出す。この時、`main.py`内では関数呼び出し前後の時間計測を行う。
- compile.pyを実行することで対象ファイルをコンパイ可能: `python3 compile.py build_ext --inplace`
    - 対象ファイルは`compile.py`内にハードコーディングしている。
    - コンパイル後、`.c`, `.so`の2つのファイルが生成される。
- 実行時間の比較
    - コンパイル前後で`main.py`を実行することで確認できる。
- wip
