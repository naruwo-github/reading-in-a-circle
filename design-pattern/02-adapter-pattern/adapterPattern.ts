interface Target {
  request(): void;
}

class Adaptee {
  specificRequest(): void {
    console.log("既存クラスのメソッドが呼ばれました。");
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
