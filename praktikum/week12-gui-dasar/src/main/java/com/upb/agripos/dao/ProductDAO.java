package com.upb.agripos.dao;

import com.upb.agripos.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private final List<Product> data = new ArrayList<>();

    public void insert(Product product) {
        data.add(product); // nanti ganti INSERT SQL PostgreSQL
    }

    public List<Product> findAll() {
        return data;
    }
}
