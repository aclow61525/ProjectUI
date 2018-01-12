package View;

import Controller.DeleteProductTypeSceneController;
import Model.Product;
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

        DeleteProductTypeSceneController controller = new DeleteProductTypeSceneController(primaryStage);

        VBox outsideVBox = new VBox();
        Scene deleteProductTypeScene = new Scene(outsideVBox, 1024, 576);

        deleteProductTypeScene.getStylesheets().add("stylesheet.css");
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

        myMenu.getMenus().addAll(loginMenu);
        outsideVBox.getChildren().add(myMenu);

        Text pageTitle = new Text();
        pageTitle.setText("Delete a Product Type");
        pageTitle.setFont(Font.font("Segoe UI Light", FontWeight.BOLD, 40));
        outsideVBox.getChildren().add(pageTitle);

        Pane mainPane = new Pane();

        ObservableList<Product> productTypeList = FXCollections.observableArrayList();
        controller.populateDropDown(productTypeList);

        ComboBox<Product> inventoryItemsList = new ComboBox<>(productTypeList);
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
        confirmButton.setOnAction(ae -> controller.prepareProductDeletion(inventoryItemsList));
        confirmButton.setPrefWidth(300);
        confirmButton.setLayoutX(517);
        confirmButton.setLayoutY(402);
        confirmButton.getStyleClass().add("allButton");
        mainPane.getChildren().add(confirmButton);

        outsideVBox.getChildren().add(mainPane);

        return deleteProductTypeScene;

    }

}
