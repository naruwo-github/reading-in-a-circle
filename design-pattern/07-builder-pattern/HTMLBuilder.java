import java.io.FileWriter;
import java.io.Writer;

public class HTMLBuilder extends Builder {
    private String filename = "./untitled.html";
    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void makeTitle(String title) {
        filename = "./" + title + ".html";
        this.stringBuilder.append("<html>\n");
        this.stringBuilder.append("<body>\n");
        this.stringBuilder.append("<h1>");
        this.stringBuilder.append(title);
        this.stringBuilder.append("</h1>\n");
    }

    @Override
    public void makeString(String str) {
        this.stringBuilder.append("<p>");
        this.stringBuilder.append(str);
        this.stringBuilder.append("</p>\n");
    }

    @Override
    public void makeItems(String[] items) {
        this.stringBuilder.append("<ul>\n");
        for (String item : items) {
            this.stringBuilder.append("<li>");
            this.stringBuilder.append(item);
            this.stringBuilder.append("</li>\n");
        }
        this.stringBuilder.append("</ul>\n");
    }

    @Override
    public void close() {
        this.stringBuilder.append("</body>\n");
        this.stringBuilder.append("</html>\n");
        try {
            Writer fileWriter = new FileWriter(this.filename);
            fileWriter.write(stringBuilder.toString());
            fileWriter.close();
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public String getHTMLResult() {
        return this.filename;
    }
}