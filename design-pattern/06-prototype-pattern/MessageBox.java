import framework.Product;

public class MessageBox implements Product {
    // concrete class for prototype

    private char decoratingChar;

    public MessageBox(char decoratingChar) {
        this.decoratingChar = decoratingChar;
    }

    public MessageBox(MessageBox prototype) {
        this.decoratingChar = prototype.decoratingChar;
    }

    @Override
    public void use(String s) {
        int decoratingLength = 1 + s.length() + 1;
        for (int i = 0; i < decoratingLength; i++) {
            System.out.print(this.decoratingChar);
        }
        System.out.println();
        System.out.println(this.decoratingChar + s + this.decoratingChar);
        for (int i = 0; i < decoratingLength; i++) {
            System.out.print(this.decoratingChar);
        }
        System.out.println();
    }

    @Override
    public Product createCopy() {
        Product product = new MessageBox(this);
        return product;
    }
}