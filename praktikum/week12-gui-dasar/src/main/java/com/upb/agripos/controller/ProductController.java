package main.java.com.upb.agripos.controller;

import main.java.com.upb.agripos.model.Product;
import main.java.com.upb.agripos.service.ProductService;
import java.util.List;

public class ProductController {
    private ProductService productService;

    public ProductController() {
        // Inisialisasi service
        this.productService = new ProductService();
    }

    /**
     * @param code
     * @param name
     * @param priceStr
     * @param stockStr
     * @return
     */
    public boolean addProduct(String code, String name, String priceStr, String stockStr) {
        try {
            // Konversi tipe data (Handling NumberFormat)
            double price = Double.parseDouble(priceStr);
            int stock = Integer.parseInt(stockStr);

            Product p = new Product(code, name, price, stock);
            
            // Panggil Service (Bukan DAO!)
            productService.insert(p); 
            return true; // Berhasil
        } catch (NumberFormatException e) {
            System.err.println("Harga dan Stok harus angka!");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Opsional: Untuk mengambil data text list
    public String getProductString(String code, String name) {
        return code + " - " + name;
    }
}