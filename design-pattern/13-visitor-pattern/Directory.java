import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Directory extends Entry implements Iterable<Entry> {
    private String name;
    private List<Entry> directory = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSize() {
        SizeVisitor sv = new SizeVisitor();
        this.accept(sv);
        return sv.getSize();
    }

    public Entry add(Entry entry) {
        this.directory.add(entry);
        return this;
    }

    @Override
    public Iterator<Entry> iterator() {
        return this.directory.iterator();
    }
}