# Laporan Praktikum Minggu 4
Topik: Polymorphism

## Identitas
- Nama  : Alvirdaus Permathasyahidatama Abadi
- NIM   : 240202852
- Kelas : 3IKRA

---

## Tujuan
- Mahasiswa mampu menjelaskan konsep polymorphism dalam OOP.
- Mahasiswa mampu membedakan method overloading dan overriding.
- Mahasiswa mampu mengimplementasikan polymorphism (overriding, overloading, dynamic binding) dalam program.
- Mahasiswa mampu menganalisis contoh kasus polymorphism pada sistem nyata (Agri-POS).

---

## Dasar Teori
Polymorphism berarti “banyak bentuk” dan memungkinkan objek yang berbeda merespons panggilan method yang sama dengan cara yang berbeda.

1. Overloading → mendefinisikan method dengan nama sama tetapi parameter berbeda.
2. Overriding → subclass mengganti implementasi method dari superclass.
3. Dynamic Binding → pemanggilan method ditentukan saat runtime, bukan compile time.

Dalam konteks Agri-POS, misalnya:

- Method getInfo() pada Produk dioverride oleh Benih, Pupuk, AlatPertanian untuk menampilkan detail spesifik.
- Method tambahStok() bisa dibuat overload dengan parameter berbeda (int, double).

---

## Langkah Praktikum

1. Overloading

- Tambahkan method tambahStok(int jumlah) dan tambahStok(double jumlah) pada class Produk.

2. Overriding

- Tambahkan method getInfo() pada superclass Produk.
- Override method getInfo() pada subclass Benih, Pupuk, dan AlatPertanian.

3. Dynamic Binding

- Buat array Produk[] daftarProduk yang berisi objek Benih, Pupuk, dan AlatPertanian.
- Loop array tersebut dan panggil getInfo(). Perhatikan bagaimana Java memanggil method sesuai jenis objek aktual.

4. Main Class

- Buat MainPolymorphism.java untuk mendemonstrasikan overloading, overriding, dan dynamic binding.
 
5. CreditBy

- Tetap panggil CreditBy.print("<NIM>", "<Nama>").

6. Commit dan Push

- Commit dengan pesan: week4-polymorphism

---

## Kode Program

## AlatPertanian.java

```java
package com.upb.agripos.model;

public class AlatPertanian extends Produk {
    private String bahan;

    public AlatPertanian(String kode, String nama, double harga, int stok, String bahan) {
        super(kode, nama, harga, stok);
        this.bahan = bahan;
    }

    @Override
    public String getInfo() {
        return "Alat Pertanian: " + super.getInfo() + ", Bahan: " + bahan;
    }
}
```

## Benih.java

```java
package com.upb.agripos.model;

public class Benih extends Produk {
    private String varietas;

    public Benih(String kode, String nama, double harga, int stok, String varietas) {
        super(kode, nama, harga, stok);
        this.varietas = varietas;
    }

    @Override
    public String getInfo() {
        return "Benih: " + super.getInfo() + ", Varietas: " + varietas;
    }
}
```

## ObatHama.java

```java
package com.upb.agripos.model;

public class ObatHama extends Produk {
    private final String targetHama; 

    public ObatHama(String kode, String nama, double harga, int stok, String targetHama) {
        super(kode, nama, harga, stok);
        this.targetHama = targetHama;
    }

    @Override
    public String getInfo() {
        return "ObatHama  : " + super.getInfo() + ", Target: " + targetHama;
    }
} 
```


## Produk.java

```java
package com.upb.agripos.model;

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

    // === Method Overloading ===
    public void tambahStok(int jumlah) {
        this.stok += jumlah;
    }

    public void tambahStok(double jumlah) {
        this.stok += (int) jumlah;
    }

    // === Getter methods (tambahan penting) ===
    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    // === Method Default (Overridable) ===
    public String getInfo() {
        return "Produk: " + nama + " (Kode: " + kode + ")";
    }
}
```

## Pupuk.java

```java
package com.upb.agripos.model;

public class Pupuk extends Produk {
    private String jenis;

    public Pupuk(String kode, String nama, double harga, int stok, String jenis) {
        super(kode, nama, harga, stok);
        this.jenis = jenis;
    }

    @Override
    public String getInfo() {
        return "Pupuk: " + super.getInfo() + ", Jenis: " + jenis;
    }
}
```

## CreditBy.java

```java
package com.upb.agripos.util;

public class CreditBy {
    public static void print(String nim, String nama) {
        System.out.println("\ncredit by: " + nim + "-" + nama);
    }
}
```


## MainPolymorphism.java

```java
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
```

---

## Hasil Eksekusi


---

## Analisis
- Cara Kerja Kode: Program utama (MainPolymorphism) menginisialisasi sebuah array Produk[] yang berisi empat objek subclass (Benih, Pupuk, AlatPertanian, ObatHama). Saat program melakukan iterasi pada array ini, variabel p memiliki tipe referensi Produk. Namun, ketika p.getInfo() dipanggil, Dynamic Binding terjadi: JVM memeriksa tipe objek aktual saat runtime dan memanggil method getInfo() yang telah di-override di subclass yang sesuai (misal, getInfo() milik Benih saat p menunjuk ke objek Benih).
- Demo Overloading: Program juga mendemonstrasikan Overloading dengan sukses. Pemanggilan produkTes.tambahStok(10) memanggil versi (int), dan produkTes.tambahStok(5.5) memanggil versi (double), yang terlihat jelas dari output cetak yang berbeda ((int) vs (dari double)).
- Perbedaan vs Minggu Sebelumnya: Minggu lalu (Inheritance) kita fokus pada mewarisi properti dan method. Minggu ini (Polymorphism), kita fokus pada mengubah perilaku method yang diwarisi tersebut (overriding) dan memperlakukan objek-objek berbeda seolah-olah mereka satu tipe yang sama (dynamic binding dalam array).
- Kendala: Tidak ada kendala signifikan. Kode berjalan sesuai ekspektasi. Implementasi Latihan Mandiri (ObatHama) juga berhasil diintegrasikan ke dalam array daftarProduk dan menampilkan output yang benar.

---

## Kesimpulan
Polymorphism memungkinkan kode yang lebih fleksibel dan mudah dipelihara. Kita dapat menulis kode generik (seperti loop for (Produk p : ...) ) yang dapat bekerja dengan berbagai objek subclass (Benih, Pupuk, dll) tanpa perlu mengetahui tipe spesifiknya.

---

## Quiz
1. Apa perbedaan overloading dan overriding?  
   **Jawaban:** Overloading adalah penggunaan nama method yang sama dalam satu kelas tetapi dengan jumlah atau tipe parameter yang berbeda, sedangkan overriding adalah mendefinisikan ulang method dari kelas induk di dalam kelas anak dengan nama, parameter, dan tipe kembalian yang sama namun isi atau perilakunya berbeda. Overloading terjadi di dalam satu kelas dan termasuk compile time polymorphism, sedangkan overriding terjadi antara dua kelas (induk dan anak) dan termasuk runtime polymorphism.

2. Bagaimana Java menentukan method mana yang dipanggil dalam dynamic binding?
   **Jawaban:** Dalam dynamic binding (atau late binding), Java menentukan method mana yang dipanggil saat program dijalankan (runtime), bukan saat dikompilasi. Prosesnya adalah: ketika sebuah objek dari subclass diacu oleh referensi superclass, Java akan melihat tipe objek sebenarnya di memori, bukan tipe referensinya, untuk memutuskan method mana yang dijalankan.

3. Berikan contoh kasus polymorphism dalam sistem POS selain produk pertanian.
   **Jawaban:** Sistem POS untuk Toko Elektronik
   Dalam sebuah toko elektronik, ada berbagai jenis produk seperti Laptop, Smartphone, dan Aksesoris. Masing-masing produk memiliki cara menampilkan informasi yang berbeda, tetapi semuanya adalah turunan dari kelas Produk.