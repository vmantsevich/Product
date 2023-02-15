package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    @Test
    public void shouldAddAll() {
        ProductRepository repository = new ProductRepository();
        Smartphone phone1 = new Smartphone(1, "Iphone", 120000, "Apple");
        Smartphone phone2 = new Smartphone(2, "Galaxy", 80000, "Samsung");
        Smartphone phone3 = new Smartphone(3, "Pixel", 40000, "Google");

        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);

        Product[] expected = {phone1, phone2, phone3};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNull() {
        ProductRepository repository = new ProductRepository();
        Smartphone phone1 = new Smartphone(1, "Iphone", 120000, "Apple");
        Smartphone phone2 = new Smartphone(2, "Galaxy", 80000, "Samsung");
        Smartphone phone3 = new Smartphone(3, "Pixel", 40000, "Google");


        Product[] expected = {};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldRemoveById() {
        ProductRepository repository = new ProductRepository();
        Smartphone phone1 = new Smartphone(1, "Iphone", 120000, "Apple");
        Smartphone phone2 = new Smartphone(2, "Galaxy", 80000, "Samsung");
        Smartphone phone3 = new Smartphone(3, "Pixel", 40000, "Google");

        repository.save(phone1);
        repository.save(phone2);
        repository.removeById(1);

        Product[] expected = {phone2};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetItems() {
        ProductRepository repository = new ProductRepository();
        Smartphone phone1 = new Smartphone(1, "Iphone", 120000, "Apple");
        Smartphone phone2 = new Smartphone(2, "Galaxy", 80000, "Samsung");
        Smartphone phone3 = new Smartphone(3, "Pixel", 40000, "Google");

        repository.save(phone1);
        repository.save(phone2);
        Product[] expected = {phone1, phone2};
        Product[] actual = repository.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

}

