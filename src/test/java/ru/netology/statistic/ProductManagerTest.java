package ru.netology.statistic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.statistic.Book;
import ru.netology.statistic.Product;
import ru.netology.statistic.Smartphone;

public class ProductManagerTest {
    Repository repo = new Repository();
    ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(11, "Book1", 500, "author");
    Product book2 = new Book(222, "Book2", 700, "aвтор");
    Product book3 = new Book(3, "Книга2", 670, "Author");
    Product book4 = new Book(444, "Книга1", 999, "Автор");

    Product smartphone1 = new Smartphone(21, "smartphone1", 10_000, "Producer1");
    Product smartphone2 = new Smartphone(22, "smartphone2", 54_321, "Producer1");
    Product smartphone3 = new Smartphone(23, "smartphone3", 100_000, "Producer3");


    @Test
    public void AddAllProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {book1, book2, book3, book4, smartphone1, smartphone2, smartphone3};
        Product[] actual = manager.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void FindNameBook() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {book4};
        Product[] actual = manager.searchBy("Книга1");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public  void ShouldNotFindIfNotAdd() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("qwerty");
    }

    @Test
    public void FindSeveralProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);


        Product[] expected = {book2, book4};
        Product[] actual = manager.searchBy("Автор" );
    }

}
