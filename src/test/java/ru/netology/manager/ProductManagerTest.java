package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import org.junit.jupiter.api.BeforeEach;

public class ProductManagerTest {

    ProductManager manager = new ProductManager();
    Product book2 = new Book(2, "master", 300, "bulgakov");
    Product book1 = new Book(1, "dar", 200, "nabokov");
    Product smartphone2 = new Smartphone(2, "redmi", 6000, "xaomi");
    Product smartphone1 = new Smartphone(1, "lumia", 5000, "nokia");
    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
    }
    @Test
    //
    public void shouldSearchByNameBook() {
        Product[] expected = {book2};
        Product[] actual = manager.searchBy("master");
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchByAuthor() {
        Product[] expected = {book1};
        Product[] actual = manager.searchBy("nabokov");
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotFindNameBook() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("book3");
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotFindAuthor() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("dostoevsky");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameSmartphone() {
        Product[] expected = {smartphone2};
        Product[] actual = manager.searchBy("redmi");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByManufacture() {
        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("nokia");
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotFindNameSmartphone() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("galaxy");
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotFindManufacture() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("samsung");
        assertArrayEquals(expected, actual);
    }
}