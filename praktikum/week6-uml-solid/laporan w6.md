# Laporan Praktikum Minggu 6  
Topik: UML & SOLID  

## Identitas  
- Nama  : Hilda Sava Alzena  
- NIM   : 240202865  
- Kelas : 3 IKRA  

---

## Tujuan  
- Mahasiswa mampu menerjemahkan kebutuhan fungsional sistem Agri-POS ke dalam minimal empat diagram UML standar (Use Case, Activity, Sequence, dan Class Diagram) yang konsisten dan akurat.  
- Mahasiswa mampu merancang struktur Class Diagram yang mengaplikasikan minimal dua hingga tiga prinsip desain SOLID, khususnya untuk menjamin sistem ekstensibel (Open/Closed) dan memiliki maintainabilitas yang tinggi (Single Responsibility dan Dependency Inversion).  
- Mahasiswa mampu mendokumentasikan arsitektur sistem secara sistematis dan analitis, termasuk menyajikan keterkaitan antara Functional Requirements dengan komponen UML dan implementasi kelas.  

---

## Dasar Teori  
1. **UML (Unified Modeling Language)** adalah bahasa pemodelan grafis terstandar untuk menspesifikasikan, memvisualisasikan, dan mendokumentasikan arsitektur sistem perangkat lunak.  
2. **Use Case Diagram** dan **Activity Diagram** fokus pada perilaku sistem dan alur bisnis untuk validasi kebutuhan fungsional.  
3. **Sequence Diagram** dan **Class Diagram** fokus pada struktur dan interaksi objek sebagai dasar perancangan OOP.  
4. **Prinsip SOLID** adalah panduan desain OOP untuk membangun sistem yang maintainable dan extensible:  
   - **SRP**: Setiap kelas memiliki satu tanggung jawab.  
   - **OCP**: Sistem terbuka untuk ekstensi, tertutup untuk modifikasi.  
   - **LSP**: Subkelas dapat menggantikan superkelas tanpa merusak program.  
   - **ISP**: Interface harus spesifik dan tidak memaksa klien bergantung pada metode yang tidak digunakan.  
   - **DIP**: Modul tingkat tinggi tidak bergantung pada modul tingkat rendah, keduanya bergantung pada abstraksi.  

---

## Langkah Praktikum  
1. **Pemetaan Kebutuhan & Use Case Diagram**  
   - Menganalisis Functional dan Non-Functional Requirements.  
   - Mengidentifikasi aktor dan use case utama.  
   - Menggambar Use Case Diagram dengan relasi <<include>> dan <<extend>>.  

2. **Activity Diagram**  
   - Memilih proses bisnis utama "Checkout".  
   - Menggambar Activity Diagram dengan swimlane untuk Kasir, Sistem, dan Payment Gateway, serta node keputusan untuk skenario normal dan gagal.  

3. **Sequence Diagram**  
   - Memfokuskan pada proses pembayaran.  
   - Menggambar Sequence Diagram dengan interaksi objek dan guard [alt] untuk pembayaran tunai vs non-tunai serta penanganan error.  

4. **Class Diagram & Penerapan SOLID**  
   - Merancang Class Diagram dengan entitas utama (Product, Transaction, PaymentMethod, dll.) beserta atribut, metode, visibility, dan relasi.  
   - Menerapkan prinsip SOLID (terutama OCP dan DIP) melalui penggunaan interface seperti IPaymentMethod dan IProductRepository.  
   - Melakukan revisi konsistensi nama di semua diagram.  

---

## Kode Program  
   ---usecase
   ---
   config:
   layout: elk
   ---
   flowchart TB
   subgraph B["Sistem Agri-POS"]
         D["Login & Autentikasi"]
         E["Transaksi Checkout"]
         F["Cetak Struk"]
         G["Kelola Produk"]
         H["Pantau Stok"]
         I["Laporan Penjualan"]
   end
      A["Kasir"] --> B & D & E & F
      C["Admin"] --> B & D & G & H & I
      E -. &lt;&gt; .-> D
      G -. &lt;&gt; .-> D
      F -. &lt;&gt; .-> E

      style A fill:#e1f5fe
      style C fill:#f3e5f5
      style D fill:#c8e6c9
      style E fill:#fff3e0
      style F fill:#ffecb3
      style G fill:#e0f2f1
      style H fill:#fce4ec
      style I fill:#e8eaf6

   ```activity
   ---
   config:
   layout: elk
   ---
   flowchart TD
      A1[Kasir] --> A2[Scan Produk]
      A2 --> A3[Metode?]
      A3 --> B1[Tunai]
      B1 --> B2[Input nominal]
      B2 --> B3{Cukup?}
      B3 -->|Ya| B4[Proses Pembayaran]
      B3 -->|Tidak| B5[Tidak & Minta Ulang]
      B5 --> B2
      A3 --> C1[E-Wallet]
      C1 --> C2[Permintaan ke Payment Gateway]
      C2 --> C3{Saldo Cukup?}
      C3 -->|Ya| B4
      C3 -->|Tidak| C4[Gagal & Kembali]
      C4 --> A3
      B4 --> D1{Otorisasi Berhasil?}
      D1 -->|Ya| D2[Cetak Struk]
      D1 -->|Tidak| C4

   ---sequence
   sequenceDiagram
      actor K as Kasir
      participant UI as UI_Checkout
      participant S as CheckoutService
      participant DB as Database

      K->>UI: Konfirmasi Bayar
      UI->>S: validateAndProcess()
      S->>DB: lockStock(productId)
      alt Stok Tidak Mencukupi
         DB-->>S: error(stok_habis)
         S-->>UI: return alert("Barang baru saja terjual!")
         UI-->>K: Tampilkan pesan merah/gagal
      else Stok Aman
         S->>DB: reduceStock()
         S->>DB: createInvoice()
         DB-->>S: status_ok
         S-->>UI: return success_receipt
         UI-->>K: Cetak Struk Otomatis
      end

   ```class
   classDiagram
      class TransactionService {
         -IProductRepository productRepo
         -IPaymentProcessor paymentProcessor
         -IDiscountStrategy discountStrategy
         +executeCheckout(Cart cart)
      }

      class IDiscountStrategy {
         <<interface>>
         +calculateDiscount(double total) double
      }
      class SeasonalDiscount { +calculateDiscount(double total) }
      class MemberDiscount { +calculateDiscount(double total) }

      class IPaymentProcessor {
         <<interface>>
         +pay(double amount) bool
      }
      class MidtransGateway { +pay(double amount) }
      class CashHandler { +pay(double amount) }

      TransactionService --> IDiscountStrategy : OCP (Mudah tambah diskon)
      TransactionService --> IPaymentProcessor : DIP (Tidak tergantung vendor)
      IDiscountStrategy <|.. SeasonalDiscount
      IDiscountStrategy <|.. MemberDiscount
      IPaymentProcessor <|.. MidtransGateway
      IPaymentProcessor <|.. CashHandler


   ## Hasil Eksekusi  
   1. praktikum/week6-uml-solid/hasil MMD/mmd_usecase.png
   2. praktikum/week6-uml-solid/hasil MMD/mmd_activity.png
   3. praktikum/week6-uml-solid/hasil MMD/mmd_sequence.png
   4. praktikum/week6-uml-solid/hasil MMD/mmd_class.png

---

## Analisis

1. **Bagaimana kode berjalan:**
   Kode dijalankan berdasarkan arsitektur OOP dengan menerapkan DIP. Modul tingkat tinggi (seperti TransactionService) bergantung pada abstraksi (interface) untuk berinteraksi dengan modul tingkat rendah (seperti repository atau payment gateway). Contohnya, saat proses pembayaran, TransactionService memanggil metode pay() melalui interface IPaymentMethod tanpa mengetahui detail implementasinya.  

2. **Perbedaan pendekatan minggu ini dibanding minggu sebelumnya:** 
   Minggu sebelumnya fokus pada implementasi kode fungsional dengan prioritas “cepat berjalan”. Minggu ini fokus pada desain arsitektur sebelum coding, menggunakan UML untuk pemodelan visual dan SOLID sebagai panduan kualitas desain untuk mencapai maintainability dan extensibility.  

3. **Kendala yang dihadapi dan cara mengatasinya:**  
  1. Kesulitan menerapkan SRP dalam memisahkan logika bisnis dari objek data. Diatasi dengan mengadopsi pola Service Layer di mana kelas Transaction hanya sebagai DTO, sementara TransactionService menangani logika kompleks.  
  2. Kendala teknis saat membuat Activity Diagram dengan PlantUML karena sintaks partition yang kompleks. Diatasi dengan beralih ke struktur swimlane yang lebih stabil.  

---

## Kesimpulan  
Praktikum ini menunjukkan bahwa UML dan prinsip SOLID merupakan fondasi penting dalam rekayasa perangkat lunak. Desain yang dihasilkan memiliki maintainability dan extensibility tinggi karena dokumentasi visual yang konsisten dari UML serta penerapan DIP dan SRP yang menghasilkan arsitektur modular dan low coupling. Dengan prinsip OCP, sistem siap beradaptasi dengan penambahan fitur baru tanpa mengubah kode inti, sehingga investasi waktu pada fase desain membangun sistem yang kokoh, mudah diuji, dan berkelanjutan.  

---

## Quiz  
1. **Jelaskan perbedaan aggregation dan composition serta berikan contoh penerapannya pada desain Anda.**  
   **Jawaban:**  
   - **Composition:** Relasi kuat di mana objek bagian tidak dapat hidup tanpa objek keseluruhan (contoh: Transaction dan TransactionItem).  
   - **Aggregation:** Relasi lemah di mana objek bagian dapat hidup independen (contoh: Transaction dan Product).  

2. **Bagaimana prinsip Open/Closed dapat memastikan sistem mudah dikembangkan?**  
   **Jawaban:** OCP memungkinkan penambahan fitur baru melalui ekstensi (membuat kelas baru yang mengimplementasikan interface) tanpa mengubah kode inti, sehingga mengurangi risiko bug dan memudahkan pengembangan.  

3. **Mengapa Dependency Inversion Principle (DIP) meningkatkan testability? Berikan contoh penerapannya.**  
   **Jawaban:** DIP meningkatkan testability karena modul tingkat tinggi bergantung pada abstraksi, bukan implementasi konkret. Contoh: ProductService bergantung pada interface IProductRepository, sehingga dalam pengujian dapat menggunakan mock repository tanpa perlu database nyata, memungkinkan pengujian unit yang cepat dan terisolasi.