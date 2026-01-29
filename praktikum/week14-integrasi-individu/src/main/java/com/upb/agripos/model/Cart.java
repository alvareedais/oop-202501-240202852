package com.upb.agripos.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int qty) {
        items.add(new CartItem(product, qty));
    }

    public double getTotal() {
        return items.stream()
                .mapToDouble(CartItem::getSubtotal)
                .sum();
    }

    public int getItemCount() {
        return items.size();
    }
}
