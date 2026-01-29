package com.upb.agripos.dao;

import com.upb.agripos.model.Product;
import java.sql.*;
import java.util.*;

public class JdbcProductDAO implements ProductDAO {

    private static JdbcProductDAO instance;
    private Connection conn;

    private JdbcProductDAO() {
        try {
            conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/agripos",
                "postgres",
                "244442"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static JdbcProductDAO getInstance() {
        if (instance == null) {
            instance = new JdbcProductDAO();
        }
        return instance;
    }

    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("id"),
                        rs.getString("code"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void insert(Product p) {
        String sql = "INSERT INTO product(code,name,price,stock) VALUES (?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getCode());
            ps.setString(2, p.getName());
            ps.setDouble(3, p.getPrice());
            ps.setInt(4, p.getStock());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String code) {
        try (PreparedStatement ps =
             conn.prepareStatement("DELETE FROM product WHERE code=?")) {
            ps.setString(1, code);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
