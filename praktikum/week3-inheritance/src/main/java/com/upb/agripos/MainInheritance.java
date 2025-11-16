package main.java.com.upb.agripos;


import main.java.com.upb.agripos.model.*;
import main.java.com.upb.agripos.util.CreditBy;

public class MainInheritance {
    public static void main(String[] args) {

        Benih b = new Benih("SMK-002", "Benih Semangka Premium", 80000.0, 100, "SMK-PM");
        Pupuk p = new Pupuk("PBF-005", "Pupuk Buah NPK 25kg", 90000.0, 50, "NPK Buah");
        AlatPertanian a = new AlatPertanian("ALAT-025", "Sekop / Cangkul Serbaguna", 50000.0, 75, "Baja");

        System.out.println("=== Data Produk Pertanian ===");
        b.deskripsi();
        p.deskripsi();
        a.deskripsi();

        System.out.println("\n=== Menambah Stok Produk ===");
        System.out.println("Menambah stok Benih Semangka Premium sebanyak 30");
        b.tambahStok(30);
        b.deskripsi();

        System.out.println("\n=== Mengurangi Stok Produk ===");
        System.out.println("Mengurangi stok Sekop / Cangkul Serbaguna sebanyak 30");
        a.kurangiStok(30);
        a.deskripsi();

        // === Credit ===
        CreditBy.print("240202852", "Alvirdaus Permathasyahidatama Abadi");
    }
}
