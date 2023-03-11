import java.io.FileWriter;
import java.io.Writer;

public class HTMLBuilder extends Builder {
    private String filename = "./untitled.html";
    private StringBuilder sb = new StringBuilder();

    @Override
    public void makeTitle(String title) {
        filename = "./" + title + ".html";
        this.sb.append("<html>\n");
        this.sb.append("<body>\n");
        this.sb.append("<h1>");
        this.sb.append(title);
        this.sb.append("</h1>\n");
    }

    @Override
    public void makeString(String str) {
        this.sb.append("<p>");
        this.sb.append(str);
        this.sb.append("</p>\n");
    }

    @Override
    public void makeItems(String[] items) {
        this.sb.append("<ul>\n");
        for (String s : items) {
            this.sb.append("<li>");
            this.sb.append(s);
            this.sb.append("</li>\n");
        }
        this.sb.append("</ul>\n");
    }

    @Override
    public void close() {
        this.sb.append("</body>\n");
        this.sb.append("</html>\n");
        try {
            Writer writer = new FileWriter(this.filename);
            writer.write(sb.toString());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getHTMLResult() {
        return this.filename;
    }
}