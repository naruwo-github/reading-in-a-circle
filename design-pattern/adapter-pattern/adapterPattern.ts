interface Target {
    request(): void;
  }
  
  class Adapted {
    specificRequest(): void {
      console.log("既存クラスのメソッドが呼ばれました。");
    }
  }
  
  class Adapter implements Target {
    private adapted: Adapted;
  
    constructor(adapted: Adapted) {
      this.adapted = adapted;
    }
  
    request(): void {
      this.adapted.specificRequest();
    }
  }
  
  const adapted = new Adapted();
  const adapter = new Adapter(adapted);
  adapter.request();
  