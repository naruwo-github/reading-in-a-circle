public class TextBuilder extends Builder {
    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void makeTitle(String title) {
        this.stringBuilder.append("======\n");
        this.stringBuilder.append(title + "\n");
        this.stringBuilder.append("======\n");
        this.stringBuilder.append("\n");
    }

    @Override
    public void makeString(String str) {
        this.stringBuilder.append("***");
        this.stringBuilder.append(str);
        this.stringBuilder.append("***\n");
        this.stringBuilder.append("\n");
    }

    @Override
    public void makeItems(String[] items) {
        for (String item : items) {
            this.stringBuilder.append("^ ");
            this.stringBuilder.append(item);
            this.stringBuilder.append("\n");
        }
        this.stringBuilder.append("\n");
    }

    @Override
    public void close() {
        this.stringBuilder.append("---end---\n");
    }

    public String getTextResult() {
        return this.stringBuilder.toString();
    }
}