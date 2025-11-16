package main.java.com.upb.agripos;

import main.java.com.upb.agripos.model.Produk;
import main.java.com.upb.agripos.util.CreditBy;

public class MainProduk {
    public static void main(String[] args) {

        Produk p1 = new Produk("SMK-002", "Benih Semangka Premium", 80000.0, 100);
        Produk p2 = new Produk("PBF-005", "Pupuk Buah NPK 25kg", 90000.0, 100);
        Produk p3 = new Produk("ALAT-025", "Sekop / Cangkul Serbaguna", 50000.0, 100);
        Produk p4 = new Produk("HBM-777", "Obat Hama Anti-Ulat", 60000.0, 50); // tambahan agar sama 4 item

        // === Info Awal Produk (format sama seperti Wahyu) ===
        System.out.println("Kode: " + p1.getKode() + ", Nama: " + p1.getNama() + ", Harga: " + p1.getHarga() + ", Stok: " + p1.getStok());
        System.out.println("Kode: " + p2.getKode() + ", Nama: " + p2.getNama() + ", Harga: " + p2.getHarga() + ", Stok: " + p2.getStok());
        System.out.println("Kode: " + p3.getKode() + ", Nama: " + p3.getNama() + ", Harga: " + p3.getHarga() + ", Stok: " + p3.getStok());
        System.out.println("Kode: " + p4.getKode() + ", Nama: " + p4.getNama() + ", Harga: " + p4.getHarga() + ", Stok: " + p4.getStok());

        // === Perubahan stok (masih meniru pola Wahyu) ===
        System.out.println("Perubahan Stok");
        p1.tambahStok(30);
        p1.kurangiStok(10);

        p2.tambahStok(20);

        p3.kurangiStok(30);

        // p4 agar ada perubahan juga (opsional, biar mirip 3 item Wahyu)
        p4.tambahStok(10);

        // === Setelah Perubahan ===
        System.out.println("Setelah perubahan:");
        System.out.println(p1.getNama() + " stok sekarang: " + p1.getStok());
        System.out.println(p2.getNama() + " stok sekarang: " + p2.getStok());
        System.out.println(p3.getNama() + " stok sekarang: " + p3.getStok());
        System.out.println(p4.getNama() + " stok sekarang: " + p4.getStok());

        // === Credit ===
        CreditBy.print("240202852", "Alvirdaus Permathasyahidatama Abadi");
    }
}



