// 広く一般に公開された具象クラス
// -> Main内で使われることを想定していない
public class Banner {
    private String string;

    public Banner(String string) {
        this.string = string;
    }

    public void showWithParen() {
        System.out.println("(" + this.string + ")");
    }

    public void showWithAster() {
        System.out.println("*" + this.string + "*");
    }
}