package main.java.com.upb.agripos;


public class Bumbu extends Produk {
    private String jenis;

    public Bumbu(String kode, String nama, double harga, int stok, String jenis) {
        super(kode, nama, harga, stok);
        this.jenis = jenis;
    }

    public String getJenis() { return jenis; }

   
}
      