package View;

import Controller.CheckSceneController;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CheckScene {
    public static Scene createScene(Stage primaryStage) {
        CheckSceneController controller = new CheckSceneController(primaryStage);

        VBox outsideVBox = new VBox();
        Scene checkScene = new Scene(outsideVBox, 1024, 576);

        checkScene.getStylesheets().add("stylesheet.css");
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
        pageTitle.setText("Run a Stock Check");
        pageTitle.setFont(Font.font("Segoe UI Light", FontWeight.BOLD, 40));
        outsideVBox.getChildren().add(pageTitle);

        Pane homePane = new Pane();

        //TableView
        TableView orderCheckTable = new TableView();
        orderCheckTable.setEditable(false);
        TableColumn productID = new TableColumn("Product ID");
        productID.setPrefWidth(150);
        TableColumn productName = new TableColumn("Product Name");
        productName.setPrefWidth(200);
        TableColumn quantityHeld = new TableColumn("Quantity Held");
        quantityHeld.setPrefWidth(180);
        TableColumn maxQuantity = new TableColumn("Max Quantity");
        maxQuantity.setPrefWidth(180);

        orderCheckTable.getColumns().addAll(productID, productName, quantityHeld, maxQuantity);
        orderCheckTable.setPrefWidth(710);
        orderCheckTable.setLayoutX(12);//Half the size of scene width minus table width

        orderCheckTable.setLayoutY(10);//Gives a 10 px padding
        orderCheckTable.setPrefHeight(490);

        homePane.getChildren().add(orderCheckTable);

        Button homeButton = new Button("Home");
        //checkButton.setOnAction(ae -> lsc.login());
        homeButton.setPrefWidth(300);
        homeButton.setPrefHeight(110);
        homeButton.setLayoutX(732);
        homeButton.setLayoutY(10);
        homeButton.getStyleClass().add("symbolButton");
        homePane.getChildren().add(homeButton);

        Button checkButton = new Button("Run Check");
        //checkButton.setOnAction(ae -> lsc.login());
        checkButton.setPrefWidth(300);
        checkButton.setPrefHeight(110);
        checkButton.setLayoutX(732);
        checkButton.setLayoutY(130);
        checkButton.getStyleClass().add("symbolButton");
        homePane.getChildren().add(checkButton);

        ProgressBar pi = new ProgressBar(0.6);
        pi.setPrefWidth(300);
        pi.setPrefHeight(110);
        pi.setLayoutX(732);
        pi.setLayoutY(250);
        homePane.getChildren().add(pi);
        //add text field here, 110 big with 10 px padding

        /*ProgressIndicator pi = new ProgressIndicator();
        pi.setPrefWidth(300);
        pi.setPrefHeight(230);
        pi.setLayoutX(732);
        pi.setLayoutY(240);
        homePane.getChildren().add(pi);*/

        outsideVBox.getChildren().add(homePane);

        return checkScene;
    }
}
