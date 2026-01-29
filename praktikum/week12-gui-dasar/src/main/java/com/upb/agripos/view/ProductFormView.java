package com.upb.agripos.view;

import com.upb.agripos.controller.ProductController;
import com.upb.agripos.model.Product;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ProductFormView extends VBox {

    private final ProductController controller = new ProductController();

    public ProductFormView() {
        setSpacing(8);
        setStyle("-fx-padding: 20;");

        TextField txtCode = new TextField();
        txtCode.setPromptText("Kode Produk");

        TextField txtName = new TextField();
        txtName.setPromptText("Nama Produk");

        TextField txtPrice = new TextField();
        txtPrice.setPromptText("Harga");

        TextField txtStock = new TextField();
        txtStock.setPromptText("Stok");

        Button btnAdd = new Button("Tambah Produk");

        ListView<String> listView = new ListView<>();

        btnAdd.setOnAction(event -> {
            Product p = new Product(
                    txtCode.getText(),
                    txtName.getText(),
                    Double.parseDouble(txtPrice.getText()),
                    Integer.parseInt(txtStock.getText())
            );

            controller.addProduct(p);
            listView.getItems().add(
                    p.getCode() + " - " + p.getName()
            );

            txtCode.clear();
            txtName.clear();
            txtPrice.clear();
            txtStock.clear();
        });

        getChildren().addAll(
                new Label("Form Produk"),
                txtCode, txtName, txtPrice, txtStock,
                btnAdd,
                new Label("Daftar Produk"),
                listView
        );
    }
}
