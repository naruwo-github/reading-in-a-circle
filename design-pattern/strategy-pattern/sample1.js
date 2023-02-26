class Strategy {
  calculate(a, b){}
}

// addition
class Addition extends Strategy {
  calculate(a, b) {
    return a + b
  }
}

// subtraction
// class Subtraction extends Strategy...

// multiplication
// ...

// division
// ...

// context
class Context {
  constructor(strategy) {
    this.strategy = strategy
  }

  calculate(a, b) {
    return this.strategy.calculate(a, b)
  }
}
