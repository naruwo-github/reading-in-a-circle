"""
このコードでは、Targetクラスがターゲットインターフェースを定義し、Adapteeクラスがアダプティークラス（既存のクラス）を定義しています。
Adapter クラスがアダプタークラスを定義し、Target インターフェースを実装します。
アダプタークラスのコンストラクタで、アダプティークラスのインスタンスを受け取ります。
Adapter クラスの request() メソッドが呼ばれた場合、アダプティークラスの specific_request() メソッドを呼び出します。
最後に、Adaptee クラスの specific_request() メソッドが呼ばれることを確認するために、Adapter クラスのインスタンスを作成し、request() メソッドを呼び出します。
"""


class Target:
    """
    ターゲットインターフェース
    """

    def request(self):
        pass


class Adaptee:
    """
    アダプティークラス（既存のクラス）
    """

    def specific_request(self):
        print("アダプティーのメソッドが呼ばれました。")


class Adapter(Target):
    """
    アダプタークラス
    """

    def __init__(self, adaptee: Adaptee):
        self.adaptee = adaptee

    def request(self):
        self.adaptee.specific_request()


if __name__ == '__main__':
    adaptee = Adaptee()
    adapter = Adapter(adaptee)
    adapter.request()
