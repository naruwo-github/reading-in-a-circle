`
このコードでは、Target インターフェースがターゲットインターフェースを定義し、Adapteeクラスがアダプティークラス（既存のクラス）を定義しています。
Adapter クラスがアダプタークラスを定義し、Target インターフェースを実装します。
アダプタークラスのコンストラクタで、アダプティークラスのインスタンスを受け取ります。
Adapter クラスの request() メソッドが呼ばれた場合、アダプティークラスの specificRequest() メソッドを呼び出します。
最後に、Adaptee クラスの specificRequest() メソッドが呼ばれることを確認するために、Adapter クラスのインスタンスを作成し、request() メソッドを呼び出します。
このコードを実行すると、以下のように出力されます。
`

interface Target {
    request(): void;
  }
  
  class Adaptee {
    specificRequest(): void {
      console.log("アダプティーのメソッドが呼ばれました。");
    }
  }
  
  class Adapter implements Target {
    private adaptee: Adaptee;
  
    constructor(adaptee: Adaptee) {
      this.adaptee = adaptee;
    }
  
    request(): void {
      this.adaptee.specificRequest();
    }
  }
  
  const adaptee = new Adaptee();
  const adapter = new Adapter(adaptee);
  adapter.request();
  