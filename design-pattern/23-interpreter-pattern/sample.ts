interface Expression {
	interpret(): number;
}

// TerminalExpressionクラス
class _Number implements Expression {
	constructor(private value: number) {}

	interpret(): number {
		return this.value;
	}
}

// NonTerminalExpressionクラス
class Add implements Expression {
	constructor(private left: Expression, private right: Expression) {}

	interpret(): number {
		return this.left.interpret() + this.right.interpret();
	}
}

class Subtract implements Expression {
	constructor(private left: Expression, private right: Expression) {}

	interpret(): number {
		return this.left.interpret() - this.right.interpret();
	}
}

class Multiply implements Expression {
	constructor(private left: Expression, private right: Expression) {}

	interpret(): number {
		return this.left.interpret() * this.right.interpret();
	}
}

class Divide implements Expression {
	constructor(private left: Expression, private right: Expression) {}

	interpret(): number {
		return this.left.interpret() / this.right.interpret();
	}
}

// クライアント
const expression: Expression = new Add(
	new _Number(3),
	new Multiply(new _Number(2), new _Number(4))
);

console.log(`Result: ${expression.interpret()}`); // Result: 11
