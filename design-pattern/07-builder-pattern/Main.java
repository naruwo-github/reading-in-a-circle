public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            usage();
            System.exit(0);
        }
        if (args[0].equals("text")) {
            TextBuilder textBuilder = new TextBuilder();
            Director director = new Director(textBuilder);
            director.construct();
            System.out.println(textBuilder.getTextResult());
            return;
        }
        if (args[0].equals("html")) {
            HTMLBuilder htmlBuilder = new HTMLBuilder();
            Director director = new Director(htmlBuilder);
            director.construct();
            System.out.println(htmlBuilder.getHTMLResult());
            return;
        }
        usage();
        System.exit(0);
    }

    public static void usage() {
        System.out.println("java Main text -> テキストで文書作成");
        System.out.println("java Main html -> HTMLで文書作成");
    }
}