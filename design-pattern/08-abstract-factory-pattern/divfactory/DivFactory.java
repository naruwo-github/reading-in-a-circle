package divFactory;

import factory.Factory;
import factory.Link;
import factory.Page;
import factory.Tray;

public class DivFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new DivLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new DivTray(caption);
    }

    @Override
    public Page createPage(String caption, String author) {
        return new DivPage(caption, author);
    }
}