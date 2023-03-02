/*
このコードでは、Target 抽象クラスがターゲットインターフェースを定義し、Adapteeクラスがアダプティークラス（既存のクラス）を定義しています。
Adapter クラスがアダプタークラスを定義し、Target インターフェースを実装します。
アダプタークラスのコンストラクタで、アダプティークラスのインスタンスを受け取ります。
Adapter クラスの request() メソッドが呼ばれた場合、アダプティークラスの specificRequest() メソッドを呼び出します。
最後に、Adaptee クラスの specificRequest() メソッドが呼ばれることを確認するために、Adapter クラスのインスタンスを作成し、request() メソッドを呼び出します。
*/

abstract class Target {
  void request();
}

class Adaptee {
  void specificRequest() {
    print('アダプティーのメソッドが呼ばれました。');
  }
}

class Adapter implements Target {
  Adaptee _adaptee;

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
