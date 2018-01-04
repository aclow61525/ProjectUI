package View;

import Model.DatabaseConnection;
import Model.Product;
import Model.ProductService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    public static DatabaseConnection database;

    public static void main(String[] args) {
        database = new DatabaseConnection("Database/InventoryDatabase.db");

        ArrayList<Product> testList = new ArrayList<>();
        ProductService.selectAll(testList, database);

        for (Product p: testList){
            System.out.println(p);
        }

        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Inventory Management GUI Prototype");
        primaryStage.setResizable(false);

        Scene loginScene = LoginScene.createScene(primaryStage);
        primaryStage.setScene(loginScene);
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("../Resources/ProjectLogo.png")));

        primaryStage.show();

    }

}