public class SideBorder extends Border {
    private char borderChar; // 飾り文字

    public SideBorder(Display display, char ch) {
        // 中身となるDisplayと飾り文字を指定
        super(display);
        this.borderChar = ch;
    }

    @Override
    public int getColumns() {
        // 文字数は中身の両側に飾り文字分を加えたもの
        return 1 + this.display.getColumns() + 1;
    }

    @Override
    public int getRows() {
        // 行数は中身の行数に同じ
        return this.display.getRows();
    }

    @Override
    public String getRowText(int row) {
        // 指定行の内容は、中身の指定行の両側に飾り文字をつけたもの
        return this.borderChar + this.display.getRowText(row) + this.borderChar;
    }
}