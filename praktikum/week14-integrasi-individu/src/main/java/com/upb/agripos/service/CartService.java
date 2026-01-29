package com.upb.agripos.service;

import com.upb.agripos.model.Cart;
import com.upb.agripos.model.Product;

public class CartService {
    private Cart cart = new Cart();

    public void addToCart(Product p) {
        cart.addItem(p, 1);
    }

    public double getTotal() {
        return cart.getTotal();
    }

    public int getItemCount() {
        return cart.getItemCount();
    }
}
