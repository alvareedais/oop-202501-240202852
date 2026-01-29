package main.java.com.upb.agripos.dao;


import java.util.List;
import main.java.com.upb.agripos.model.Product;

public interface ProductDAO {
   
    void insert(main.java.com.upb.agripos.Product product) throws Exception;
    Product findByCode(String code) throws Exception;
    List<Product> findAll() throws Exception;
    void update(main.java.com.upb.agripos.Product p) throws Exception;
    void delete(String code) throws Exception;
    void insert(Product p) throws Exception;
    void update(Product p) throws Exception;
}