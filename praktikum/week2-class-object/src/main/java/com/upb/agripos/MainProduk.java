package main.java.com.upb.agripos;

public class MainProduk {
    public static void main(String[] args) {
        Produk p1 = new Produk("BHN-123", "Beras Pandan Wangi 5kg", 75000, 50);      // Benih = bahan dasar
        Produk p2 = new Produk("BMB-456", "Minyak Goreng 2L", 32000, 100);           // Pupuk = penambah kualitas
        Produk p3 = new Produk("ALT-789", "Kompor Gas 2 Tungku", 275000, 20);        // Alat = alat bantu masak

        System.out.println("Kode: " + p1.getKode() + ", Nama: " + p1.getNama() + ", Harga: " + p1.getHarga() + ", Stok: " + p1.getStok());
        System.out.println("Kode: " + p2.getKode() + ", Nama: " + p2.getNama() + ", Harga: " + p2.getHarga() + ", Stok: " + p2.getStok());
        System.out.println("Kode: " + p3.getKode() + ", Nama: " + p3.getNama() + ", Harga: " + p3.getHarga() + ", Stok: " + p3.getStok());

        p1.kurangiStok(10);
        p1.tambahStok(8);

        
        // Tampilkan identitas mahasiswa
        CreditBy.print("240202852", "Alvirdaus Permathasyahidatama Abadi");
    }
}

