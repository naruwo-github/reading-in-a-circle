package divFactory;

import factory.Item;
import factory.Page;

public class DivPage extends Page {
    public DivPage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html><head><title>" + this.title + "</title>\n");
        stringBuilder.append("<style>\n");
        stringBuilder.append("div.TRAY { padding:0.5em; margin-left:5em; border:1px solid black; }\n");
        stringBuilder.append("div.LINK { padding:0.5em; background-color: lightgray; }\n");
        stringBuilder.append("</style>\n");
        stringBuilder.append("</head><body>\n");
        stringBuilder.append("<h1>" + this.title + "</h1>\n");
        for (Item item : this.itemList) {
            stringBuilder.append(item.makeHTML());
        }
        stringBuilder.append("<hr><address>" + this.author + "</address>\n");
        stringBuilder.append("</body></html>\n");
        return stringBuilder.toString();
    }
}