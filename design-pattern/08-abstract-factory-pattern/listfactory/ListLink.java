package listFactory;

import factory.Link;

public class ListLink extends Link {
    public ListLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return "<li><a href=\"" + this.url + "\">" + this.caption + "</a></li>\n";
    }

}