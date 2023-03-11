import framework.Product;

public class UnderlinePen implements Product {
    // concrete class for prototype

    private char underlineChar;

    public UnderlinePen(char underlineChar) {
        this.underlineChar = underlineChar;
    }

    public UnderlinePen(UnderlinePen prototype) {
        this.underlineChar = prototype.underlineChar;
    }

    @Override
    public void use(String s) {
        int underlineLength = s.length();
        System.out.println(s);
        for (int i = 0; i < underlineLength; i++) {
            System.out.print(this.underlineChar);
        }
        System.out.println();
    }

    @Override
    public Product createCopy() {
        Product product = new UnderlinePen(this);
        return product;
    }
}
