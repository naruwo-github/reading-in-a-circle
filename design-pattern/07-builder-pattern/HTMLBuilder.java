import java.io.FileWriter;
import java.io.Writer;

public class HTMLBuilder extends Builder {
    private String filename = "untitled.html";
    private StringBuilder sb = new StringBuilder();

    @Override
    public void makeTitle(String title) {
        filename = title + ".html";
        this.sb.append("<html>");
        this.sb.append("<body>");
        this.sb.append("<h1>");
        this.sb.append(title);
        this.sb.append("</h1>");
    }

    @Override
    public void makeString(String str) {
        this.sb.append("<p>");
        this.sb.append(str);
        this.sb.append("</p>");
    }

    @Override
    public void makeItems(String[] items) {
        this.sb.append("<ul>");
        for (String s : items) {
            this.sb.append("<li>");
            this.sb.append(s);
            this.sb.append("</li>");
        }
        this.sb.append("</ul>");
    }

    @Override
    public void close() {
        this.sb.append("</body>");
        this.sb.append("</html>");
        try {
            Writer writer = new FileWriter(filename);
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