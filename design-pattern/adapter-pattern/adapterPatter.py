class Target:
    """
    ターゲットインターフェース(抽象)
    """

    def request(self):
        pass


class Adapted:
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

    def __init__(self, adapted: Adapted):
        # コンストラクタで、既存クラスのインスタンスを受け取る
        self.adapted = adapted

    def request(self):
        self.adapted.specific_request()


if __name__ == '__main__':
    adapted = Adapted()
    adapter = Adapter(adapted)
    adapter.request()
