package com.upb.agripos.service;

import com.upb.agripos.dao.*;
import com.upb.agripos.model.Product;
import java.util.List;

public class ProductService {

    private final ProductDAO dao;

    public ProductService(ProductDAO dao) {
        this.dao = dao;
    }

    public List<Product> findAll() {
        return dao.findAll();
    }

    public void add(Product p) {
        if (p.getPrice() <= 0 || p.getStock() < 0) {
            throw new IllegalArgumentException("Harga/Stok tidak valid");
        }
        dao.insert(p);
    }

    public void delete(String code) {
        dao.delete(code);
    }
}
