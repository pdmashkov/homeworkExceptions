package ru.netologu.homeworkExceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTests {
    @Test
    public void shouldDelElement() {
        ShopRepository shopRepository = new ShopRepository();

        Product product1 = new Product(1, "Колбаса", 1000);
        Product product2 = new Product(15, "Хлеб", 100);
        Product product3 = new Product(49, "Сыр", 700);

        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);

        shopRepository.removeById(49);

        Product[] expected = {product1, product2};
        Product[] actual = shopRepository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCatchNotFoundException() {
        ShopRepository shopRepository = new ShopRepository();

        Product product1 = new Product(1, "Колбаса", 1000);
        Product product2 = new Product(15, "Хлеб", 100);
        Product product3 = new Product(49, "Сыр", 700);

        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            shopRepository.removeById(5000);
        });
    }

    @Test
    public void shouldAddElement() {
        ShopRepository shopRepository = new ShopRepository();

        Product product = new Product(12, "Куртка", 10000);

        shopRepository.add(product);

        Product[] expected = {product};
        Product[] actual = shopRepository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCatchAlreadyExistsException() {
        ShopRepository shopRepository = new ShopRepository();

        Product product1 = new Product(12, "Куртка", 10000);
        Product product2 = new Product(12, "Носки", 500);

        shopRepository.add(product1);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            shopRepository.add(product2);
        });
    }
}
