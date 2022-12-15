package ru.geekbrains.hw3springmvc.model;


public class Product {
    private static Long counter = 1L;
    Long id;
    String title;
    int cost;

    public Product(String title, int cost) {
        this.id = counter++;
        this.title = title;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCost() {
        return cost;
    }
}
