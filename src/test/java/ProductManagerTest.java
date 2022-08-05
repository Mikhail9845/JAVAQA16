import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Book book1 = new Book(1, "Matrix", 200, "Jane");
    Book book2 = new Book(454, "Harry Potter", 300, "Mike");
    Book book3 = new Book(67, "May", 500, "Tom");

    @Test
    public void searchByOneWord() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Harry");
        Product[] expected = {book2};

        assertArrayEquals(expected, actual);


    }

    @Test
    public void searchByTwoWords() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Harry Potter");
        Product[] expected = {book2};

        assertArrayEquals(expected, actual);


    }
    @Test
    public void searchByAuthor() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Mike");
        Product[] expected = {book2};

        assertArrayEquals(expected, actual);


    }


}
