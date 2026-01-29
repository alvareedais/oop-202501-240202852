package com.upb.agripos.controller;

import com.upb.agripos.model.Product;
import com.upb.agripos.service.ProductService;
import java.util.List;

public class ProductController {

    private final ProductService service = new ProductService();

    public void add(Product product) {
        service.insert(product);
    }

    public List<Product> load() {
        return service.findAll();
    }

    public void delete(String code) {
        service.delete(code);
    }
}
