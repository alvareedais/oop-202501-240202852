package com.upb.agripos.model;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        if (quantity <= 0)
            throw new IllegalArgumentException("Qty harus > 0");
        this.product = product;
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
}
