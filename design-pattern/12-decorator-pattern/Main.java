public class Main {
    public static void main(String[] args) {
        Display b1 = new StringDisplay("Hello, world.");
        b1.show();

        Display b2 = new SideBorder(b1, '#');
        b2.show();

        Display b3 = new FullBorder(b2);
        b3.show();

        Display b4 = new SideBorder(
                new FullBorder(
                        new FullBorder(
                                new SideBorder(
                                        new FullBorder(
                                                new StringDisplay("Hello, world.")),
                                        '*'))),
                '/');
        b4.show();
    }
}