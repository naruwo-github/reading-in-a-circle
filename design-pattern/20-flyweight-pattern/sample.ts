interface Flyweight {
	operation(extrinsicState: number): void;
}

class ConcreteFlyweight implements Flyweight {
	private intrinsicState: number;

	constructor(intrinsicState: number) {
		this.intrinsicState = intrinsicState;
	}

	public operation(extrinsicState: number): void {
		console.log(
			`ConcreteFlyweight: Intrinsic State = ${this.intrinsicState}, Extrinsic State = ${extrinsicState}`
		);
	}
}

class FlyweightFactory {
	private flyweights: { [key: string]: Flyweight } = {};

	constructor() {
		this.flyweights["A"] = new ConcreteFlyweight(1);
		this.flyweights["B"] = new ConcreteFlyweight(2);
		this.flyweights["C"] = new ConcreteFlyweight(3);
	}

	public getFlyweight(key: string): Flyweight {
		if (!(key in this.flyweights)) {
			console.log("FlyweightFactory: Creating a new Flyweight");
			this.flyweights[key] = new ConcreteFlyweight(
				Math.floor(Math.random() * 5) + 1
			);
		} else {
			console.log("FlyweightFactory: Reusing existing Flyweight");
		}

		return this.flyweights[key];
	}

	public listFlyweights(): void {
		const count = Object.keys(this.flyweights).length;
		console.log(`FlyweightFactory: I have ${count} Flyweights:`);

		for (const key in this.flyweights) {
			console.log(key);
		}
	}
}

const clientCode = (): void => {
	const factory = new FlyweightFactory();

	factory.listFlyweights();

	const flyweightA = factory.getFlyweight("A");
	flyweightA.operation(1);

	const flyweightB = factory.getFlyweight("B");
	flyweightB.operation(2);

	const flyweightC = factory.getFlyweight("C");
	flyweightC.operation(3);

	const flyweightD = factory.getFlyweight("D");
	flyweightD.operation(4);

	const flyweightE = factory.getFlyweight("E");
	flyweightE.operation(5);

	factory.listFlyweights();
};

clientCode();
