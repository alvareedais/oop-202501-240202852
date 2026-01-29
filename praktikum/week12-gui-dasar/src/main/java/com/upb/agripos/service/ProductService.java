package com.upb.agripos.service;

import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.model.Product;
import java.util.List;

public class ProductService {

    private final ProductDAO dao = new ProductDAO();

    public void insert(Product product) {
        dao.insert(product);
    }

    public List<Product> getAll() {
        return dao.findAll();
    }

}
