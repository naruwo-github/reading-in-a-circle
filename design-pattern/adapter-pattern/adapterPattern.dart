abstract class Target {
  // ターゲットインタフェース(抽象)
  void request();
}

class Adaptee {
  // 既存クラス(具象)
  void specificRequest() {
    print('既存クラスのメソッドが呼ばれました。');
  }
}

class Adapter implements Target {
  // アダプタークラス(具象)
  // Targetインタフェースを実装する
  late Adaptee _adaptee;

  Adapter(Adaptee adaptee) {
    _adaptee = adaptee;
  }

  @override
  void request() {
    _adaptee.specificRequest();
  }
}

void main() {
  var adaptee = Adaptee();
  var adapter = Adapter(adaptee);
  adapter.request();
}
