package iterator;

/**
 * Created by woollymn on 16. 8. 27.
 */
public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book(""));
        bookShelf.appendBook(new Book(""));
        bookShelf.appendBook(new Book(""));
        bookShelf.appendBook(new Book(""));
        Iterator it = bookShelf.iterator();
        while(it.hasNext()) {
            Book book = (Book) it.next();
            System.out.println(book.getName());
        }
    }
}
