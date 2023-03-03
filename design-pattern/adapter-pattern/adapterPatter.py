class Target:
    """
    ターゲットインターフェース(抽象)
    """

    def request(self):
        pass


class Adaptee:
    """
    既存クラス(具象)
    """

    def specific_request(self):
        print("既存クラスのメソッドが呼ばれました。")


class Adapter(Target):
    """
    アダプタークラス(具象)
    Targetインタフェースを実装する
    """

    def __init__(self, adaptee: Adaptee):
        # コンストラクタで、既存クラスのインスタンスを受け取る
        self.adaptee = adaptee

    def request(self):
        self.adaptee.specific_request()


if __name__ == '__main__':
    adaptee = Adaptee()
    adapter = Adapter(adaptee)
    adapter.request()
