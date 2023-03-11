package listfactory;

import factory.Tray;
import factory.Item;

public class ListTray extends Tray {
    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<li>\n");
        sb.append(this.caption + "\n");
        sb.append("<ul>\n");
        for (Item item : this.tray) {
            // ListLink, ListTrayはどちらもItemクラスのサブクラス
            // なので中身を気にせずmakeHTMLを呼び出せる
            sb.append(item.makeHTML());
        }
        sb.append("</ul>\n");
        sb.append("</li>\n");
        return sb.toString();
    }
}