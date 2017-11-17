package View;

import Controller.HomeSceneController;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeScene {

    public static Scene createScene(Stage primaryStage) {

        HomeSceneController controller = new HomeSceneController(primaryStage);

        VBox outsideVBox = new VBox();
        Scene homeScene = new Scene(outsideVBox, 1024, 768);

        //Menu Bar
        MenuBar myMenu = new MenuBar();

        Menu fileMenu = new Menu("Database");
        MenuItem fileMenuItem1 = new MenuItem("Refresh Database");
        fileMenu.getItems().addAll(fileMenuItem1);

        Menu productMenu = new Menu("Product");
        MenuItem productMenuItem1 = new MenuItem("Add new product type");
        MenuItem productMenuItem2 = new MenuItem("Delete Product Type");
        productMenu.getItems().addAll(productMenuItem1, productMenuItem2);

        Menu loginMenu = new Menu("Login Options");
        MenuItem loginMenuItem1 = new MenuItem("Logout");
        loginMenuItem1.setOnAction(ae -> controller.logout());
        loginMenu.getItems().addAll(loginMenuItem1);

        myMenu.getMenus().addAll(fileMenu, productMenu, loginMenu);
        outsideVBox.getChildren().add(myMenu);

        Pane homePane = new Pane();

        //TableView
        TableView inventoryTable = new TableView();
        inventoryTable.setEditable(false);
        TableColumn productID = new TableColumn("Product ID");
        TableColumn productName = new TableColumn("Product Name");
        TableColumn productWidth = new TableColumn("Width");
        TableColumn productHeight = new TableColumn("Height");
        TableColumn productDepth = new TableColumn("Depth");
        TableColumn quantityHeld = new TableColumn("Quantity Held");
        TableColumn maxQuantity = new TableColumn("Max Quantity");

        inventoryTable.getColumns().addAll(productID, productName, productWidth, productHeight, productDepth, quantityHeld, maxQuantity);
        inventoryTable.setLayoutX(200);
        inventoryTable.setLayoutY(200);

        homePane.getChildren().add(inventoryTable);

        outsideVBox.getChildren().add(homePane);

        return homeScene;

    }

}
