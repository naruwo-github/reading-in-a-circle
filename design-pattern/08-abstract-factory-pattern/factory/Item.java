package factory;

public abstract class Item implements HTMLable {
    // Link, Trayのスーパークラス

    protected String caption;

    public Item(String caption) {
        this.caption = caption;
    }
}