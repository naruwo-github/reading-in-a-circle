public class Director {
    // Directorは、
    // Builderインタフェースを実装したクラスを受け取って
    // 初期化される
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.makeTitle("Greeting");
        builder.makeString("一般的な挨拶");
        builder.makeItems(new String[] {
                "Hello",
                "How are you",
                "Hi"
        });
        builder.makeString("時間帯に応じた挨拶");
        builder.makeItems(new String[] {
                "Good morning.",
                "Good afternoon.",
                "Good evening."
        });
    }
}