package listfactory;

import factory.Page;
import factory.Item;

public class ListPage extends Page {
    public ListPage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><title>" + this.title + "</title></head>\n<body>\n");
        sb.append("<h1>" + this.title + "</h1>\n");

        sb.append("<ul>\n");
        for (Item item : this.content) {
            sb.append(item.makeHTML());
        }
        sb.append("</ul>\n");

        sb.append("<hr><address>" + this.author + "</address>\n");
        sb.append("</body></html>\n");
        return sb.toString();
    }
}