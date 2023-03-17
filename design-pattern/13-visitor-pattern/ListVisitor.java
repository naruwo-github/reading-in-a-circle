public class ListVisitor extends Visitor {
    // データ構造を渡り歩きながら一覧を表示するためのクラス

    // 現在注目しているディレクトリ名
    private String currentDir = "";

    @Override
    public void visit(File file) {
        System.out.println(this.currentDir + "/" + file);
    }

    @Override
    public void visit(Directory directory) {
        System.out.println(this.currentDir + "/" + directory);
        String saveDir = this.currentDir;
        this.currentDir += "/" + directory.getName();
        for (Entry entry : directory) {
            entry.accept(this);
        }
        this.currentDir = saveDir;
    }
}