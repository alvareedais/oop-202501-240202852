# Laporan Praktikum Minggu 9
Topik: Exception Handling, Custom Exception, dan Penerapan Design Pattern

## Identitas
- Nama  : Alvirdaus Permathasyahidatama Abadi
- NIM   : 240202852
- Kelas : 3IKRA

---

## Tujuan
Menjelaskan perbedaan antara error dan exception.
Mengimplementasikan try–catch–finally dengan tepat.
Membuat custom exception sesuai kebutuhan program.
Mengintegrasikan exception handling ke dalam aplikasi sederhana (kasus keranjang belanja).
(Opsional) Menerapkan design pattern sederhana (Singleton/MVC) dan unit testing dasar.

---

## Dasar Teori
Error vs Exception: Error merujuk pada kondisi fatal yang tidak dapat ditangani oleh program seperti OutOfMemoryError, sedangkan Exception adalah kondisi tidak normal yang masih dapat diantisipasi dan ditangani agar program tidak berhenti tiba-tiba.
Struktur Penanganan: Java menyediakan blok try untuk kode berisiko, catch untuk menangkap kesalahan, dan finally untuk menjalankan kode yang harus tetap dieksekusi (seperti menutup koneksi) apa pun kondisinya.
Custom Exception: Class exception yang dibuat sendiri oleh programmer dengan mewarisi class Exception (untuk checked exception) untuk memberikan pesan kesalahan yang lebih spesifik bagi pengguna.
Design Pattern:
Singleton: Memastikan sebuah class hanya memiliki satu instance di seluruh aplikasi.
MVC (Model-View-Controller): Memisahkan logika data (Model), tampilan (View), dan pemroses alur (Controller) agar kode lebih terorganisir.

---

## Kode Program

1. InsufficientStockException.java
```java
package main.java.com.upb.agripos;

public class InsufficientStockException extends Exception {
    public InsufficientStockException(String message) {
        super(message);
    }
}
```

2. InvalidQuantityException.java
```java
package main.java.com.upb.agripos;

import java.lang.Exception;

public class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String msg) { 
        super(msg); 
    }
}
```

3. MainExceptionDemo.java
```java
package main.java.com.upb.agripos;

public class MainExceptionDemo {
    public static void main(String[] args) throws InvalidQuantityException {
        System.out.println("Hello, I am Alvirdaus Permathasyahidatama Abadi-240202852 (Week9)");

        ShoppingChart cart = new ShoppingChart();
        Product p1 = new Product("P01", "Pupuk Buah NPK 25kg", 90000, 30);
        
        try {
            cart.addProduct(p1, -1);
        } catch (Exception e) {
            System.out.println("Kesalahan: " + e.getMessage());
        }
        
        try {
            cart.removeProduct(p1);
        } catch (ProductNotFoundException e) {
            System.out.println("Kesalahan: " + e.getMessage());
        }

        try {
            cart.addProduct(p1, 35);
            cart.checkout();
        } catch (Exception e) {
            System.out.println("Kesalahan: " + e.getMessage());
        }
    }
}
```

4. Product.java
```java
package main.java.com.upb.agripos;

public class Product {
    private final String code;
    private final String name;
    private final double price;
    private int stock;

    public Product(String code, String name, double price, int stock) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void reduceStock(int qty) {
        this.stock -= qty;
    }
}
```

5. ProductNotFoundException.java
```java
package main.java.com.upb.agripos;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String msg) { 
        super(msg); 
    }
}
```

6. ShoppingCart.java
```java
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
```

---

## Hasil Eksekusi
```
---

## Analisis
Tambah produk dengan quantity -1 → error ditangkap (InvalidQuantityException)
Tambah produk dengan harga negatif → error ditangkap (InvalidPriceException)
Hapus produk yang belum ada di keranjang → error ditangkap (ProductNotFoundException)
Checkout keranjang kosong → error ditangkap (EmptyCartException)
Tambah produk quantity 20 tapi stok cuma 11 → error ditangkap (InsufficientStockException)
---

## Kesimpulan
Exception handling dan custom exception membuat program POS lebih aman dan tidak gampang berhenti ataupun crash. Custom exception (seperti InvalidQuantityException, InvalidPriceException, ProductNotFoundException, dll) membantu menangani kesalahan tertentu dengan pesan yang mudah dimengerti. Try-catch membuat program tetap berjalan walau ada error dan memberi tahu user apa yang salah. Dengan cara ini, program jadi lebih berkualitas, mudah diperbaiki, dan mudah dikembangkan.

---

## Quiz
1. Jelaskan perbedaan error dan exception.  
   Jawaban: Error dan exception sama-sama merupakan kesalahan dalam program, tetapi keduanya memiliki perbedaan yang jelas. Error adalah kesalahan serius yang biasanya berasal dari sistem atau JVM dan umumnya tidak dapat ditangani oleh program, sehingga menyebabkan aplikasi berhenti secara langsung. Contoh error adalah OutOfMemoryError atau StackOverflowError. Sementara itu, exception adalah kesalahan yang terjadi saat program berjalan akibat kondisi tertentu atau kesalahan logika, dan masih dapat ditangani oleh programmer menggunakan mekanisme try–catch. Contoh exception adalah NullPointerException, ArithmeticException, dan IOException.

2. Apa fungsi finally dalam blok try–catch–finally?  
   Jawaban: Blok finally dalam struktur try–catch–finally berfungsi untuk menjalankan kode yang harus selalu dieksekusi, baik ketika exception terjadi maupun tidak. Biasanya finally digunakan untuk menutup resource seperti file, koneksi database, atau objek input agar tidak terjadi kebocoran resource. Dengan adanya finally, programmer dapat memastikan bahwa proses pembersihan atau penutupan tetap dilakukan meskipun terjadi kesalahan di dalam blok try.

3. Mengapa custom exception diperlukan?  
   Jawaban: Custom exception diperlukan karena exception bawaan Java sering kali terlalu umum dan tidak mencerminkan aturan bisnis suatu aplikasi. Dengan membuat custom exception, pesan kesalahan menjadi lebih spesifik, mudah dipahami, dan sesuai dengan kebutuhan sistem. Custom exception juga membantu meningkatkan kualitas kode karena penanganan error menjadi lebih terstruktur dan jelas, terutama pada aplikasi berskala besar.

4. Berikan contoh kasus bisnis dalam POS yang membutuhkan custom exception.
   Jawaban: Dalam sistem POS (Point of Sale), custom exception sangat dibutuhkan untuk menangani aturan bisnis tertentu. Contohnya, ketika kasir melakukan transaksi penjualan tetapi jumlah barang yang dibeli melebihi stok yang tersedia. Dalam kondisi ini, sistem sebaiknya tidak hanya menampilkan error umum, tetapi melempar custom exception seperti StokTidakCukupException. Dengan demikian, sistem dapat mencegah transaksi yang tidak valid, menjaga keakuratan data inventori, serta memberikan informasi kesalahan yang jelas kepada pengguna sistem.

   