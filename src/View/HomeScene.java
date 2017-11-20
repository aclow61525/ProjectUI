package View;

import Controller.HomeSceneController;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomeScene {

    public static Scene createScene(Stage primaryStage) {

        HomeSceneController controller = new HomeSceneController(primaryStage);

        VBox outsideVBox = new VBox();
        Scene homeScene = new Scene(outsideVBox, 1024, 576);

        homeScene.getStylesheets().add("stylesheet.css");

        //Menu Bar
        MenuBar myMenu = new MenuBar();

        Menu loginMenu = new Menu("Login Options");
        MenuItem loginMenuItem1 = new MenuItem("Logout");
        loginMenuItem1.setOnAction(ae -> controller.logout());
        loginMenu.getItems().addAll(loginMenuItem1);

        Menu fileMenu = new Menu("Database");
        MenuItem fileMenuItem1 = new MenuItem("Refresh Database");
        fileMenu.getItems().addAll(fileMenuItem1);

        Menu productMenu = new Menu("Product");
        MenuItem productMenuItem1 = new MenuItem("Add new product type");
        MenuItem productMenuItem2 = new MenuItem("Delete Product Type");
        productMenu.getItems().addAll(productMenuItem1, productMenuItem2);

        myMenu.getMenus().addAll(loginMenu, fileMenu, productMenu);
        outsideVBox.getChildren().add(myMenu);

        Text pageTitle = new Text();
        pageTitle.setText("Home Page");
        pageTitle.setFont(Font.font("helvetica", FontWeight.BOLD, 40));
        outsideVBox.getChildren().add(pageTitle);

        HBox quickFunctionsBar = new HBox(208);

        Button[] quickButtons = new Button[4];

        quickButtons[0] = new Button("PLUS STOCK");
        quickButtons[0].setPrefSize(100, 50);
        quickButtons[0].getStyleClass().add("button");
        //quickButtons[0].setOnAction((ActionEvent ae) -> doSomething());

        quickButtons[1] = new Button("MINUS STOCK");
        quickButtons[1].setPrefSize(100, 50);
        quickButtons[1].getStyleClass().add("button");
        //quickButtons[1].setOnAction((ActionEvent ae) -> doSomething());

        quickButtons[2] = new Button("REFRESH DATABASE");
        quickButtons[2].setPrefSize(100, 50);
        quickButtons[2].getStyleClass().add("button");
        //quickButtons[2].setOnAction((ActionEvent ae) -> doSomething());

        quickButtons[3] = new Button("RUN STOCK CHECK");
        quickButtons[3].setPrefSize(100, 50);
        quickButtons[3].getStyleClass().add("button");
        //quickButtons[3].setOnAction((ActionEvent ae) -> doSomething());



        quickFunctionsBar.getChildren().addAll(quickButtons);

        outsideVBox.getChildren().add(quickFunctionsBar);

        Pane homePane = new Pane();

        //TableView
        TableView inventoryTable = new TableView();
        inventoryTable.setEditable(false);
        //inventoryTable.
        TableColumn productID = new TableColumn("Product ID");
        TableColumn productName = new TableColumn("Product Name");
        TableColumn productWidth = new TableColumn("Width");
        TableColumn productHeight = new TableColumn("Height");
        TableColumn productDepth = new TableColumn("Depth");
        TableColumn quantityHeld = new TableColumn("Quantity Held");
        TableColumn maxQuantity = new TableColumn("Max Quantity");

        inventoryTable.getColumns().addAll(productID, productName, productWidth, productHeight, productDepth, quantityHeld, maxQuantity);
        inventoryTable.setPrefWidth(1000);
        inventoryTable.setLayoutX(12);//Half the size of scene width minus table width

        inventoryTable.setPrefHeight(400);
        //inventoryTable.setLayoutY(32);

        homePane.getChildren().add(inventoryTable);

        outsideVBox.getChildren().add(homePane);

        return homeScene;

    }

}
