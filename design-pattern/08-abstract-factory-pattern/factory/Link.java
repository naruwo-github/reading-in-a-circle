package factory;

public abstract class Link extends Item {
    // HTMLのハイパーリンクを表した抽象クラス

    protected String url;

    public Link(String caption, String url) {
        super(caption);
        this.url = url;
    }

    // 一見抽象メソッドを持ってないが、
    // スーパークラスの抽象メソッドmakeHTMLを実装してないので、
    // このクラスも抽象クラスである
}