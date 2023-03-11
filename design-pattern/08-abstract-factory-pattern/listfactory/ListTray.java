package listFactory;

import factory.Tray;
import factory.Item;

public class ListTray extends Tray {
    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<li>\n");
        stringBuilder.append(this.caption + "\n");
        stringBuilder.append("<ul>\n");
        for (Item item : this.getTray()) {
            // ListLink, ListTrayはどちらもItemクラスのサブクラス
            // なので中身を気にせずmakeHTMLを呼び出せる
            stringBuilder.append(item.makeHTML());
        }
        stringBuilder.append("</ul>\n");
        stringBuilder.append("</li>\n");
        return stringBuilder.toString();
    }
}