public class TextBuilder extends Builder {
    private StringBuilder sb = new StringBuilder();

    @Override
    public void makeTitle(String title) {
        this.sb.append("======\n");
        this.sb.append(title + "\n");
        this.sb.append("======\n");
        this.sb.append("\n");
    }

    @Override
    public void makeString(String str) {
        this.sb.append("***");
        this.sb.append(str);
        this.sb.append("***\n");
        this.sb.append("\n");
    }

    @Override
    public void makeItems(String[] items) {
        for (String s : items) {
            this.sb.append("^ ");
            this.sb.append(s);
            this.sb.append("\n");
        }
        this.sb.append("\n");
    }

    @Override
    public void close() {
        this.sb.append("---end---\n");
    }

    public String getTextResult() {
        return this.sb.toString();
    }
}