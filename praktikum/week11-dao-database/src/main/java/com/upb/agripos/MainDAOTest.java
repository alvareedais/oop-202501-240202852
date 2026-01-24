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