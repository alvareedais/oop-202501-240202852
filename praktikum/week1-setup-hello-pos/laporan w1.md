
Topik: tugas 1 membuat hello world

## Identitas
- Nama  : Alvirdaus Permathasyahidatama Abadi
- NIM   : 240202852
- Kelas : 3IKRA

---

## Tujuan
Mahasiswa memahami perbedaan antara paradigma prosedural, fungsional, dan berorientasi objek (OOP).


---

## Dasar Teori 
1.Pemrograman Prosedural

Paradigma pemrograman paling dasar yang menekankan urutan instruksi.

Menggunakan prosedur/fungsi untuk mengorganisasi kode, tetapi data dan logika masih bercampur.

Cocok untuk program sederhana, tetapi sulit dikelola bila program semakin besar.

2. Pemrograman Fungsional

Berbasis pada konsep fungsi murni (pure function) yang tidak memiliki efek samping (side effect).

Data dianggap immutable (tidak berubah) sehingga lebih aman pada proses paralel.

Cocok untuk data processing, parallel computing, dan operasi transformasi data.

Contoh di Java: penggunaan lambda expression, map, filter, reduce.

3. Pemrograman Berorientasi Objek (OOP)

Memodelkan dunia nyata dengan konsep class (blueprint) dan object (instansiasi class).

Memiliki empat pilar utama:
a. Enkapsulasi → menyembunyikan data dengan akses terbatas.
b. Abstraksi → menyederhanakan kompleksitas dengan hanya menampilkan fitur penting.
c. Inheritance (Pewarisan) → memungkinkan class baru mewarisi sifat dari class lain.
d. Polimorfisme → kemampuan objek untuk memiliki banyak bentuk (method overriding/overloading).

OOP membuat kode lebih modular, mudah dikembangkan, dan dikelola.

4. Perbandingan Paradigma

Prosedural: sederhana, cepat dibuat, tapi sulit maintain untuk proyek besar.

Fungsional: ringkas, aman untuk concurrent programming, tapi butuh pemahaman tinggi.

OOP: paling sesuai untuk aplikasi besar dan kompleks, mudah dikembangkan dalam jangka panjang.
---

## Langkah Praktikum
Persiapan

Instal Java Development Kit (JDK).

Pastikan environment path sudah diset agar perintah javac dan java bisa dijalankan di terminal/command prompt.

Buat folder kerja untuk menyimpan file .java.

Implementasi Kode

Buat file heloprosedural.java → contoh program dengan paradigma prosedural.

Buat file HelloFunctional.java → contoh program dengan paradigma fungsional.

Buat file HelloOOP.java → contoh program dengan paradigma OOP.

Kompilasi dan Eksekusi

Compile masing-masing file dengan perintah javac NamaFile.java.

Jalankan program dengan perintah java NamaFile.

Pengujian

Pastikan output yang dihasilkan sesuai harapan (menampilkan teks Hello World versi masing-masing paradigma beserta identitas mahasiswa).

Bandingkan hasil eksekusi ketiga pendekatan.

Version Control (opsional)

Simpan kode ke GitHub.

Gunakan commit message: "Tambah contoh prosedural, fungsional, dan OOP".
---

## Kode Program  

```java
// PROSEDURAL 
public class heloprosedural {

    public static void main(String[] args) {
        String nama = "Alvirdaus Permathasyahidatama Abadi";
        String NIM = "240202852";

        System.out.println("Hello world, i am " + nama + " - " + NIM);
    }

}

```
```java
// OOP 
class Mahasiswa {
    String nama;
    int nim;
    Mahasiswa(String n, int u) {
        nama = n;
        nim = u;
    }
    void sapa() {
        System.out.println("Halo world i am, " + nama + " - " + nim);
    }
}

public class HelloOOP {
    public static void main(String[] args) {
        Mahasiswa m = new Mahasiswa("Alvirdaus Permathasyahidatama Abadi", 240202852);
        m.sapa();
    }
}
```
```java
// FUNCTIONAL
import java.util.function.BiConsumer;

public class HelloFunctional {
    public static void main(String[] args) {

        BiConsumer<String, Integer> sapa = (nama, nim) ->
            System.out.println("Halo world, I am " + nama + " - " + nim);

        sapa.accept("Alvirdaus Permathasyahidatama Abadi", 240202852);

    }
}
---

## Hasil Eksekusi

c:\Users\Hype\Pictures\Screenshots\Screenshot (74).png
c:\Users\Hype\Pictures\Screenshots\Screenshot (73).png
c:\Users\Hype\Pictures\Screenshots\Screenshot (72).png
---

## Analisis
Pada prosedural, program berjalan berurutan tanpa pemisahan data dan perilaku. Cocok untuk latihan dasar, tapi semakin sulit jika program diperbesar.

Pada fungsional, penggunaan lambda expression membuat kode lebih ringkas dan ekspresif. Konsep ini berguna saat banyak operasi data dilakukan secara berulang.

Pada OOP, entitas mahasiswa dibungkus dalam class Produk dengan atribut dan method. Hal ini memudahkan pengorganisasian program dan pengembangan fitur baru.

Perbandingan:

Prosedural → cepat dan sederhana, tapi tidak modular.

Fungsional → ringkas dan minim efek samping, cocok untuk pengolahan data.

OOP → modular, scalable, maintainable, paling cocok untuk aplikasi besar.

Kendala: saat pertama kali membuat OOP, sering terjadi error seperti konstruktor belum didefinisikan dengan benar atau salah penulisan nama class. Dengan debugging dan memperbaiki struktur class, error bisa diatasi.
---

## Kesimpulan
Praktikum ini memperlihatkan perbedaan nyata antara paradigma prosedural, fungsional, dan OOP.

Setiap paradigma memiliki kelebihan dan kelemahan tergantung konteks penggunaannya.

Untuk program kecil, prosedural lebih praktis; untuk pengolahan data, fungsional lebih efisien; dan untuk aplikasi kompleks, OOP adalah pilihan terbaik.

Dengan memahami ketiga paradigma, mahasiswa dapat memilih pendekatan pemrograman yang sesuai dengan kebutuhan aplikasi.

---

## Quiz
1. Apakah OOP selalu lebih baik dari prosedural?
Tidak selalu. OOP lebih baik untuk aplikasi kompleks, berskala besar, atau yang butuh modularitas dan pemeliharaan jangka panjang. Namun, untuk program sederhana atau skrip kecil, pendekatan prosedural bisa lebih cepat, ringan, dan mudah diimplementasikan.

2. Kapan functional programming lebih cocok digunakan dibanding OOP atau prosedural?
Functional programming lebih cocok ketika:

Mengolah data dalam jumlah besar (data processing, big data).

Membutuhkan operasi paralel/konkuren karena fungsi bersifat stateless.

Banyak transformasi data berantai, misalnya analisis data, pemrosesan koleksi dengan map, filter, reduce.

3. Bagaimana paradigma (prosedural, OOP, fungsional) memengaruhi maintainability dan scalability aplikasi?

Prosedural: mudah diimplementasikan, tapi jika aplikasi makin besar, kode sulit dipelihara karena semua bercampur jadi satu (low maintainability & scalability).

OOP: mendukung enkapsulasi, pewarisan, dan polimorfisme, sehingga aplikasi lebih mudah dikembangkan dan dipelihara. Skalabilitas lebih baik karena modular.

Fungsional: karena minim side effect, kode lebih prediktif dan mudah diuji. Cocok untuk sistem yang butuh skalabilitas tinggi, terutama pada pemrosesan paralel/distribusi.

4. Mengapa OOP lebih cocok untuk mengembangkan aplikasi POS dibanding prosedural?
Karena aplikasi POS (Point of Sale) memiliki banyak entitas nyata (Produk, Transaksi, Pelanggan, Kasir, dll). Dengan OOP, setiap entitas bisa dimodelkan sebagai class dengan atribut dan perilakunya sendiri, sehingga:

Struktur program lebih rapi.

Fitur baru bisa ditambahkan tanpa mengubah banyak kode lama.

Lebih mudah di-maintain dan dikembangkan sesuai kebutuhan bisnis.

5. Bagaimana paradigma fungsional dapat membantu mengurangi kode berulang (boilerplate code)?

Dengan higher-order functions (misalnya map, filter, reduce), banyak operasi berulang bisa disederhanakan jadi satu baris.

Fungsi dapat diperlakukan sebagai variabel sehingga mudah digunakan ulang.

Lebih sedikit kode imperatif (loop, kondisi berulang), digantikan dengan deklaratif yang lebih ringkas.