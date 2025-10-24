package main.java.com.upb.agripos;


public class Bahan extends Produk {
        private String varietas;

    public Bahan(String kode, String nama, double harga, int stok, String varietas) {
        super(kode, nama, harga, stok);
        this.varietas = varietas;
    }

    public String getVarietas() { return varietas; }
    public void setVarietas(String varietas) { this.varietas = varietas; }
}
     
