import java.util.Iterator;
import java.util.ArrayList;

public class BookShelf implements Iterable<Book> {
    private ArrayList<Book> books;
    private int last = 0;

    public BookShelf() {
        this.books = new ArrayList<Book>();
    }

    public Book getBookAt(int index) {
        return books.get(index);
    }

    public void appendBook(Book book) {
        this.books.add(book);
        this.last++; // 書籍ではthisつけてないけど個人的にはつけたほうがいいと思う→動作確認
    }

    public int getLength() {
        return this.last;
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }
}