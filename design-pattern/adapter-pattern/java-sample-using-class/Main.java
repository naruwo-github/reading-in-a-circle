public class Main {
    public static void main(String[] args) {
        // MainはPrintBannerがどう実現されているかを知らない
        // -> Main内を変更せずにPrintBannerクラスの実装を変えることができる
        Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }
}