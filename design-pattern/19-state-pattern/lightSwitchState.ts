interface LightSwitchState {
	on(): void;
	off(): void;
}
class LightSwitch {
	private state: LightSwitchState;

	constructor() {
		this.state = new LightOffState();
	}

	public setState(state: LightSwitchState) {
		console.log(`LightSwitch: Transition to ${(<any>state).constructor.name}.`);
		this.state = state;
	}

	public turnOn() {
		this.state.on();
	}

	public turnOff() {
		this.state.off();
	}
}

class LightOnState implements LightSwitchState {
	public on(): void {
		console.log("Light is already on.");
	}

	public off(): void {
		console.log("Turning light off.");
	}
}

class LightOffState implements LightSwitchState {
	public on(): void {
		console.log("Turning light on.");
	}

	public off(): void {
		console.log("Light is already off.");
	}
}

const lightSwitch = new LightSwitch();
lightSwitch.turnOn();
lightSwitch.turnOff();
lightSwitch.turnOff();
lightSwitch.turnOn();
lightSwitch.turnOn();
lightSwitch.turnOff();
