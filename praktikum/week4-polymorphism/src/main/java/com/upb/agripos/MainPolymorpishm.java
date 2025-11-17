package com.upb.agripos;

import com.upb.agripos.model.AlatPertanian;
import com.upb.agripos.model.Benih;
import com.upb.agripos.model.ObatHama;
import com.upb.agripos.model.Produk;
import com.upb.agripos.model.Pupuk;
import com.upb.agripos.util.CreditBy;

public class MainPolymorpishm {
    public static void main(String[] args) {

        Produk[] daftarProduk = {
            new Benih("SMK-002", "Benih Semangka Premium", 80000, 100, "SMK-PM"),
            new Pupuk("PBF-005", "Pupuk Buah NPK 25kg", 90000, 50, "NPK Buah"),
            new AlatPertanian("ALAT-025", "Sekop / Cangkul Serbaguna", 50000, 75, "Baja"),
            new ObatHama("OBT-555", "Obat Hama Pengusir Ulat & Kutu", 60000, 50, "Deltametrin")
        };

        System.out.println("===  Daftar Info Produk (Demonstrasi Dynamic Binding) ===");

        for (Produk p : daftarProduk) {
            System.out.println(p.getInfo());
        }

        System.out.println("\n=== Demonstrasi Overloading tambahStok ===");
        Produk produkTes = daftarProduk[0]; 

        System.out.println("Stok awal: " + produkTes.getStok());

        produkTes.tambahStok(9);
        produkTes.tambahStok(7.8);

        System.out.println("\n----------");

        CreditBy.print("240202852", "Alvirdaus Permathasyahidatama Abadi");
    }

}
