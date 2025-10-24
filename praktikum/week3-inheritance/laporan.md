# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : [Alvirdaus Permathasyahidatama Abadi]
- NIM   : [240202852]
- Kelas : [3IKRA]

---

## Tujuan
- Mahasiswa mampu menjelaskan konsep inheritance (pewarisan class) dalam OOP.
- Mahasiswa mampu membuat superclass dan subclass untuk produk.
- Mahasiswa mampu mendemonstrasikan hierarki class melalui contoh kode.
- Mahasiswa mampu menggunakan super untuk memanggil konstruktor dan method parent class.
- Mahasiswa mampu membuat laporan praktikum yang     menjelaskan perbedaan penggunaan inheritance dibanding class tunggal.

---

## Dasar Teori

- Inheritance adalah mekanisme dalam pemrograman 
berorientasi objek (OOP) yang memungkinkan suatu class mewarisi atribut dan method dari class lain.
- Superclass → class induk yang berisi atribut dan
perilaku umum.
- Subclass → class turunan yang mewarisi atribut/method dari superclass dan dapat menambahkan fitur baru.
- super() digunakan untuk memanggil konstruktor atau method milik superclass.
   Dengan inheritance, kode menjadi lebih efisien, terstruktur, dan mudah dikembangkan.
   Dalam kasus Agri-POS, Produk dijadikan superclass, sedangkan Bahan, Bumbu, dan Alat dijadikan subclass untuk memisahkan kategori produk.

---

## Langkah Praktikum
1️⃣ Membuat Superclass Produk
Berisi atribut dasar seperti kode, nama, harga, dan stok.

2️⃣ Membuat Subclass

Bahan.java → atribut tambahan: varietas

Bumbu.java → atribut tambahan: jenis

Alat.java → atribut tambahan: material

3️⃣ Membuat MainInheritance.java
Instansiasi objek dari tiap subclass dan tampilkan datanya.

4️⃣ Menambahkan CreditBy
Menampilkan identitas mahasiswa dengan CreditBy.print()

5️⃣ Commit dan Push ke GitHub
Commit message: Add practical reports and example files for weeks 1 to 16
---

## Kode Program
### 1. Bahan.java
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



### 2. Bumbu.java

package main.java.com.upb.agripos;


public class Bumbu extends Produk {
    private String jenis;

    public Bumbu(String kode, String nama, double harga, int stok, String jenis) {
        super(kode, nama, harga, stok);
        this.jenis = jenis;
    }

    public String getJenis() { return jenis; }

   
}
      
### 3. Alat.java

package main.java.com.upb.agripos;


public class Alat extends Produk {
    private String material;

    public Alat(String kode, String nama, double harga, int stok, String material) {
        super(kode, nama, harga, stok);
        this.material = material;
    }

    public String getMaterial() { return material; }

  
}

### 4. MainInheritance.java
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


## Hasil Eksekusi
Kode: BNH-123, Nama: Beras Pandan Wangi 5kg, Harga: 75000.0, Stok: 50
Kode: BMB-456, Nama: Minyak Goreng 2L, Harga: 32000.0, Stok: 100
Kode: ALT-789, Nama: Kompor Gas 2 Tungku, Harga: 275000.0, Stok: 20


credit by: 240202852 - Alvirdaus Permathasyahidatama Abadi

C:\Users\Hype\Pictures\Screenshots
---

## Analisis
- Cara kerja program:
   Subclass (Bahan, Bumbu, Alat) mewarisi atribut dari Produk, lalu menambahkan atribut khusus. Konstruktor subclass menggunakan super() untuk memanggil konstruktor superclass.
- Perbandingan dengan minggu sebelumnya:
   Minggu lalu, semua produk dibuat dari satu class Produk. Minggu ini, produk dikelompokkan berdasarkan kategori, sehingga lebih terstruktur dan mudah diperluas.
- Kendala:
   Awalnya terjadi error karena konstruktor belum sesuai dan pemanggilan method salah (getVarietas vs getVarian), namun diperbaiki dengan sinkronisasi nama method dan parameter.
---

## Kesimpulan
Dalam praktikum ini, konsep inheritance telah berhasil diterapkan untuk membuat struktur program yang lebih modular.
Dengan inheritance, subclass dapat mewarisi atribut umum dari superclass tanpa perlu menulis ulang kode, sekaligus menambah atribut spesifik sesuai kebutuhan.
Hal ini membuat program lebih efisien, fleksibel, dan mudah dikembangkan di masa depan.

---

## Quiz
1. Apa keuntungan menggunakan inheritance dibanding membuat class terpisah tanpa hubungan?
Jawaban:
Inheritance membuat kode lebih efisien karena atribut dan method dasar dapat diturunkan dari superclass ke subclass, sehingga tidak perlu menulis ulang kode yang sama. Selain itu, inheritance menjaga struktur yang jelas, memudahkan perawatan, pengembangan, dan memungkinkan penggunaan konsep polimorfisme

2. Bagaimana cara subclass memanggil konstruktor superclass?
Jawaban:Dengan menggunakan keyword super() pada baris pertama konstruktor subclass.
Contoh dalam Java:

public class Subclass extends Superclass {
    public Subclass(String id, String nama) {
        super(id, nama); // Memanggil konstruktor superclass
    }
}

3. Berikan contoh kasus di POS pertanian selain Benih, Pupuk, dan Alat Pertanian yang bisa dijadikan subclass.
Jawaban:Contoh subclass lain di sistem POS pertanian:

ObatTanaman → atribut tambahan: jenis hama, dosis pemakaian

SistemIrigasi → atribut: tipe irigasi, kapasitas air

PakanTernak → atribut: kandungan nutrisi, umur ternak
