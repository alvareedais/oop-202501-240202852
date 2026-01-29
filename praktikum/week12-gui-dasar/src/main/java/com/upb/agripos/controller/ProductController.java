package com.upb.agripos.controller;

import com.upb.agripos.model.Product;
import com.upb.agripos.service.ProductService;
import java.util.List;

public class ProductController {

    private final ProductService service = new ProductService();

    public void addProduct(Product product) {
        service.insert(product);
    }

    public List<Product> getProducts() {
        return service.getAll();
    }
}
