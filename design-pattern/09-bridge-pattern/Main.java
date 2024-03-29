import implementation.StringDisplayImpl;

public class Main {
    public static void main(String[] args) {
        Display display1 = new Display(new StringDisplayImpl("Hello, Japan."));
        Display display2 = new CountDisplay(new StringDisplayImpl("Hello, World."));
        CountDisplay display3 = new CountDisplay(new StringDisplayImpl("Hello, Universe."));
        display1.display();
        display2.display();
        display3.display();
        display3.multiDisplay(5);
    }
}