package factory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.ArrayList;

public abstract class Page implements HTMLable {
    // HTMLページ全体を表す抽象クラス

    protected String title;
    protected String author;
    protected List<Item> itemList = new ArrayList<>();

    public Page(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void add(Item item) {
        this.itemList.add(item);
    }

    public void output(String filename) {
        try {
            Files.writeString(
                    Path.of(filename),
                    this.makeHTML(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING,
                    StandardOpenOption.WRITE);
            System.out.println(filename + " created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}