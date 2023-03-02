abstract class Target {
  // ターゲットインタフェース(抽象)
  void request();
}

class Adapted {
  // 既存クラス(具象)
  void specificRequest() {
    print('既存クラスのメソッドが呼ばれました。');
  }
}

class Adapter implements Target {
  // アダプタークラス(具象)
  // Targetインタフェースを実装する
  late Adapted _adapted;

  Adapter(Adapted adapted) {
    _adapted = adapted;
  }

  @override
  void request() {
    _adapted.specificRequest();
  }
}

void main() {
  var adapted = Adapted();
  var adapter = Adapter(adapted);
  adapter.request();
}
