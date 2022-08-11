import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Book book1 = new Book(1, "Matrix", 200, "Jane");
    Book book2 = new Book(454, "Harry Potter", 300, "Mike");
    Book book3 = new Book(67, "May and Harry", 500, "Tom");
    Product smartphone1 = new Smartphone(2, "Xiaomi4", 32000, "Xiaomi");
    Product smartphone2 = new Smartphone(4, "Xiaomi6", 15000, "Xiaomi");


    @Test
    public void searchByOneWord() {
        manager.add(smartphone1);
        manager.add(smartphone2);


        Product[] actual = manager.searchBy("Xiaomi");
        Product[] expected = {smartphone1, smartphone2};

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void searchByTwoWords() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Harry Potter");
        Product[] expected = {book2};

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void searchOneWordInTwoBooks() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Harry");
        Product[] expected = {book2, book3};

        Assertions.assertArrayEquals(expected, actual);

    }

}
