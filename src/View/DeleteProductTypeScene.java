package View;

import Controller.StockReductionSceneController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DeleteProductTypeScene {

    public static Scene createScene(Stage primaryStage) {

        StockReductionSceneController controller = new StockReductionSceneController(primaryStage);

        VBox outsideVBox = new VBox();
        Scene loginScene = new Scene(outsideVBox, 1024, 576);

        loginScene.getStylesheets().add("stylesheet.css");
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
        pageTitle.setText("Delete a Product Type");
        pageTitle.setFont(Font.font("Segoe UI Light", FontWeight.BOLD, 40));
        outsideVBox.getChildren().add(pageTitle);

        Pane mainPane = new Pane();

        ObservableList<String> inventoryItems =  FXCollections.observableArrayList("Option 1",  "Option 2", "Option 3");

        ComboBox inventoryItemsList = new ComboBox(inventoryItems);
        inventoryItemsList.setPromptText("Select an item from the database");
        inventoryItemsList.setPrefWidth(300);
        inventoryItemsList.setLayoutX(362);
        inventoryItemsList.setLayoutY(86);
        inventoryItemsList.getStyleClass().add("combo-box");
        mainPane.getChildren().add(inventoryItemsList);

        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(ae -> controller.openHomeScene());
        cancelButton.setPrefWidth(300);
        cancelButton.setLayoutX(207);
        cancelButton.setLayoutY(402);
        cancelButton.getStyleClass().add("allButton");
        mainPane.getChildren().add(cancelButton);

        Button confirmButton = new Button("Confirm");
        //confirmButton.setOnAction(ae -> controller.()); //This will call stock reduction method, when implemented
        confirmButton.setPrefWidth(300);
        confirmButton.setLayoutX(517);
        confirmButton.setLayoutY(402);
        confirmButton.getStyleClass().add("allButton");
        mainPane.getChildren().add(confirmButton);

        outsideVBox.getChildren().add(mainPane);

        return loginScene;

    }

}
