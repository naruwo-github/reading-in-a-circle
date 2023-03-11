package factory;

import java.util.List;
import java.util.ArrayList;

public abstract class Tray extends Item {
    private List<Item> tray = new ArrayList<>();

    public Tray(String caption) {
        super(caption);
    }

    public void add(Item item) {
        tray.add(item);
    }

    public List<Item> getTray() {
        return this.tray;
    }

    // 一見抽象メソッドを持ってないが、
    // スーパークラスの抽象メソッドmakeHTMLを実装してないので、
    // このクラスも抽象クラスである
}