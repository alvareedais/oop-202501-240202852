-- Hapus tabel jika sudah ada (opsional, untuk reset)
DROP TABLE IF EXISTS products;

-- Buat tabel products
CREATE TABLE products (
    code VARCHAR(10) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DOUBLE PRECISION NOT NULL CHECK (price >= 0),
    stock INT NOT NULL CHECK (stock >= 0)
);