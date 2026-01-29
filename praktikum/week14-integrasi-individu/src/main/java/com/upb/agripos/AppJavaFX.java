package com.upb.agripos;

import com.upb.agripos.controller.PosController;
import com.upb.agripos.dao.JdbcProductDAO;
import com.upb.agripos.service.ProductService;
import com.upb.agripos.view.PosView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppJavaFX extends Application {

    @Override
    public void start(Stage stage) {
        System.out.println("Hello World, I am Alvirdaus Permathasyahidatama Abadi-240202852");

        ProductService service =
                new ProductService(JdbcProductDAO.getInstance());

        PosController controller = new PosController(service);

        stage.setScene(new Scene(new PosView(controller), 600, 400));
        stage.setTitle("AgriPOS - Week 14");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
