public class Main {
    public static void main(String[] args) {
        AbstractDisplay d1 = new CharDisplay('H');
        AbstractDisplay d2 = new StringDisplay("Hello, world.");
        // d1, d2ともにAbstractDisplayから継承したテンプレートメソッドdisplayを呼び出せる
        // 実際の動作は個々のクラスCharDisplay, StringDisplayで定まる
        d1.display();
        d2.display();
    }
}