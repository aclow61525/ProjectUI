package View;

import Controller.CheckSceneController;
import Model.Product;
import Model.ReorderProduct;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.SQLException;

public class CheckScene {

    private static ObservableList<ReorderProduct> resultsList = FXCollections.observableArrayList();


    public static Scene createScene(Stage primaryStage) {
        CheckSceneController controller = new CheckSceneController(primaryStage);

        VBox outsideVBox = new VBox();
        Scene checkScene = new Scene(outsideVBox, 1024, 576);

        checkScene.getStylesheets().add("stylesheet.css");
        outsideVBox.getStyleClass().add("Pages");

        //Menu Bar
        MenuBar myMenu = new MenuBar();
        myMenu.setPrefSize(1024, 20);

        Menu loginMenu = new Menu("Login Options");
        MenuItem loginMenuItem1 = new MenuItem("Logout");
        loginMenuItem1.setOnAction(ae -> controller.logout());
        MenuItem loginMenuItem2 = new MenuItem("Exit the program");
        loginMenuItem2.setOnAction(ae -> controller.exit());
        loginMenu.getItems().addAll(loginMenuItem1, loginMenuItem2);

        myMenu.getMenus().addAll(loginMenu);

        outsideVBox.getChildren().add(myMenu);

        Text pageTitle = new Text();
        pageTitle.setText("Run a Stock Check");
        pageTitle.setFont(Font.font("Segoe UI Light", FontWeight.BOLD, 40));
        outsideVBox.getChildren().add(pageTitle);

        Pane mainPane = new Pane();

        //TableView
        TableView orderCheckTable = new TableView();
        orderCheckTable.setEditable(false);
        TableColumn productID = new TableColumn("ID");
        productID.setPrefWidth(50);
        TableColumn productName = new TableColumn("Name");
        productName.setPrefWidth(165);
        TableColumn quantityHeld = new TableColumn("In Stock");
        quantityHeld.setPrefWidth(140);
        TableColumn maxQuantity = new TableColumn("Max Stock");
        maxQuantity.setPrefWidth(180);
        TableColumn reorderAmount = new TableColumn("To Reorder");
        reorderAmount.setPrefWidth(200);

        orderCheckTable.getColumns().addAll(productID, productName, quantityHeld, maxQuantity, reorderAmount);
        orderCheckTable.setPrefWidth(710);
        orderCheckTable.setLayoutX(10);
        orderCheckTable.setLayoutY(10);
        orderCheckTable.setPrefHeight(490);

        resultsList.clear();
        orderCheckTable.setItems(resultsList);

        productID.setCellValueFactory(new PropertyValueFactory<>("productID"));
        productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        quantityHeld.setCellValueFactory(new PropertyValueFactory<>("quantityHeld"));
        maxQuantity.setCellValueFactory(new PropertyValueFactory<>("maxQuantity"));
        reorderAmount.setCellValueFactory(new PropertyValueFactory<>("reorderAmount"));

        mainPane.getChildren().add(orderCheckTable);

        Button homeButton = new Button("Home");
        homeButton.setOnAction(ae -> controller.openHomeScene());
        homeButton.setPrefWidth(284);
        homeButton.setPrefHeight(110);
        homeButton.setLayoutX(732);
        homeButton.setLayoutY(10);
        homeButton.getStyleClass().add("symbolButton");
        mainPane.getChildren().add(homeButton);

        Button checkButton = new Button("Run Check");
        checkButton.setOnAction((ActionEvent ae) -> {
            pageTitle.setText("Running Check");
            try {
                controller.scanDatabase(resultsList);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            pageTitle.setText("Stock check completed");
            homeButton.setText("Return Home");
            checkButton.setVisible(false);});
        checkButton.setPrefWidth(284);
        checkButton.setPrefHeight(110);
        checkButton.setLayoutX(732);
        checkButton.setLayoutY(130);
        checkButton.getStyleClass().add("symbolButton");
        mainPane.getChildren().add(checkButton);

        outsideVBox.getChildren().add(mainPane);

        return checkScene;
    }

}
