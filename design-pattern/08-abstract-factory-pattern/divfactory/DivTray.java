package divFactory;

import factory.Item;
import factory.Tray;

public class DivTray extends Tray {
    public DivTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<p><b>" + this.caption + "</b></p>\n");

        stringBuilder.append("<div class=\"TRAY\">");
        for (Item item : this.getTray()) {
            stringBuilder.append(item.makeHTML());
        }
        stringBuilder.append("</div>\n");

        return stringBuilder.toString();
    }
}