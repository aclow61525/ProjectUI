package sample;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HomeSceneController {
    //Insert instance variables
    public static Scene homeScene;
    public static Pane homePane;

    public HomeSceneController(Stage primaryStage){
        homePane = new Pane();
        homeScene = new Scene(homePane, 1024, 768);

        homePane.getStylesheets().add("stylesheet.css");

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
        loginMenuItem1.setOnAction(ae -> primaryStage.setScene(primaryStage.setScene(lsc.loginPageScene)));
        loginMenu.getItems().addAll(loginMenuItem1);

        myMenu.getMenus().addAll(fileMenu, productMenu, loginMenu);
        homePane.getChildren().add(myMenu);

        //TableView
        TableView inventoryTable = new TableView();
        inventoryTable.setEditable(true);
        TableColumn firstNameCol = new TableColumn("First Name");
        TableColumn lastNameCol = new TableColumn("Last Name");
        TableColumn emailCol = new TableColumn("Email");

        inventoryTable.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
        //inventoryTable.setLayoutX(512);
        //inventoryTable.setLayoutY(200);
        homePane.getChildren().add(inventoryTable);
    }
}


