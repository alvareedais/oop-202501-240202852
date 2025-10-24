# Laporan Praktikum Minggu 2 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : [Alvirdaus Permathasyahidatama Abadi]
- NIM   : [240202852]
- Kelas : [3IKRA]

---

## Tujuan
- Mahasiswa mampu menjelaskan konsep class, object, atribut, dan method dalam OOP.
- Mahasiswa mampu menerapkan access modifier dan enkapsulasi dalam pembuatan class.
- Mahasiswa mampu mengimplementasikan class Produk pertanian dengan atribut dan method yang sesuai.
- Mahasiswa mampu mendemonstrasikan instansiasi object serta menampilkan data produk pertanian di console.
- Mahasiswa mampu menyusun laporan praktikum dengan bukti kode, hasil eksekusi, dan analisis sederhana.

---

## Dasar Teori
Class adalah blueprint atau cetak biru dari sebuah objek. Objek merupakan instansiasi dari class yang berisi atribut (data) dan method (perilaku). Dalam OOP, enkapsulasi dilakukan dengan menyembunyikan data menggunakan access modifier (public, private, protected) serta menyediakan akses melalui getter dan setter. 
Dalam konteks aplikasi Agri-POS, produk pertanian seperti beras, pupuk, dan alat masak bisa direpresentasikan sebagai objek yang memiliki atribut seperti kode, nama, harga, dan stok.
Dengan pendekatan OOP, data produk dapat dikelola secara modular, mudah diperluas, serta lebih aman terhadap kesalahan logika karena setiap atribut hanya dapat diakses melalui method yang sesuai.

---

## Langkah Praktikum
1. **Membuat Class Produk**  
   - File: `Produk.java`  
   - Tambahkan atribut `kode`, `nama`, `harga`, dan `stok`.  
   - Terapkan enkapsulasi (atribut `private`, akses melalui getter dan setter).  

2. **Membuat Class CreditBy**  
   - File: `CreditBy.java`  
   - Menampilkan identitas mahasiswa dengan format:  
     ```
     credit by: <NIM> - <Nama>
     ```

3. **Membuat Class MainProduk**  
   - File: `MainProduk.java`  
   - Instansiasi tiga objek produk pertanian dan tampilkan datanya melalui getter.  
   - Tambahkan pemanggilan `CreditBy.print()` untuk menampilkan identitas di akhir output.  

4. **Commit dan Push ke GitHub**  
   - Pesan commit:  
     ```
     Add practical reports and example files for weeks 1 to 16
     ```
---

## Kode Program

### 1. Produk.java 


package main.java.com.upb.agripos;

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
        this.stok += jumlah;
    }

    public void kurangiStok(int jumlah) {
        if (this.stok >= jumlah) {
            this.stok -= jumlah;
        } else {
            System.out.println("Stok tidak mencukupi!");
        }
    }
}

### 2. CreditBy.java

package main.java.com.upb.agripos;

public class CreditBy {
    public static void print(String nim, String nama) {
        System.out.println("\ncredit by: " + nim + " - " + nama);
    }
}

### 3. MainProduk.java

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


---

## Hasil Eksekusi

Kode: BNH-123, Nama: Beras Pandan Wangi 5kg, Harga: 75000.0, Stok: 50
Kode: BMB-456, Nama: Minyak Goreng 2L, Harga: 32000.0, Stok: 100
Kode: ALT-789, Nama: Kompor Gas 2 Tungku, Harga: 275000.0, Stok: 20

 p1.kurangiStok(10);
 p1.tambahStok(8);

credit by: 240202852 - Alvirdaus Permathasyahidatama Abadi

---

## Analisis

Program ini menunjukkan bagaimana konsep Class dan Object diterapkan untuk merepresentasikan produk pertanian dalam sistem POS sederhana.

   - Class Produk berfungsi sebagai blueprint yang menyimpan atribut (kode, nama, harga, stok) dan menyediakan method untuk mengakses serta memodifikasi nilai-nilainya.
   - Setiap objek (p1, p2, p3) memiliki nilai unik berdasarkan jenis produknya.
   - Dengan penerapan enkapsulasi, keamanan data lebih terjamin karena akses hanya bisa dilakukan melalui getter dan setter.
   - Pemanggilan CreditBy.print() menandai identitas pembuat program secara otomatis setiap kali program dijalankan.
---

## Kesimpulan
Dari praktikum ini dapat disimpulkan bahwa:
   1. Class berfungsi sebagai cetak biru (blueprint) untuk membuat objek.
   2. Object adalah representasi nyata dari class yang memiliki nilai data spesifik.
   3. Enkapsulasi membantu menjaga keamanan dan integritas data dalam objek.
   4. Penerapan class dan object dalam OOP membuat kode lebih modular, terstruktur, dan mudah dikembangkan.

---

## Quiz
1. Mengapa atribut sebaiknya dideklarasikan sebagai private dalam class?
   Agar data hanya dapat diakses melalui method yang disediakan (getter/setter). Hal ini melindungi nilai atribut dari perubahan langsung yang tidak diinginkan dan mendukung prinsip enkapsulasi.

2. Apa fungsi getter dan setter dalam enkapsulasi?
      Getter berfungsi membaca nilai atribut private, sedangkan setter berfungsi mengubahnya secara terkendali. Keduanya memastikan pengelolaan data tetap aman dan terstruktur.

3. Bagaimana class Produk mendukung pengembangan aplikasi POS yang lebih kompleks?
   Dengan menyimpan atribut produk secara sistematis, class Produk dapat diperluas untuk fitur tambahan seperti pengelolaan stok otomatis, sistem diskon, transaksi, atau laporan penjualan. Struktur ini menjadi dasar bagi pengembangan sistem POS berskala besar.
