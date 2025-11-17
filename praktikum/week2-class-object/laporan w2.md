# Laporan Praktikum Minggu 2
Topik: Class dan Object

## Identitas
- Nama  : Alvirdaus Permathasyahidatama Abadi
- NIM   : 240202852
- Kelas : 3IKRA

---

## Tujuan
- Mahasiswa mampu menjelaskan konsep class, object, atribut, dan method dalam OOP.
- Mahasiswa mampu menerapkan access modifier dan enkapsulasi dalam pembuatan class.
- Mahasiswa mampu mengimplementasikan class Produk dengan atribut dan method yang sesuai.
- Mahasiswa mampu mendemonstrasikan instansiasi object serta menampilkan data produk di console.


## Dasar Teori
1. Mahasiswa mampu menjelaskan konsep class, object, atribut, dan method dalam OOP.

2. Mahasiswa mampu menerapkan access modifier dan enkapsulasi dalam pembuatan class.

3. Mahasiswa mampu mengimplementasikan class Produk dengan atribut dan method yang sesuai.

4. Mahasiswa mampu mendemonstrasikan instansiasi object serta menampilkan data produk di console.

## Langkah Praktikum
1. Membuat Class Produk
- Buat file Produk.java pada package model.
- Tambahkan atribut: kode, nama, harga, dan stok.
- Gunakan enkapsulasi dengan menjadikan atribut bersifat private dan membuat getter serta setter untuk masing-masing atribut.

2. Membuat Class CreditBy
- Buat file CreditBy.java pada package util.
- Isi class dengan method statis untuk menampilkan identitas mahasiswa di akhir output: credit by: 240202864 - Hanifah.

3. Membuat Objek Produk dan Menampilkan Credit
- Buat file MainProduk.java.
- Instansiasi minimal tiga objek produk, misalnya "Totebag", "Kemeja", "Flat Shose".
- Tampilkan informasi produk melalui method getter.
- Panggil CreditBy.print("240202864", "Hanifah") di akhir main untuk menampilkan identitas.

4. Commit dan Push
- Commit dengan pesan: week2-class-object.

## Kode Program

## 1. Produk.java
 
 ```java  
package main.java.com.upb.agripos.model;

public class Produk {
    private String kode;
    private String nama;
    private double harga;
    private int stok;

    public Produk(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getKode() { return kode; }
    public void setKode(String kode) { this.kode = kode; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

    public void tambahStok(int jumlah) {
        stok += jumlah;
        System.out.println("Berhasil menambah stok " + jumlah + " unit. Stok sekarang: " + stok);
    }

    public void kurangiStok(int jumlah) {
        if (stok >= jumlah) {
            stok -= jumlah;
            System.out.println("Berhasil mengurangi stok " + jumlah + " unit. Stok sekarang: " + stok);
        } else {
            System.out.println("Stok tidak cukup! Tidak bisa mengurangi " + jumlah + " unit.");
        }
    }

    public void tampilkanInfo() {
        System.out.println("Kode: " + kode + ", Nama: " + nama +
                ", Harga: " + harga + ", Stok: " + stok);
    }
}
```

## 2. CreditBy.java

```java

package main.java.com.upb.agripos.util;

public class CreditBy {
    public static void print(String nim, String nama) {
        System.out.println("\ncredit by: " + nim + "-" + nama);
    }
}

```

## 3. MainProduk.Java

```java
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

```

## Hasil Eksekusi

c:\Users\Hype\Pictures\Screenshots\Screenshot (75).png


```

## Analisis
- Jelaskan bagaimana kode berjalan.  
Produk.java dalam konteks aplikasi (misal aplikasi kasir atau gudang), class Produk akan digunakan seperti ini:
Membuat objek produk saat input data barang baru.
Mengubah data jika ada perubahan harga atau stok.
Melakukan transaksi dengan memanggil kurangiStok() saat pembelian.
Mengisi ulang stok dengan tambahStok(). CreditBy.java class ini dibuat untuk menampilkan informasi kredit atau identitas pembuat program, biasanya digunakan di akhir program untuk menyatakan siapa yang membuat/mengembangkan aplikasi. MainProduk untuk menampilkan daftar produk (beserta kode, nama, harga, dan stok), kemudian mencetak identitas pembuat program.

## Kesimpulan
Program ini merupakan contoh yang baik dari penggunaan class terpisah, modularisasi kode, dan encapsulation, yang sangat penting dalam pengembangan aplikasi skala besar. Selain itu, mencantumkan identitas pembuat memberikan nilai tambah dari sisi dokumentasi dan profesionalitas. Jika dikembangkan lebih lanjut, program ini bisa menjadi bagian dari sistem manajemen produk secara digital.

## Quiz
1. Mengapa atribut sebaiknya dideklarasikan sebagai private dalam class? Jawaban: Untuk menjaga keamanan dan integritas data. Dengan menjadikan atribut private, data tidak bisa diakses atau diubah secara langsung dari luar class, sehingga dapat mencegah perubahan yang tidak diinginkan dan memastikan bahwa semua akses terhadap data dilakukan melalui metode yang dikontrol (seperti getter dan setter). Ini adalah prinsip utama dari enkapsulasi dalam pemrograman berorientasi objek.

2. Apa fungsi getter dan setter dalam enkapsulasi? Jawaban: Getter dan setter berfungsi sebagai antarmuka (interface) untuk mengakses dan mengubah nilai atribut private. Getter digunakan untuk mengambil (membaca) nilai atribut, sedangkan setter digunakan untuk mengubah nilai atribut dengan logika tertentu jika diperlukan (misalnya validasi data).

3. Bagaimana cara class Produk mendukung pengembangan aplikasi POS yang lebih kompleks? Jawaban: Class Produk dapat menjadi fondasi utama dalam aplikasi Point of Sale (POS) karena mewakili entitas barang yang dijual. Dengan mendefinisikan atribut seperti nama, harga, dan stok dalam class Produk, serta menyediakan metode untuk mengelola data tersebut (misalnya mengurangi stok saat transaksi), kita dapat membangun sistem yang modular dan mudah dikembangkan. Dalam aplikasi POS yang lebih kompleks, class Produk bisa diperluas untuk mendukung fitur seperti kategori produk, diskon, barcode, pelacakan inventaris, dan integrasi dengan sistem lain seperti kasir atau laporan penjualan.
