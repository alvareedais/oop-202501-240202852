package main.java.com.upb.agripos;

import java.util.HashMap;
import java.util.Map;

public class ShoppingChart {

    private final Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product p, int qty) throws InvalidQuantityException {
        if (qty <= 0) {
            throw new InvalidQuantityException("Quantity harus lebih dari 0.");
        }

        items.put(p, items.getOrDefault(p, 0) + qty);
        System.out.println("Produk berhasil ditambahkan ke keranjang.");
    }

    public void removeProduct(Product p) throws ProductNotFoundException {
        if (!items.containsKey(p)) {
            throw new ProductNotFoundException("Produk tidak ada dalam keranjang.");
        }

        items.remove(p);
        System.out.println("Produk berhasil dihapus dari keranjang.");
    }

    public void checkout() throws InsufficientStockException {
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int qty = entry.getValue();

            if (product.getStock() < qty) {
                throw new InsufficientStockException(
                        "Stok tidak cukup untuk: " + product.getName()
                );
            }
        }

        System.out.println("\nIsi Keranjang:");
        for (Map.Entry<Product, Integer> e : items.entrySet()) {
            System.out.println("- " + e.getKey().getName() + " x" + e.getValue());
            e.getKey().reduceStock(e.getValue());
        }

        System.out.println("Checkout berhasil.");
        items.clear();
    }
}
