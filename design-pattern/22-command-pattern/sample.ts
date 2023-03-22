interface Command {
	execute(): void;
}

class ConcreteCommandA implements Command {
	constructor(private receiver: Receiver) {}

	execute(): void {
		this.receiver.actionA();
	}
}

class ConcreteCommandB implements Command {
	constructor(private receiver: Receiver) {}

	execute(): void {
		this.receiver.actionB();
	}
}

class Receiver {
	actionA(): void {
		console.log("Action A is executed.");
	}

	actionB(): void {
		console.log("Action B is executed.");
	}
}

class Invoker {
	private command: Command | null = null;

	setCommand(command: Command): void {
		this.command = command;
	}

	executeCommand(): void {
		if (this.command) {
			this.command.execute();
		} else {
			console.log("No command is set.");
		}
	}
}

const receiver = new Receiver();
const commandA = new ConcreteCommandA(receiver);
const commandB = new ConcreteCommandB(receiver);
const invoker = new Invoker();

invoker.setCommand(commandA);
invoker.executeCommand();

invoker.setCommand(commandB);
invoker.executeCommand();
