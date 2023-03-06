interface DirectCurrent {
  // 直流12V
  request(): void;
}

class AlternatingCurrent {
  // 交流100V
  specificRequest(): void {
    console.log("コンセントから交流100Vを提供する。");
  }
}
class ACAdapter implements DirectCurrent {
  // ACアダプター
  private adaptee: AlternatingCurrent;

  constructor(adaptee: AlternatingCurrent) {
    this.adaptee = adaptee;
  }

  request(): void {
    this.adaptee.specificRequest();
    console.log('交流100Vを直流12Vに変換する。')
  }
}

const adaptee = new AlternatingCurrent();
const adapter = new ACAdapter(adaptee);
adapter.request();
