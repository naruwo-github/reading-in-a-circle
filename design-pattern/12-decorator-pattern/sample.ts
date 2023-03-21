interface TextComponent {
	getText(): string;
}

class TextLabel implements TextComponent {
	readonly text: string;

	constructor(text: string) {
		this.text = text;
	}

	getText(): string {
		return this.text;
	}
}

class TextDecorator implements TextComponent {
	readonly textComponent: TextComponent;

	constructor(textComponent: TextComponent) {
		this.textComponent = textComponent;
	}

	getText(): string {
		return this.textComponent.getText();
	}
}

class BoldDecorator extends TextDecorator {
	constructor(textComponent: TextComponent) {
		super(textComponent);
	}

	getText(): string {
		const text = this.textComponent.getText();
		return `<b>${text}</b>`;
	}
}

class UnderlineDecorator extends TextDecorator {
	constructor(textComponent: TextComponent) {
		super(textComponent);
	}

	getText(): string {
		const text = this.textComponent.getText();
		return `<u>${text}</u>`;
	}
}

const main = () => {
	const text = "Hello, World!";
	const baseLabel = new TextLabel(text);

	const boldLabel = new BoldDecorator(baseLabel);
	console.log(boldLabel.getText());

	const underlineLabel = new UnderlineDecorator(baseLabel);
	console.log(underlineLabel.getText());

	const boldUnderlineLabel = new BoldDecorator(
		new UnderlineDecorator(baseLabel)
	);
	console.log(boldUnderlineLabel.getText());
};

main();
