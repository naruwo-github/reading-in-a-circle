package listFactory;

import factory.Page;
import factory.Item;

public class ListPage extends Page {
    public ListPage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html><head><title>" + this.title + "</title></head>\n<body>\n");
        stringBuilder.append("<h1>" + this.title + "</h1>\n");

        stringBuilder.append("<ul>\n");
        for (Item item : this.itemList) {
            stringBuilder.append(item.makeHTML());
        }
        stringBuilder.append("</ul>\n");

        stringBuilder.append("<hr><address>" + this.author + "</address>\n");
        stringBuilder.append("</body></html>\n");
        return stringBuilder.toString();
    }
}