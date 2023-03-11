package factory;

public abstract class Item {
    // Link, Trayのスーパークラス

    protected String caption;

    public Item(String caption) {
        this.caption = caption;
    }

    // HTMLの文字列を戻り値となるようサブクラスで実装する
    public abstract String makeHTML();
}