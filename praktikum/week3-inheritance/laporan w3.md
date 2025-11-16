# Laporan Praktikum Minggu 3
Topik: Inheritance

## Identitas
- Nama  : Alvirdaus Permathasyahidatama Abadi
- NIM   : 240202852
- Kelas : 3IKRA

---

## Tujuan
- Mahasiswa mampu menjelaskan konsep inheritance (pewarisan class) dalam OOP.
- Mahasiswa mampu membuat superclass dan subclass untuk produk pertanian.
- Mahasiswa mampu mendemonstrasikan hierarki class melalui contoh kode.
- Mahasiswa mampu menggunakan super untuk memanggil konstruktor dan method parent class.
- Mahasiswa mampu membuat laporan praktikum yang menjelaskan perbedaan penggunaan inheritance dibanding class tunggal.

---

## Dasar Teori
Inheritance adalah mekanisme dalam OOP yang memungkinkan suatu class mewarisi atribut dan method dari class lain.

- Superclass: class induk yang mendefinisikan atribut umum.
- Subclass: class turunan yang mewarisi atribut/method superclass, dan dapat menambahkan atribut/method baru.
- super digunakan untuk memanggil konstruktor atau method superclass.

Dalam konteks Agri-POS, kita dapat membuat class Produk sebagai superclass, kemudian Bolpoin, BukuTulis, dan Cat Akrilik sebagai subclass. Hal ini membuat kode lebih reusable dan terstruktur.

---

## Langkah Praktikum
1. Membuat Superclass Produk

- Gunakan class Produk dari Bab 2 sebagai superclass.

2. Membuat Subclass

- Bolpoin.java → atribut tambahan: material.
- Buku Tulis.java → atribut tambahan: merek pupuk.
- Cat Akrilik.java → atribut tambahan: merek

3. Membuat Main Class

- Instansiasi minimal satu objek dari tiap subclass.
- Tampilkan data produk dengan memanfaatkan inheritance.

4. Menambahkan CreditBy

- Panggil class CreditBy untuk menampilkan identitas mahasiswa.

5. Commit dan Push

- Commit dengan pesan: week3-inheritance.

---

## Kode Program

1. Benih.Java

```java
package main.java.com.upb.agripos.model;

public class Benih extends Produk {
    private String varietas;

    public Benih(String kode, String nama, double harga, int stok, String varietas) {
        super(kode, nama, harga, stok);
        this.varietas = varietas;
    }

    public void deskripsi() {
        System.out.println("Kode: " + kode + " | Nama: " + nama + 
            " | Harga: Rp" + harga + " | Stok: " + stok + 
            " | Varietas: " + varietas);
    }
}
```

2. Pupuk.java

```java
package main.java.com.upb.agripos.model;

public class Pupuk extends Produk {
    private String jenis;

    public Pupuk(String kode, String nama, double harga, int stok, String jenis) {
        super(kode, nama, harga, stok);
        this.jenis = jenis;
    }

    public void deskripsi() {
        System.out.println("Kode: " + kode + " | Nama: " + nama + 
            " | Harga: Rp" + harga + " | Stok: " + stok + 
            " | Jenis: " + jenis);
    }
}
```

3. AlatPertanian.java

```java
package main.java.com.upb.agripos.model;

public class AlatPertanian extends Produk {
    private String material;

    public AlatPertanian(String kode, String nama, double harga, int stok, String material) {
        super(kode, nama, harga, stok);
        this.material = material;
    }

    public void deskripsi() {
        System.out.println("Kode: " + kode + " | Nama: " + nama + 
            " | Harga: Rp" + harga + " | Stok: " + stok + 
            " | Material: " + material);
    }
}
```

4. Produk.java

```java
// Produk.java

package main.java.com.upb.agripos.model;

public class Produk {
    protected String kode;
    protected String nama;
    protected double harga;
    protected int stok;

    public Produk(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public void tambahStok(int jumlah) {
        this.stok += jumlah;
    }

    public void kurangiStok(int jumlah) {
        if (jumlah <= stok) {
            this.stok -= jumlah;
        } else {
            System.out.println("Stok tidak mencukupi!");
        }
    }

    public void tampilkanInfo() {
        System.out.println("Kode: " + kode + " | Nama: " + nama +
            " | Harga: Rp" + harga + " | Stok: " + stok);
    }
}
```

5. CreditBy.java

```java
package main.java.com.upb.agripos.util;

public class CreditBy {
    public static void print(String nim, String nama) {
        System.out.println("\ncredit by: " + nim + "-" + nama);
    }
}
```

6. MainInheritance.java

```java
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

```

---


## Hasil Eksekusi


---

## Analisis
- Setiap subclass (Bolpoin, Buku Tulis dan Cat Akrilik) mewarisi atribut dan method dari superclass Produk.
- Override method deskripsi() memungkinkan setiap subclass menambahkan informasi spesifik tanpa menulis ulang kode dasar.
- Pemanggilan super() pada konstruktor memastikan atribut dasar (kode, nama, harga, stok) diinisialisasi dengan benar.
- Struktur program lebih terorganisir, efisien, dan mudah dikembangkan dibanding class tunggal.
- Tidak ada error kompilasi — program berjalan sempurna dan menampilkan hasil sesuai ekspektasi.

---

## Kesimpulan
Penerapan inheritance memungkinkan penggunaan ulang kode dari superclass sehingga mengurangi duplikasi dan meningkatkan modularitas. Dengan konsep ini, pengembangan sistem Agri-POS menjadi lebih terstruktur dan mudah dikelola.

---

## Quiz
1. Apa keuntungan menggunakan inheritance dibanding membuat class terpisah tanpa hubungan? Jawaban: Inheritance menghemat kode dengan mewarisi atribut dan method dari superclass, sehingga tidak perlu menulis ulang kode yang sama di setiap class.

2. Bagaimana cara subclass memanggil konstruktor superclass? Jawaban: Dengan menggunakan kata kunci super(parameter...) di dalam konstruktor subclass.

3. Berikan contoh kasus di POS pertanian selain Benih, Pupuk, dan Alat Pertanian yang bisa dijadikan subclass. Jawaban: Contohnya Tanaman, Hama dan Obat Tanaman
