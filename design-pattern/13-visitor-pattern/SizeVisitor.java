public class SizeVisitor extends Visitor {
    private int size = 0;

    public int getSize() {
        return this.size;
    }

    @Override
    public void visit(File file) {
        this.size += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        for (Entry entry : directory) {
            entry.accept(this);
        }
    }
}