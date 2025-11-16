# Laporan Praktikum Minggu 5
Topik: Abstraction-Interface

## Identitas
- Nama  : Alvirdaus Permathasyahidatama Abadi
- NIM   : 240202852
- Kelas : 3IKRA

---

## Tujuan
- Mahasiswa mampu menjelaskan perbedaan abstract class dan interface.
- Mahasiswa mampu mendesain abstract class dengan method abstrak sesuai kebutuhan kasus.
- Mahasiswa mampu membuat interface dan mengimplementasikannya pada class.
- Mahasiswa mampu menerapkan multiple inheritance melalui interface pada rancangan kelas.
- Mahasiswa mampu mendokumentasikan kode (komentar kelas/method, README singkat pada folder minggu).

---

## Dasar Teori
Abstraksi adalah proses menyederhanakan kompleksitas dengan menampilkan elemen penting dan menyembunyikan detail implementasi.

- Abstract class: tidak dapat diinstansiasi, dapat memiliki method abstrak (tanpa badan) dan non-abstrak. Dapat menyimpan state (field).
- Interface: kumpulan kontrak (method tanpa implementasi konkret). Sejak Java 8 mendukung default method. Mendukung multiple inheritance (class dapat mengimplementasikan banyak interface).
- Gunakan abstract class bila ada shared state dan perilaku dasar; gunakan interface untuk mendefinisikan kemampuan/kontrak lintas hierarki.

Dalam konteks Agri-POS, Pembayaran dapat dimodelkan sebagai abstract class dengan method abstrak prosesPembayaran() dan biaya(). Implementasi konkritnya: Cash dan EWallet. Kemudian, interface seperti Validatable (mis. verifikasi OTP) dan Receiptable (mencetak bukti) dapat diimplementasikan oleh jenis pembayaran yang relevan.

---

## Langkah Praktikum
1. Abstract Class – Pembayaran

Buat Pembayaran (abstract) dengan field invoiceNo, total dan method:
- double biaya() (abstrak) → biaya tambahan (fee).
- boolean prosesPembayaran() (abstrak) → mengembalikan status berhasil/gagal.
- double totalBayar() (konkrit) → return total + biaya();.

2. Subclass Konkret

- Cash → biaya = 0, proses = selalu berhasil jika tunai >= totalBayar().
- EWallet → biaya = 1.5% dari total; proses = membutuhkan validasi.

3. Interface

- Validatable → boolean validasi(); (contoh: OTP).
- Receiptable → String cetakStruk();

4. Multiple Inheritance via Interface

- EWallet mengimplementasikan dua interface: Validatable, Receiptable.
- Cash setidaknya mengimplementasikan Receiptable.

5. Main Class

- Buat MainAbstraction.java untuk mendemonstrasikan pemakaian Pembayaran (polimorfik).
- Tampilkan hasil proses dan struk. Di akhir, panggil CreditBy.print("[NIM]", "[Nama]").

6. Commit dan Push

- Commit dengan pesan: week5-abstraction-interface.

---

## Kode Program
## 1. Cash.java

```java
package com.upb.agripos.model.Pembayaran;

import com.upb.agripos.model.Kontrak.Receiptable;

public class Cash extends Pembayaran implements Receiptable {
    private final double tunai;

    public Cash(String invoiceNo, double total, double tunai) {
        super(invoiceNo, total);
        this.tunai = tunai;
    }

    @Override
    public double biaya() {
        return 0.0;
    }

    @Override
    public boolean prosesPembayaran() {
        return tunai >= totalBayar(); // sederhana: cukup uang tunai
    }

    @Override
    public String cetakStruk() {
        return String.format("INVOICE %s | TOTAL: %.2f | BAYAR CASH: %.2f | KEMBALI: %.2f",
                invoiceNo, totalBayar(), tunai, Math.max(0, tunai - totalBayar()));
    }
}
```

## 2. EWallet.java
```java
package com.upb.agripos.model.Pembayaran;

import com.upb.agripos.model.Kontrak.Receiptable;
import com.upb.agripos.model.Kontrak.Validatable;

public class EWallet extends Pembayaran implements Validatable, Receiptable {
    private final String akun;
    private final String otp; 

    public EWallet(String invoiceNo, double total, String akun, String otp) {
        super(invoiceNo, total);
        this.akun = akun;
        this.otp = otp;
    }

    @Override
    public double biaya() {
        return total * 0.015; // 1.5% fee
    }

    @Override
    public boolean validasi() {
        return otp != null && otp.length() == 6; // contoh validasi sederhana
    }

    @Override
    public boolean prosesPembayaran() {
        return validasi(); // jika validasi lolos, anggap berhasil
    }

    @Override
    public String cetakStruk() {
        return String.format("INVOICE %s | TOTAL+FEE: %.2f | E-WALLET: %s | STATUS: %s",
                invoiceNo, totalBayar(), akun, prosesPembayaran() ? "BERHASIL" : "GAGAL");
    }
}
```

## 3. Pembayaran.java
```java
package com.upb.agripos.model.Pembayaran;

public abstract class Pembayaran {
    protected String invoiceNo;
    protected double total;

    public Pembayaran(String invoiceNo, double total) {
        this.invoiceNo = invoiceNo;
        this.total = total;
    }

    public abstract double biaya();               // fee/biaya tambahan
    public abstract boolean prosesPembayaran();   // proses spesifik tiap metode

    public double totalBayar() {
        return total + biaya();
    }

    public String getInvoiceNo() { return invoiceNo; }
    public double getTotal() { return total; }
}
```
## 4. Receiptable.java
```java
package com.upb.agripos.model.Kontrak;

public interface Receiptable {
    String cetakStruk();
}
```
## 5. Validatable.java
```java
package com.upb.agripos.model.Kontrak;

public interface Validatable {
    boolean validasi(); // misal validasi OTP/ PIN
}
```
## 6. CreditBy.java
```java
package util;

public class CreditBy {
    public static void print(String nim, String nama) {
        System.out.println("\ncredit by: " + nim + "-" + nama);
    }
}
```
## 7. MainAbstraction.java
```java
package com.upb.agripos;

import model.Kontrak.*;
import model.Pembayaran.*;
import util.CreditBy;

public class MainAbstraction {
    public static void main(String[] args) {
        Pembayaran cash = new Cash("CSH-135", 160000, 180000);
        Pembayaran ew = new EWallet("EWL-790", 210000, "JiungAE@ewallet", "135790");

        System.out.println(((Receiptable) cash).cetakStruk());
        System.out.println(((Receiptable) ew).cetakStruk());

        CreditBy.print("240202852", "Alvirdaus Permathasyahidatama Abadi");
    }
}
```
---

## Hasil Eksekusi

---

## Analisis
- Program ini menggunakan abstraksi supaya tidak perlu menulis ulang detail cara kerja setiap jenis pembayaran. Semua jenis pembayaran (seperti Cash, EWallet, dan TransferBank) dibuat berdasarkan satu kerangka utama, yaitu class Pembayaran.
- Setiap kelas turunan punya aturan sendiri untuk menghitung biaya dan cara memproses pembayaran. Lalu, ada dua interface (Validatable dan Receiptable) yang digunakan agar kelas bisa punya beberapa kemampuan sekaligus
- Untuk kesulitannya, sempat bingung memastikan semua kelas turunan sudah melengkapi method dari class abstrak dan interface. Tapi bisa diatasi dengan fitur bantuan IDE (seperti auto generate method) supaya tidak ada yang ketinggalan.

---

## Kesimpulan
Dengan memakai abstract class dan interface, program jadi lebih mudah diatur dan dikembangkan. KKita bisa menambah jenis pembayaran baru tanpa harus mengubah bagian lain dari program. Selain itu, konsep multiple inheritance lewat interface membuat program lebih fleksibel dan tetap aman. Secara keseluruhan, penerapan abstraksi ini membuat kode lebih terstruktur dan efisien.

---

## Quiz
1. Jelaskan perbedaan konsep dan penggunaan abstract class dan interface.  
   **Jawaban:**
   Perbedaan antara abstract class dan interface terletak pada konsep, struktur, serta tujuan penggunaannya dalam pemrograman berorientasi objek di Java. Abstract class adalah kelas yang tidak dapat dibuat objeknya secara langsung dan berfungsi sebagai cetakan dasar bagi kelas turunannya. Di dalam abstract class, dapat terdapat abstract method (metode tanpa isi yang harus diimplementasikan oleh subclass) maupun concrete method (metode dengan isi yang dapat langsung digunakan). Selain itu, abstract class juga dapat memiliki atribut, konstruktor, dan logika dasar yang ingin dibagikan kepada semua kelas turunannya.
   
   Sementara itu, interface merupakan kumpulan deklarasi metode tanpa isi yang berfungsi sebagai kontrak bagi kelas yang mengimplementasikannya. Semua metode di dalam interface secara default bersifat public dan abstract, serta semua variabelnya bersifat public static final (konstanta). Dengan interface, kita dapat menentukan perilaku standar yang bisa diterapkan oleh berbagai kelas, meskipun kelas-kelas tersebut tidak memiliki hubungan pewarisan.

2. Mengapa multiple inheritance lebih aman dilakukan dengan interface pada Java?  
   **Jawaban:**
   Multiple inheritance lebih aman dilakukan dengan interface di Java karena interface hanya berisi deklarasi perilaku (method) tanpa membawa keadaan (state) atau implementasi logika yang dapat menimbulkan konflik. Dalam pewarisan ganda (multiple inheritance), masalah utama yang sering muncul adalah “diamond problem”, yaitu ketika dua kelas induk memiliki atribut atau metode dengan nama yang sama, sehingga kelas turunan tidak tahu implementasi mana yang harus digunakan.


3. Pada contoh Agri-POS, bagian mana yang paling tepat menjadi abstract class dan mana yang menjadi interface Jelaskan alasannya.
   **Jawaban:**
   dalam sistem Agri-POS, abstract class paling tepat digunakan untuk mendefinisikan kerangka dasar produk seperti Produk, karena semua jenis produk memiliki atribut dan perilaku umum yang sama. Sementara itu, interface digunakan untuk mendefinisikan perilaku tambahan seperti DapatDijual atau DapatKadaluarsa, yang tidak dimiliki oleh semua produk. Dengan demikian, abstract class berperan sebagai dasar struktur utama, sedangkan interface memberikan fleksibilitas perilaku tambahan tanpa mengganggu hierarki kelas.