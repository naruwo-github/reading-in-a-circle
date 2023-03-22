interface Subject {
	request(): void;
}

class RealSubject implements Subject {
	request(): void {
		console.log("RealSubject: Handling request.");
	}
}

class _Proxy implements Subject {
	private realSubject: RealSubject;

	constructor(realSubject: RealSubject) {
		this.realSubject = realSubject;
	}

	request(): void {
		if (this.checkAccess()) {
			this.realSubject.request();
			this.logAccess();
		}
	}

	private checkAccess(): boolean {
		console.log("Proxy: Checking access prior to firing a real request.");
		return true;
	}

	private logAccess(): void {
		console.log("Proxy: Logging the time of request.");
	}
}

function clientCode(subject: Subject) {
	subject.request();
}

const realSubject = new RealSubject();
const proxy = new _Proxy(realSubject);

console.log("Client: Executing the client code with a real subject:");
clientCode(realSubject);

console.log("");

console.log("Client: Executing the same client code with a proxy:");
clientCode(proxy);
