import java.util.ArrayList;
import java.util.List;

public class FileFindVisitor extends Visitor {
    private String identifier;
    private List<File> matchedFiles = new ArrayList<>();

    public FileFindVisitor(String identifier) {
        this.identifier = identifier;
    }

    public List<File> getFoundFiles() {
        return this.matchedFiles;
    }

    @Override
    public void visit(File file) {
        if (file.getName().endsWith(this.identifier)) {
            this.matchedFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        for (Entry entry : directory) {
            entry.accept(this);
        }
    }
}