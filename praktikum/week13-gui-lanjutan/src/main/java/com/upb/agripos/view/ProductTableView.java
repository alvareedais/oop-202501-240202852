package com.upb.agripos.view;

import com.upb.agripos.controller.ProductController;
import com.upb.agripos.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ProductTableView extends VBox {

    private final ProductController controller = new ProductController();
    private final TableView<Product> table = new TableView<>();
    private final ObservableList<Product> data = FXCollections.observableArrayList();

    public ProductTableView() {
        setSpacing(10);
        setStyle("-fx-padding: 20;");

        // === FORM INPUT ===
        TextField txtCode = new TextField();
        txtCode.setPromptText("Kode");

        TextField txtName = new TextField();
        txtName.setPromptText("Nama");

        TextField txtPrice = new TextField();
        txtPrice.setPromptText("Harga");

        TextField txtStock = new TextField();
        txtStock.setPromptText("Stok");

        Button btnAdd = new Button("Tambah Produk");
        Button btnDelete = new Button("Hapus Produk");

        // === TABLE COLUMN ===
        TableColumn<Product, String> colCode = new TableColumn<>("Kode");
        colCode.setCellValueFactory(c -> 
            new javafx.beans.property.SimpleStringProperty(c.getValue().getCode()));

        TableColumn<Product, String> colName = new TableColumn<>("Nama");
        colName.setCellValueFactory(c -> 
            new javafx.beans.property.SimpleStringProperty(c.getValue().getName()));

        TableColumn<Product, Number> colPrice = new TableColumn<>("Harga");
        colPrice.setCellValueFactory(c -> 
            new javafx.beans.property.SimpleDoubleProperty(c.getValue().getPrice()));

        TableColumn<Product, Number> colStock = new TableColumn<>("Stok");
        colStock.setCellValueFactory(c -> 
            new javafx.beans.property.SimpleIntegerProperty(c.getValue().getStock()));

        table.getColumns().addAll(colCode, colName, colPrice, colStock);
        table.setItems(data);

        // === LAMBDA EVENT HANDLER ===
        btnAdd.setOnAction(e -> {
            Product p = new Product(
                    txtCode.getText(),
                    txtName.getText(),
                    Double.parseDouble(txtPrice.getText()),
                    Integer.parseInt(txtStock.getText())
            );
            controller.add(p);
            loadData();
            txtCode.clear(); txtName.clear(); txtPrice.clear(); txtStock.clear();
        });

        btnDelete.setOnAction(e -> {
            Product selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                controller.delete(selected.getCode());
                loadData();
            }
        });

        loadData();

        getChildren().addAll(
                new Label("Form Produk"),
                txtCode, txtName, txtPrice, txtStock,
                btnAdd, btnDelete,
                new Label("Daftar Produk"),
                table
        );
    }

    private void loadData() {
        data.clear();
        data.addAll(controller.load());
    }
}
