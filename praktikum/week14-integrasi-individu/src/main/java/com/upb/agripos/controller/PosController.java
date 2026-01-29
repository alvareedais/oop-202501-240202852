package com.upb.agripos.controller;

import com.upb.agripos.model.Product;
import com.upb.agripos.service.ProductService;
import java.util.List;

public class PosController {

    private final ProductService service;

    public PosController(ProductService service) {
        this.service = service;
    }

    public List<Product> getProducts() {
        return service.findAll();
    }

    public void addProduct(Product p) {
        service.add(p);
    }

    public void deleteProduct(String code) {
        service.delete(code);
    }
}
