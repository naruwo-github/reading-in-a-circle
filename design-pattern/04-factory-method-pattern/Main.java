import framework.Factory;
import framework.Product;
import idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("Mike");
        Product card2 = factory.create("John");
        Product card3 = factory.create("Kevin");
        card1.use();
        card2.use();
        card3.use();
    }
}