package com.upb.agripos.view;

import com.upb.agripos.controller.PosController;
import com.upb.agripos.model.Product;
import javafx.collections.*;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class PosView extends VBox {

    private TableView<Product> table = new TableView<>();

    public PosView(PosController controller) {

        TableColumn<Product, String> code = new TableColumn<>("Code");
        code.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getCode()));

        TableColumn<Product, String> name = new TableColumn<>("Name");
        name.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getName()));

        table.getColumns().addAll(code, name);
        refresh(controller);

        getChildren().add(table);
    }

    public void refresh(PosController c) {
        table.setItems(FXCollections.observableArrayList(c.getProducts()));
    }
}
