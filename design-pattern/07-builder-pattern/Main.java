public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            usage();
            System.exit(0);
        }
        if (args[0].equals("text")) {
            TextBuilder textbuilder = new TextBuilder();
            Director director = new Director(textbuilder);
            director.construct();
            System.out.println(textbuilder.getTextResult());
            return;
        }
        if (args[0].equals("html")) {
            HTMLBuilder htmlbuilder = new HTMLBuilder();
            Director director = new Director(htmlbuilder);
            director.construct();
            System.out.println(htmlbuilder.getHTMLResult());
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