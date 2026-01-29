package com.upb.agripos;

import com.upb.agripos.view.ProductTableView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppJavaFX extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new ProductTableView(), 700, 500);
        stage.setTitle("Agri-POS - TableView");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
