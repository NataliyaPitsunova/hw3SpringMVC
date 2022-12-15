package ru.geekbrains.hw3springmvc;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.geekbrains.hw3springmvc.model.Product;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Repository
public class ProductRepository {
    List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product("Хлеб", 30));
        products.add(new Product("Молоко", 100));
        products.add(new Product("Апельсин", 150));
        products.add(new Product("Манго", 170));
        products.add(new Product("Рыба", 500));

    }

    public List<Product> getAll() {
        return products;
    }

    public List<Product> getProductById(Long id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst().stream().toList();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

}
