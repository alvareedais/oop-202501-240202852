# Laporan Praktikum Minggu 11
Topik: Data Access Object (DAO) dan CRUD Database dengan JDBC (PostgreSQL)

## Identitas
- Nama  : Alvirdaus Permathasyahidatama Abadi
- NIM   : 240202852
- Kelas : 3IKRA

---

## Tujuan
- Mahasiswa mampu menjelaskan konsep Data Access Object (DAO) sebagai pola desain untuk memisahkan logika bisnis dari logika akses data.
- Mahasiswa mampu menghubungkan aplikasi Java dengan basis data PostgreSQL menggunakan JDBC.
- Mahasiswa mampu mengimplementasikan operasi CRUD (Create, Read, Update, Delete) secara lengkap menggunakan PreparedStatement.
- Mahasiswa mampu mengintegrasikan DAO ke dalam aplikasi utama agar kode menjadi lebih rapi dan modular.

---

## Dasar Teori
- DAO (Data Access Object): Design pattern yang menyediakan antarmuka abstrak ke database. Tujuannya adalah memisahkan logika aplikasi dari detail teknis penyimpanan data, sehingga perubahan pada database tidak merusak logika bisnis.
- JDBC (Java Database Connectivity): Standar API Java untuk menghubungkan aplikasi dengan database relasional.
- PostgreSQL JDBC Driver: Komponen software (library) yang memungkinkan aplikasi Java berkomunikasi dengan server database PostgreSQL.
- PreparedStatement: Objek JDBC yang digunakan untuk mengeksekusi query SQL yang sudah dikompilasi sebelumnya. Ini lebih aman dari serangan SQL Injection dibandingkan Statement biasa.

---

## Langkah Praktikum
- Menyiapkan database agripos dan tabel products menggunakan pgAdmin 4 (PostgreSQL) atau Query Tool.
- Mengkonfigurasi file pom.xml untuk menambahkan dependency driver PostgreSQL (org.postgresql:postgresql) agar proyek mengenali database tersebut.
- Membuat class Model Product yang merepresentasikan data tabel.
- Membuat Interface ProductDAO yang mendefinisikan kontrak operasi CRUD (Insert, Find, Update, Delete).
- Membuat class implementasi ProductDAOImpl yang berisi kode JDBC untuk mengeksekusi query SQL ke PostgreSQL.
- Membuat class MainDAOTest yang melakukan koneksi ke database dan menguji seluruh operasi CRUD secara berurutan.
- Melakukan commit ke repository dengan pesan: week11-dao: implementasi dao pattern dengan postgresql.

---

## Kode Program
ProductDAO.java
```java
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
```
ProductDAOImpl.java
```java
package main.java.com.upb.agripos.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.java.com.upb.agripos.model.Product;

public class ProductDAOImpl implements ProductDAO {

    private final Connection connection;

    public ProductDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Product p) throws Exception {
        String sql = "INSERT INTO products(code, name, price, stock) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, p.getCode());
            ps.setString(2, p.getName());
            ps.setDouble(3, p.getPrice());
            ps.setInt(4, p.getStock());
            ps.executeUpdate();
        }
    }

    @Override
    public Product findByCode(String code) throws Exception {
        String sql = "SELECT * FROM products WHERE code = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, code);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Product(
                        rs.getString("code"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<Product> findAll() throws Exception {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Product(
                    rs.getString("code"),
                    rs.getString("name"),
                    rs.getDouble("price"),
                    rs.getInt("stock")
                ));
            }
        }
        return list;
    }

    @Override
    public void update(Product p) throws Exception {
        String sql = "UPDATE products SET name=?, price=?, stock=? WHERE code=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getCode());
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(String code) throws Exception {
        String sql = "DELETE FROM products WHERE code=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, code);
            ps.executeUpdate();
        }
    }

    @Override
    public void insert(main.java.com.upb.agripos.Product product) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public void update(main.java.com.upb.agripos.Product p) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}
```
Product.java
```java
package main.java.com.upb.agripos.model;

public class Product {
    private final String code; // Dijadikan final sesuai saran IDE
    private String name;
    private double price;
    private int stock;

    public Product(String code, String name, double price, int stock) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return String.format("| %-7s | %-25s | %-12.2f | %-7d |", 
                             code, name, price, stock);
    }
}
```
MainDAOTest.java
```java
package main.java.com.upb.agripos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import main.java.com.upb.agripos.dao.ProductDAO;
import main.java.com.upb.agripos.dao.ProductDAOImpl;
import main.java.com.upb.agripos.model.Product;

public class MainDAOTest {

    public static void main(String[] args) {
        System.out.println("Hello, I am Alvirdaus Permathasyahidatama Abadi-240202852");
        
        String url = "jdbc:postgresql://localhost:5432/agripos";
        String user = "postgres";
        String password = "244442"; // sesuaikan jika beda

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            ProductDAO dao = new ProductDAOImpl(conn);

            System.out.println("=== PERSIAPAN: Membersihkan Data Lama ===");
            // Hapus semua data lama (opsional, untuk bersih-bersih)
            List<Product> allProducts = dao.findAll();
            for (Product p : allProducts) {
                dao.delete(p.getCode());
                System.out.println("Sukses menghapus produk kode: " + p.getCode());
            }
            if (!allProducts.isEmpty()) {
                System.out.println("Data lama sudah dibersihkan (jika ada).");
            } else {
                System.out.println("Tidak ada data lama.");
            }

            System.out.println("\n=== TEST 1: Simpan Barang ===");
            Product p1 = new Product("P001", "Semen Tiga Roda", 65000.0, 100);
            Product p2 = new Product("P002", "Cat Tembok Putih", 120000.0, 50);
            Product p3 = new Product("P003", "Paku Payung", 5000.0, 25);
            Product p4 = new Product("P004", "Besi", 50000.0, 20);
            Product p5 = new Product("P005", "Kuas", 5000.0, 50);

            dao.insert(p1);
            System.out.println("Sukses menyimpan: " + p1.getName());

            dao.insert(p2);
            System.out.println("Sukses menyimpan: " + p2.getName());

            dao.insert(p3);
            System.out.println("Sukses menyimpan: " + p3.getName());

            dao.insert(p4);
            System.out.println("Sukses menyimpan: " + p4.getName());

            dao.insert(p5);
            System.out.println("Sukses menyimpan: " + p5.getName());

            System.out.println("\n=== TEST 2: Tampilkan Semua Barang ===");
            List<Product> products = dao.findAll();
            for (Product p : products) {
                System.out.println(p); // akan otomatis panggil toString()
            }

            System.out.println("\n=== TEST 3: Update Barang (Stok Berkurang) ===");
            Product updateP1 = dao.findByCode("P001");
            if (updateP1 != null) {
                updateP1.setStock(95); // stok berkurang
                dao.update(updateP1);
                System.out.println("Sukses update: " + updateP1.getName());
                System.out.println("Data setelah update: " + updateP1);
            }

            System.out.println("\n=== TEST 4: Hapus Barang ===");
            dao.delete("P003");
            System.out.println("Sukses menghapus produk kode: P003");

            System.out.println("\n=== TEST 5: Cari Barang Berdasarkan Kode ===");
            Product found = dao.findByCode("P002");
            if (found != null) {
                System.out.println("Ditemukan: " + found);
            } else {
                System.out.println("Produk tidak ditemukan.");
            }

        } catch (Exception e) {
            System.err.println("❌ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
```

---

## Hasil Eksekusi


---

## Analisis
---
- Koneksi Database: Aplikasi berhasil terhubung ke PostgreSQL port 5432. Penggunaan driver org.postgresql di pom.xml sangat krusial agar Java mengenali protokol database ini.
- Pemisahan Logika (DAO): Logika SQL tersimpan rapi di dalam ProductDAOImpl. Class utama (MainDAOTest) menjadi sangat bersih karena tidak ada kode SQL (INSERT INTO...) yang tercampur di sana. Main program hanya memanggil method seperti dao.insert() atau dao.findAll().
- Keamanan Data: Penggunaan PreparedStatement (tanda tanya ?) pada kode DAO melindungi aplikasi dari error sintaks akibat karakter khusus (misal tanda kutip pada nama produk) dan mencegah SQL Injection.
- Fleksibilitas: Jika suatu saat database ingin diganti kembali ke MySQL, kita cukup mengubah driver di pom.xml dan URL koneksi di Main, tanpa perlu merombak logika bisnis aplikasi secara keseluruhan.
---

## Kesimpulan
Penerapan DAO Pattern dengan database PostgreSQL memberikan arsitektur aplikasi yang kuat (robust). Data tersimpan permanen di database server yang handal, dan kode program tetap bersih, aman, serta mudah dikembangkan (maintainable) karena adanya pemisahan tanggung jawab yang jelas antara logika bisnis dan akses data.

---

## Quiz
1. Apa fungsi pom.xml dalam praktikum ini?
   **Jawaban:** Untuk mengatur konfigurasi proyek Maven, khususnya mengunduh library PostgreSQL JDBC Driver secara otomatis dari repositori pusat, sehingga kita tidak perlu mencari dan menambahkan file JAR secara manual.

2. Mengapa kita perlu menutup koneksi (conn.close() atau block try-with-resources)?  
   **Jawaban:** Untuk membebaskan sumber daya (resource) di server database. Koneksi yang dibiarkan terbuka terus-menerus dapat menumpuk dan menyebabkan server database kehabisan slot koneksi (connection leak), yang akhirnya membuat aplikasi tidak bisa diakses.

3. Apa perbedaan JDBC URL untuk MySQL dan PostgreSQL?
   **Jawaban:** 
   - MySQL: jdbc:mysql://localhost:3306/nama_db
   - PostgreSQL: jdbc:postgresql://localhost:5432/nama_db (Perbedaan utama ada pada protokol sub-name postgresql vs mysql dan port default 5432 vs 3306).