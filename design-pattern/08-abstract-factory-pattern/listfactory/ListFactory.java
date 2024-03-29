package listFactory;

import factory.Factory;
import factory.Link;
import factory.Page;
import factory.Tray;

public class ListFactory extends Factory {

    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String caption, String author) {
        return new ListPage(caption, author);
    }

}