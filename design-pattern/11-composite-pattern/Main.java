public class Main {
    public static void main(String[] args) {
        Directory rootDirectory = new Directory("root");
        Directory binDirectory = new Directory("bin");
        Directory tmpDirectory = new Directory("tmp");
        Directory usrDirectory = new Directory("usr");

        rootDirectory.add(binDirectory);
        rootDirectory.add(tmpDirectory);
        rootDirectory.add(usrDirectory);

        binDirectory.add(new File("vi", 10000));
        binDirectory.add(new File("latex", 20000));

        rootDirectory.printList();
        System.out.println();

        Directory yuki = new Directory("yuki");
        Directory hanako = new Directory("hanako");
        Directory tomura = new Directory("tomura");
        usrDirectory.add(yuki);
        usrDirectory.add(hanako);
        usrDirectory.add(tomura);
        yuki.add(new File("diary.html", 100));
        yuki.add(new File("Composite.java", 200));
        hanako.add(new File("memo.tex", 300));
        tomura.add(new File("game.doc", 400));
        tomura.add(new File("junk.mail", 500));
        rootDirectory.printList();
    }
}