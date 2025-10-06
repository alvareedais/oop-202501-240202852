# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Paradigma dan Setup Proyek]

## Identitas
- Nama  : [Alvirdaus Permathasyahidatama Abadi]
- NIM   : [240202852]
- Kelas : [3IKRA]

---

## Tujuan
- Mahasiswa mampu mendefinisikan paradigma prosedural, OOP, dan fungsional.
- Mahasiswa mampu membandingkan kelebihan dan keterbatasan tiap paradigma.
- Mahasiswa mampu memberikan contoh program sederhana untuk masing-masing paradigma.
- Mahasiswa aktif dalam diskusi kelas (bertanya, menjawab, memberi opini).
---

## Dasar Teori
Paradigma pemrograman adalah cara pandang dalam menyusun program:  
- **Prosedural**: program dibangun sebagai rangkaian perintah (fungsi/prosedur).  
- **OOP (Object-Oriented Programming)**: program dibangun dari objek yang memiliki data (atribut) dan perilaku (method).  
- **Fungsional**: program dipandang sebagai pemetaan fungsi matematika, lebih menekankan ekspresi dan transformasi data.  

Dalam konteks Agri-POS, OOP membantu memodelkan entitas nyata seperti Produk, Transaksi, dan Pembayaran sebagai objek. Dengan demikian, sistem lebih mudah dikembangkan dan dipelihara.  

---

## Langkah Praktikum
1. **Setup Project**
   - Pastikan sudah menginstall **JDK** (Java Development Kit), **IDE** (misal: IntelliJ IDEA, VS Code, NetBeans), **Git**, **PostgreSQL**, dan **JavaFX** di komputer.
   - Buat folder project `oop-pos-<nim>`.
   - Inisialisasi repositori Git.
   - Buat struktur awal `src/main/java/com/upb/agripos/`.
   - Pastikan semua tools dapat berjalan (uji dengan membuat dan menjalankan program Java sederhana).

2. **Program Sederhana dalam 3 Paradigma**
   - Prosedural: program untuk menghitung total harga dua produk.
   - OOP: class `Produk` dengan atribut nama dan harga, buat minimal tiga objek, lalu hitung total.  
   - Fungsional: gunakan `Stream` atau lambda untuk menghitung total harga dari minimal tiga objek.  

3. **Commit dan Push**
   - Commit dengan pesan: `week1-setup-hello-pos`.  

---

## Kode Program
(Tuliskan kode utama yang dibuat, contoh:  

```java
// HelloProsedural
public  class HelloProsedural {

    public static void main(String[] args) {
      String nim = "240202852";
      String nama = "Alvirdaus Permathasyahidatama Abadi";
      
      System.out.println("Hello world, i'm " + nama+ " - " + nim);
   }
}

// HelloOOP
class Mahasiswa {
   String nama;
   int nim;
   Mahasiswa(String n, int u) { nama = n; nim = u; }
   void sapa(){ System.out.println("Hello world, i'm " + nama+ " - " + nim);}
}

public class HelloOOP {
   public static void main(String[] args) {
    Mahasiswa m = new Mahasiswa("Alvirdaus Permathasyahidatama Abadi", 240202852);
     m.sapa();
   }
}
// HelloFuncional 
import java.util.function.BiConsumer;
 public class HelloFuncional 
 { public static void main(String[] args) {
    BiConsumer<String,Integer> sapa = (nama, nim)  ->
    System.out.println("Hello world, i'm " + nama+ " - " + nim);
    sapa.accept("Alvirdaus Permathasyahidatama Abadi", 240202852);
 }
    
}
---

## Hasil Eksekusi
// HelloProsedural
c:\Users\Hype\Pictures\Screenshots\Screenshot (26).png
// HelloOOP
c:\Users\Hype\Pictures\Screenshots\Screenshot (30).png
// HelloFuncional 
c:\Users\Hype\Pictures\Screenshots\Screenshot (32).png
---

## Analisis
(
Program prosedural menampilkan alur kerja linear, di mana instruksi dijalankan langkah demi langkah. Pendekatan ini mudah dibuat untuk program kecil, namun sulit dikembangkan karena semua logika bercampur dalam satu fungsi utama.

Program OOP memperkenalkan konsep class dan object, yang menjadikan kode lebih terstruktur dan modular. Setiap entitas seperti Mahasiswa atau Produk memiliki atribut dan perilaku sendiri. Hal ini mempermudah pengelolaan data dan mempercepat proses pengembangan fitur baru, khususnya pada aplikasi skala besar seperti Agri-POS.

Program fungsional menunjukkan cara pemrograman yang lebih deklaratif dengan memanfaatkan lambda expression dan functional interface seperti BiConsumer. Pendekatan ini mampu mengurangi boilerplate code dan meminimalkan efek samping, sehingga kode lebih bersih dan mudah diuji.
)
---

## Kesimpulan
Pada Laporan Praktikum Minggu 1 – Topik: Class dan Object, mahasiswa telah memahami dan mempraktikkan tiga paradigma pemrograman utama, yaitu Prosedural, OOP (Object-Oriented Programming), dan Fungsional.
Melalui percobaan sederhana, dapat disimpulkan bahwa:
Paradigma Prosedural cocok untuk program sederhana dengan urutan langkah-langkah yang jelas.
Paradigma OOP lebih unggul dalam membangun sistem berskala besar karena memisahkan data dan perilaku ke dalam class dan object, sehingga kode menjadi lebih mudah dikembangkan dan dipelihara.
Paradigma Fungsional membantu mengurangi kode berulang dan meningkatkan efisiensi melalui penggunaan ekspresi dan fungsi tanpa efek samping.
Dalam konteks pengembangan sistem Agri-POS, penggunaan OOP terbukti paling efektif untuk memodelkan entitas seperti Produk, Transaksi, dan Pembayaran, sehingga sistem lebih modular, mudah diperluas, dan terstruktur dengan baik.
Dengan demikian, praktikum ini berhasil memberikan pemahaman mendalam tentang perbedaan dan penerapan paradigma pemrograman, serta pentingnya pemilihan paradigma yang tepat sesuai kebutuhan proyek.
---

## Quiz
(1. [Apakah OOP selalu lebih baik dari prosedural?]  
   **Jawaban:** Tidak selalu. OOP (Object-Oriented Programming) lebih baik jika proyek membutuhkan struktur yang kompleks, banyak objek, dan skalabilitas tinggi. Namun, untuk program kecil atau tugas sederhana, paradigma prosedural bisa lebih efisien karena lebih ringan dan mudah dipahami. 

2. [Kapan functional programming lebih cocok digunakan dibanding OOP atau prosedural?]  
   **Jawaban:** Functional programming lebih cocok digunakan ketika aplikasi membutuhkan pemrosesan data yang kompleks, bersifat paralel, dan mengutamakan immutability (data tidak berubah). Contohnya seperti pengolahan data besar (data processing), machine learning pipeline, atau sistem yang membutuhkan tingkat keandalan tinggi tanpa efek samping (side effects). 

3. [Bagaimana paradigma (prosedural, OOP, fungsional) memengaruhi maintainability dan scalability aplikasi?]  
   **Jawaban:** Prosedural: mudah dipahami di awal, tapi sulit di-maintain saat program membesar karena logika bercampur.

               OOP: lebih mudah di-maintain dan di-scale karena kode terorganisir ke dalam kelas dan objek yang modular.

               Fungsional: mudah di-maintain karena fungsi bersifat independen dan tidak bergantung pada keadaan (state), sehingga lebih mudah diuji dan dikembangkan paralel.  

4. [Mengapa OOP lebih cocok untuk mengembangkan aplikasi POS dibanding prosedural?]  
   **Jawaban:** Karena aplikasi POS (Point of Sale) memiliki banyak entitas seperti Produk, Transaksi, Kasir, dan Pelanggan. OOP memungkinkan semua entitas ini direpresentasikan sebagai objek dengan atribut dan metode masing-masing, sehingga mempermudah pengelolaan data, perluasan fitur, serta pemeliharaan kode.  

5. [Bagaimana paradigma fungsional dapat membantu mengurangi kode berulang (*boilerplate code*)?]  
   **Jawaban:** Functional programming menggunakan konsep seperti higher-order functions, map, filter, dan reduce yang memungkinkan operasi umum diterapkan tanpa menulis ulang logika berulang. Dengan begitu, kode menjadi lebih singkat, deklaratif, dan mudah dibaca.  )