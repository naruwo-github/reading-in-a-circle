class TextComponent:
    # テキスト出力の基本インターフェース
    def getText(self):
        pass


class TextLabel(TextComponent):
    # テキスト出力の具体的な実装
    def __init__(self, text):
        self._text = text

    def getText(self):
        return self._text


class TextDecorator(TextComponent):
    # テキスト出力を装飾するデコレーターの基本インターフェース
    def __init__(self, textComponent):
        self._textComponent = textComponent

    def getText(self):
        return self._textComponent.getText()


class BoldDecorator(TextDecorator):
    # テキストを太字にするデコレーター
    def __init__(self, textComponent):
        super().__init__(textComponent)

    def getText(self):
        text = super().getText()
        return f"<b>{text}</b>"


class UnderlineDecorator(TextDecorator):
    # テキストを下線付きにするデコレーター
    def __init__(self, textComponent):
        super().__init__(textComponent)

    def getText(self):
        text = super().getText()
        return f"<u>{text}</u>"


def main():
    text = "Hello, World!"

    # ベースのテキスト出力を作成
    label = TextLabel(text)

    # テキストを太字にする
    boldLabel = BoldDecorator(label)
    print(boldLabel.getText())  # <b>Hello, World!</b>

    # テキストを下線付きにする
    underlineLabel = UnderlineDecorator(label)
    print(underlineLabel.getText())  # <u>Hello, World!</u>

    # テキストを太字かつ下線付きにする
    boldUnderlineLabel = BoldDecorator(UnderlineDecorator(label))
    print(boldUnderlineLabel.getText())  # <b><u>Hello, World!</u></b>


if __name__ == '__main__':
    main()
