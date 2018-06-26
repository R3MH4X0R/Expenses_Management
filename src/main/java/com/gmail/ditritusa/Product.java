package com.gmail.ditritusa;

import java.time.LocalDate;
import java.util.List;

public class Product {

    private LocalDate date;
    private double amount;
    private String currency;
    private String product;
    private List<Product> products;

    public Product() {
    }

    public Product(LocalDate date, double amount, String currency, String product, List<Product> products) {
        this.date = date;
        this.amount = amount;
        this.currency = currency;
        this.product = product;
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }


    @Override
    public String toString() {
        return date +
                " " + amount +
                " " + currency +
                " " + product;
    }
}
