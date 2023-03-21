class TextComponent:
    # テキスト出力のインターフェース
    def getText(self):
        pass


class TextLabel(TextComponent):
    # テキスト出力の基本実装
    def __init__(self, text):
        self._text = text

    def getText(self):
        return self._text


class TextDecorator(TextComponent):
    # テキスト出力を装飾するデコレーターのインターフェース
    def __init__(self, textComponent):
        self._textComponent = textComponent

    def getText(self):
        return self._textComponent.getText()


class BoldDecorator(TextDecorator):
    def __init__(self, textComponent):
        super().__init__(textComponent)

    def getText(self):
        text = super().getText()
        return f"<b>{text}</b>"


class UnderlineDecorator(TextDecorator):
    def __init__(self, textComponent):
        super().__init__(textComponent)

    def getText(self):
        text = super().getText()
        return f"<u>{text}</u>"


def main():
    text = "Hello, World!"

    baseLabel = TextLabel(text)

    boldLabel = BoldDecorator(baseLabel)
    print(boldLabel.getText())  # <b>Hello, World!</b>

    underlineLabel = UnderlineDecorator(baseLabel)
    print(underlineLabel.getText())  # <u>Hello, World!</u>

    boldUnderlineLabel = BoldDecorator(UnderlineDecorator(baseLabel))
    print(boldUnderlineLabel.getText())  # <b><u>Hello, World!</u></b>


if __name__ == '__main__':
    main()
