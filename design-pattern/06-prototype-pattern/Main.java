import framework.Manager;
import framework.Product;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        UnderlinePen underlinePen = new UnderlinePen('-');
        MessageBox warningBox = new MessageBox('*');
        MessageBox slashBox = new MessageBox('/');

        manager.register("strong message", underlinePen);
        manager.register("warning box", warningBox);
        manager.register("slash box", slashBox);

        Product product1 = manager.create("strong message");
        product1.use("Hello, world.");
        Product product2 = manager.create("warning box");
        product2.use("Hello, world.");
        Product product3 = manager.create("slash box");
        product3.use("Hello, world.");
        Product product4 = manager.create("warning box");
        product4.use("Hello, world.");
    }
}