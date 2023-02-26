class PayStrategy {
  pay(price){}
}

// master
class MasterCard extends PayStrategy {
  pay(price) {
    // ...
  }
}

// visa
// ...

// paypal
// ...

// pay manager
class PayManager {
  constructor(payStrategy) {
    this.payStrategy = payStrategy
  }
}

// public func
export const pay = (payMethod, amount) => {
  let payManager
  switch(payMethod) {
    case 'MasterCard':
      payManager = new PayManager(new MasterCard())
      break
    case 'Visa':
      payManager = new PayManager(new Visa())
      break
    case 'PayPal':
      payManager = new PayManager(new PayPal())
      break
    default:
      // unexpected
  }
  payManager.pay(amount)
}
