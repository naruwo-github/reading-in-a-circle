interface LightSwitchState {
	on(sw: LightSwitch): void;
	off(sw: LightSwitch): void;
}

class LightOnState implements LightSwitchState {
	public on(sw: LightSwitch): void {
		console.log("Light is already on.");
	}

	public off(sw: LightSwitch): void {
		sw.setState(new LightOffState());
		console.log("Turning light off.");
	}
}

class LightOffState implements LightSwitchState {
	public on(sw: LightSwitch): void {
		sw.setState(new LightOnState());
		console.log("Turning light on.");
	}

	public off(sw: LightSwitch): void {
		console.log("Light is already off.");
	}
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
		this.state.on(this);
	}

	public turnOff() {
		this.state.off(this);
	}
}

const lightSwitch = new LightSwitch();
lightSwitch.turnOn();
lightSwitch.turnOff();
lightSwitch.turnOff();
lightSwitch.turnOn();
lightSwitch.turnOn();
lightSwitch.turnOff();
