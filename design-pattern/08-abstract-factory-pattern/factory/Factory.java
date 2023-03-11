package factory;

public abstract class Factory {
    public static Factory getFactory(String className) {
        Factory factory = null;
        try {
            // class, constructorといったプログラムの構成要素を
            // コンパイラではなくクラス自身が扱っている
            // -> 一般的に reflection という
            factory = (Factory) Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println("Class " + className + " is not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factory;
    }

    public abstract Link createLink(String caption, String url);

    public abstract Tray createTray(String caption);

    public abstract Page createPage(String caption, String author);

    // ex. 具象クラスの追加
    public Page createYahooPage() {
        Link yahooLink = this.createLink("Yahoo!", "https://www.yahoo.com/");
        Page yahooPage = this.createPage("Yahoo!", "Yahoo!");
        yahooPage.add(yahooLink);
        return yahooPage;
    }
}