-- Schema database untuk praktikum week 11 DAO dan Database
-- Database: agripos

-- Create table products
CREATE TABLE products (
    code VARCHAR(10) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    stock INT NOT NULL
);

-- Insert sample data
INSERT INTO products (code, name, price, stock) VALUES
('P001', 'Pupuk Organik', 25000, 10),
('P002', 'Pupuk NPK', 35000, 15),
('P003', 'Benih Padi Premium', 50000, 20);
