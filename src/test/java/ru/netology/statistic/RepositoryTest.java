package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.statistic.Book;
import ru.netology.statistic.Product;
import ru.netology.statistic.Smartphone;

public class RepositoryTest {
    Product book1 = new Book(11, "Book1", 500, "author");
    Product book2 = new Book(222, "Book2", 700, "aвтор");
    Product book3 = new Book(3, "Книга2", 670, "Author");
    Product book4 = new Book(444, "Книга1", 999, "Автор");

    Product smartphone1 = new Smartphone(21, "smartphone1", 10_000, "Producer1");
    Product smartphone2 = new Smartphone(22, "smartphone2", 54_321, "Producer1");
    Product smartphone3 = new Smartphone(23, "smartphone3", 100_000, "Producer3");

    @Test
    public void allBook() {
        Repository repo = new Repository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(book4);


        Product[] expected = {book1, book2, book3, book4};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void onceBook() {
        Repository repo = new Repository();
        repo.save(book1);

        Product[] expected = {book1};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void emptyBook() {
        Repository repo = new Repository();


        Product[] expected = {};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void allSmartphone() {
        Repository repo = new Repository();
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);

        Product[] expected = {smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void Deleted() {
        Repository repo = new Repository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(book4);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.removeById(book4.getId());
        repo.removeById(smartphone3.getId());

        Product[] expected = {book1, book2, book2, smartphone1, smartphone2};
        Product[] actual = repo.getItems();
    }
    @Test
    public void DeletedAll() {
        Repository repo = new Repository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(book4);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.removeById(book4.getId());
        repo.removeById(book3.getId());
        repo.removeById(book2.getId());
        repo.removeById(book1.getId());
        repo.removeById(smartphone3.getId());
        repo.removeById(smartphone2.getId());
        repo.removeById(smartphone1.getId());

        Product[] expected = {};
        Product[] actual = repo.getItems();
    }
}
