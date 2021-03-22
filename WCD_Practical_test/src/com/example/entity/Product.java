package com.example.entity;

public class Product {
    private int id;
    private String name;
    private float price;
    private float amount;
    private String details;

    public Product() {
    }

    public Product(int id, String name, float price, float amount, String details) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
