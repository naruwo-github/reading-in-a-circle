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
class _Add implements Expression {
	constructor(private left: Expression, private right: Expression) {}

	interpret(): number {
		return this.left.interpret() + this.right.interpret();
	}
}

class _Subtract implements Expression {
	constructor(private left: Expression, private right: Expression) {}

	interpret(): number {
		return this.left.interpret() - this.right.interpret();
	}
}

class _Multiply implements Expression {
	constructor(private left: Expression, private right: Expression) {}

	interpret(): number {
		return this.left.interpret() * this.right.interpret();
	}
}

class _Divide implements Expression {
	constructor(private left: Expression, private right: Expression) {}

	interpret(): number {
		return this.left.interpret() / this.right.interpret();
	}
}

const expression: Expression = new _Add(
	new _Number(3),
	new _Multiply(new _Number(2), new _Number(4))
);

console.log(`Result: ${expression.interpret()}`);
