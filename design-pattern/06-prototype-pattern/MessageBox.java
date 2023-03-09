import framework.Product;

public class MessageBox implements Product {
    private char decochar;

    public MessageBox(char decochar) {
        this.decochar = decochar;
    }

    public MessageBox(MessageBox prototype) {
        this.decochar = prototype.decochar;
    }

    @Override
    public void use(String s) {
        int decolen = 1 + s.length() + 1;
        for (int i = 0; i < decolen; i++) {
            System.out.print(this.decochar);
        }
        System.out.println();
        System.out.println(this.decochar + s + this.decochar);
        for (int i = 0; i < decolen; i++) {
            System.out.print(this.decochar);
        }
        System.out.println();
    }

    @Override
    public Product createCopy() {
        Product p = new MessageBox(this);
        return p;
    }
}