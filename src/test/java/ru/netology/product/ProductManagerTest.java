package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.ProductManager;
import ru.netology.product.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test

    public void shouldSave() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(222, "Тихий Дон", 1500, "М.Шолохов");
        Book book2 = new Book(333, "Собачье сердце", 2300, "М.Булгаков");
        Book book3 = new Book(444, "В окопах Сталинграда", 900, "В.Некрасов");

        manager.save(book1);
        manager.save(book2);
        manager.save(book3);
        Product[] expected = {book1, book2, book3};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldFindByText() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(222, "Война и Мир", 1500, "Л.Толстой");
        Book book2 = new Book(333, "Война и Мир", 2300, "Л.Толстой");
        Book book3 = new Book(444, "В окопах Сталинграда", 900, "В.Некрасов");

        manager.save(book1);
        manager.save(book2);
        manager.save(book3);
        Product[] expected = {book1, book2};
        Product[] actual = manager.searchBy("Война и Мир");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindByName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(222, "Тихий Дон", 1500, "М.Шолохов");
        Book book2 = new Book(333, "Собачье сердце", 2300, "М.Булгаков");
        Book book3 = new Book(444, "В окопах Сталинграда", 900, "В.Некрасов");

        manager.save(book1);
        manager.save(book2);
        manager.save(book3);
        Product[] expected = {book2};
        Product[] actual = manager.searchBy( "Собачье сердце");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void nothingFind() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(222, "Тихий Дон", 1500, "М.Шолохов");
        Book book2 = new Book(333, "Собачье сердце", 2300, "М.Булгаков");
        Book book3 = new Book(444, "В окопах Сталинграда", 900, "В.Некрасов");

        manager.save(book1);
        manager.save(book2);
        manager.save(book3);
        Product[] expected = {};
        Product[] actual = manager.searchBy( "Собачье Cердце");

        Assertions.assertArrayEquals(expected, actual);

    }


}