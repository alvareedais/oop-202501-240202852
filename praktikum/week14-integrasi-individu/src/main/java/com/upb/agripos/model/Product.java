package com.upb.agripos.model;

public class Product {
    private int id;
    private String code;
    private String name;
    private double price;
    private int stock;

    public Product(int id, String code, String name, double price, int stock) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Product(String code, String name, double price, int stock) {
        this(0, code, name, price, stock);
    }

    public int getId() { return id; }
    public String getCode() { return code; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
}
