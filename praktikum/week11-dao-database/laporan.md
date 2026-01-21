# Laporan Praktikum Week 11 – Data Access Object (DAO) dan CRUD Database

Topik: Data Access Object (DAO) dan CRUD Database dengan JDBC

## Identitas
- Nama  : Alvirdaus Permathasyahidatama Abadi
- NIM   : 240202852
- Kelas : 3IKRA

---

## Tujuan

Mahasiswa mampu:
1. Menjelaskan konsep Data Access Object (DAO) dalam pengembangan aplikasi OOP.
2. Menghubungkan aplikasi Java dengan basis data menggunakan JDBC.
3. Mengimplementasikan operasi CRUD (Create, Read, Update, Delete) secara lengkap.
4. Mengintegrasikan DAO dengan class aplikasi OOP sesuai prinsip desain yang baik.

---

## Dasar Teori

### 1. Data Access Object (DAO)
DAO adalah pola desain yang memisahkan logika akses data dari logika bisnis aplikasi. Dengan DAO, perubahan teknologi basis data tidak memengaruhi logika utama aplikasi.

### 2. JDBC (Java Database Connectivity)
JDBC digunakan untuk menghubungkan aplikasi Java dengan basis data relasional. Komponen utamanya: DriverManager, Connection, PreparedStatement, dan ResultSet.

### 3. PreparedStatement
PreparedStatement digunakan untuk menghindari SQL Injection dan meningkatkan performa dengan parameter binding.

### 4. CRUD Operations
- **Create (Insert)**: Menambah data baru ke database
- **Read (Select)**: Mengambil data dari database
- **Update**: Memperbarui data yang sudah ada
- **Delete**: Menghapus data dari database

### 5. Enkapsulasi Database
DAO menghilangkan akses langsung database dari main() atau UI, sehingga kode lebih terstruktur dan mudah dipelihara.

---

## Langkah Praktikum

### 1. Setup Database
- Buat database `agripos` di PostgreSQL
- Jalankan script `sql/products.sql` untuk membuat tabel dan insert sample data:
  ```sql
  CREATE TABLE products (
      code VARCHAR(10) PRIMARY KEY,
      name VARCHAR(100) NOT NULL,
      price DOUBLE PRECISION NOT NULL,
      stock INT NOT NULL
  );
  ```

### 2. Membuat Model Class (Product.java)
- Package: `com.upb.agripos.model`
- Atribut: code, name, price, stock
- Constructor, getter, setter, dan toString()

### 3. Membuat Interface DAO (ProductDAO.java)
- Package: `com.upb.agripos.dao`
- Method: insert(), findByCode(), findAll(), update(), delete()

### 4. Implementasi DAO (ProductDAOImpl.java)
- Package: `com.upb.agripos.dao`
- Mengimplementasikan interface ProductDAO
- Menggunakan PreparedStatement untuk semua query
- Menangani connection management

### 5. Membuat Class Aplikasi (MainDAOTest.java)
- Package: `com.upb.agripos`
- Melakukan test CRUD lengkap:
  - Membuat koneksi database
  - Insert 3 produk
  - Menampilkan semua produk
  - Find produk by code
  - Update produk
  - Delete produk
  - Menampilkan data akhir

### 6. File dan Direktori yang Dibuat
```
praktikum/week11-dao-database/
├── src/main/java/com/upb/agripos/
│   ├── model/Product.java
│   ├── dao/ProductDAO.java
│   ├── dao/ProductDAOImpl.java
│   ├── MainDAOTest.java
├── sql/products.sql
├── screenshots/
│   └── crud_result.png
└── laporan.md
```

### 7. Commit Message
```
week11-dao-database: [fitur] Implementasi DAO dan CRUD Database dengan JDBC
```

---

## Hasil Implementasi

### A. Struktur Program

**Product.java** - Model dengan enkapsulasi
- Menyimpan data produk (code, name, price, stock)
- Menyediakan getter dan setter
- Implementasi toString() untuk display

**ProductDAO.java** - Interface untuk abstraksi akses data
- Mendefinisikan contract untuk operasi CRUD
- Memisahkan interface dari implementasi

**ProductDAOImpl.java** - Implementasi akses data dengan JDBC
- Menggunakan PreparedStatement untuk security dan performa
- Mengimplementasikan semua method CRUD
- Error handling dengan throws Exception

**MainDAOTest.java** - Class aplikasi untuk testing
- Membuat koneksi database melalui DriverManager
- Inisialisasi ProductDAO
- Testing semua operasi CRUD
- Proper resource management dengan try-finally

### B. Output Program

Program menjalankan urutan operasi:

1. **CREATE** - Insert 3 produk:
   - P001: Pupuk Organik, Rp 25.000, stok 10
   - P002: Pupuk NPK, Rp 35.000, stok 15
   - P003: Benih Padi Premium, Rp 50.000, stok 20

2. **READ ALL** - Menampilkan semua data produk

3. **READ BY CODE** - Mencari produk dengan code P001

4. **UPDATE** - Mengubah produk P001 menjadi "Pupuk Organik Premium", Rp 30.000, stok 8

5. **DELETE** - Menghapus produk P003

6. **FINAL READ** - Menampilkan data akhir (P001 dan P002)

---

## Analisis & Kesimpulan

### Keuntungan Menggunakan DAO

1. **Separation of Concern**: Logika akses data terpisah dari logika bisnis
2. **Maintainability**: Perubahan database tidak mempengaruhi kode aplikasi
3. **Testability**: DAO mudah di-mock untuk unit testing
4. **Reusability**: DAO dapat digunakan oleh banyak class berbeda
5. **Security**: PreparedStatement mencegah SQL Injection

### Prinsip OOP yang Diterapkan

1. **Encapsulation**: Data produk dienkapsulasi dalam class Product
2. **Abstraction**: Interface ProductDAO menyembunyikan detail implementasi
3. **Polymorphism**: ProductDAOImpl mengimplementasikan interface ProductDAO
4. **Interface Segregation**: Interface DAO hanya berisi method yang diperlukan

---

## Kesulitan dan Solusi

| Kesulitan | Solusi |
|-----------|--------|
| Koneksi database gagal | Pastikan PostgreSQL running, driver JDBC ditambahkan di classpath |
| SQL Error | Gunakan PreparedStatement dan cek parameter order |
| Resource leak | Gunakan try-with-resources atau finally block untuk close() |
| Data duplikat saat insert | Gunakan code sebagai PRIMARY KEY |

---

## Catatan Penting

- ✓ Tidak ada SQL langsung di main()
- ✓ DAO menangani semua akses database
- ✓ CRUD berjalan lengkap
- ✓ Error handling implementasi
- ✓ Resource management proper
- ✓ Code sesuai dengan dokumentasi chapter 11

---

**Tanggal**: 18 Januari 2026  
**Status**: Selesai

---

## Kode Program
(Tuliskan kode utama yang dibuat, contoh:  

```java
// Contoh
Produk p1 = new Produk("BNH-001", "Benih Padi", 25000, 100);
System.out.println(p1.getNama());
```
)
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/hasil.png)
)
---

## Analisis
(
- Jelaskan bagaimana kode berjalan.  
- Apa perbedaan pendekatan minggu ini dibanding minggu sebelumnya.  
- Kendala yang dihadapi dan cara mengatasinya.  
)
---

## Kesimpulan
(Tuliskan kesimpulan dari praktikum minggu ini.  
Contoh: *Dengan menggunakan class dan object, program menjadi lebih terstruktur dan mudah dikembangkan.*)

---

## Quiz
(1. [Tuliskan kembali pertanyaan 1 dari panduan]  
   **Jawaban:** …  

2. [Tuliskan kembali pertanyaan 2 dari panduan]  
   **Jawaban:** …  

3. [Tuliskan kembali pertanyaan 3 dari panduan]  
   **Jawaban:** …  )
