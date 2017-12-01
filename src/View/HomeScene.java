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
        outsideVBox.getStyleClass().add("Pages");

        //Menu Bar
        MenuBar myMenu = new MenuBar();
        myMenu.setMinHeight(20);

        Menu loginMenu = new Menu("Login Options");
        MenuItem loginMenuItem1 = new MenuItem("Logout");
        loginMenuItem1.setOnAction(ae -> controller.logout());
        MenuItem loginMenuItem2 = new MenuItem("Exit the program");
        loginMenuItem2.setOnAction(ae -> controller.exit());
        loginMenu.getItems().addAll(loginMenuItem1, loginMenuItem2);

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
        pageTitle.setFont(Font.font("Segoe UI Light", FontWeight.BOLD, 40));
        outsideVBox.getChildren().add(pageTitle);

        HBox quickFunctionsBar = new HBox(208);

        Button[] quickButtons = new Button[4];

        quickButtons[0] = new Button("+");
        quickButtons[0].setPrefSize(100, 50);
        quickButtons[0].getStyleClass().add("symbolButton");
        //quickButtons[0].setOnAction((ActionEvent ae) -> doSomething());

        quickButtons[1] = new Button("-");
        quickButtons[1].setPrefSize(100, 50);
        quickButtons[1].getStyleClass().add("symbolButton");
        quickButtons[1].setOnAction((ActionEvent ae) -> controller.openStockDepletionScene());

        quickButtons[2] = new Button("REFRESH");
        quickButtons[2].setPrefSize(100, 50);
        quickButtons[2].getStyleClass().add("allButton");
        //quickButtons[2].setOnAction((ActionEvent ae) -> doSomething());

        quickButtons[3] = new Button("CHECK");
        quickButtons[3].setPrefSize(100, 50);
        quickButtons[3].getStyleClass().add("allButton");
        quickButtons[3].setOnAction((ActionEvent ae) -> controller.openCheckScene());

        quickFunctionsBar.getChildren().addAll(quickButtons);

        outsideVBox.getChildren().add(quickFunctionsBar);

        Pane homePane = new Pane();

        //TableView
        TableView inventoryTable = new TableView();
        inventoryTable.setEditable(false);
        TableColumn productID = new TableColumn("Product ID");
        productID.setPrefWidth(142);
        TableColumn productName = new TableColumn("Product Name");
        productName.setPrefWidth(200);
        TableColumn productWidth = new TableColumn("Width");
        productWidth.setPrefWidth(100);
        TableColumn productHeight = new TableColumn("Height");
        productHeight.setPrefWidth(100);
        TableColumn productDepth = new TableColumn("Depth");
        productDepth.setPrefWidth(100);
        TableColumn quantityHeld = new TableColumn("Quantity Held");
        quantityHeld.setPrefWidth(180);
        TableColumn maxQuantity = new TableColumn("Max Quantity");
        maxQuantity.setPrefWidth(180);

        inventoryTable.getColumns().addAll(productID, productName, productWidth, productHeight, productDepth, quantityHeld, maxQuantity);
        inventoryTable.setPrefWidth(1000);
        inventoryTable.setLayoutX(12);//Half the size of scene width minus table width

        inventoryTable.setLayoutY(10);//Gives a 10 px padding
        inventoryTable.setPrefHeight(430);

        homePane.getChildren().add(inventoryTable);

        outsideVBox.getChildren().add(homePane);

        return homeScene;

    }

}
