package main.java.com.upb.agripos;

public class MainInheritance {
    public static void main(String[] args) {
        Bahan b = new Bahan("BHN-123", "Beras Pandan Wangi 5kg", 75000, 50, "Cianjur");
        Bumbu m = new Bumbu("BMB-456", "Minyak Goreng 2L", 32000, 100, "Minyak Nabati");
        Alat a = new Alat("ALT-789", "Kompor Gas 2 Tungku", 275000, 20, "Besi Tahan Panas");

        System.out.println("=== DATA PRODUK AGRIPOS ===");
        System.out.println("Bahan: " + b.getNama() + " Varietas: " + b.getVarietas());
        System.out.println("Bumbu: " + m.getNama() + " Jenis: " + m.getJenis());
        System.out.println("Alat: " + a.getNama() + " Material: " + a.getMaterial());

        CreditBy.print("240202852", "Alvirdaus Permathasyahidatama Abadi");
    }
}
