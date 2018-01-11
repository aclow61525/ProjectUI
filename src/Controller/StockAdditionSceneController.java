package Controller;

import Model.DatabaseConnection;
import Model.Product;
import Model.ProductService;
import View.HomeScene;
import View.LoginScene;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class StockAdditionSceneController {

    private Stage primaryStage;

    public StockAdditionSceneController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void logout() {
        Scene loginScene = LoginScene.createScene(primaryStage);
        primaryStage.setScene(loginScene);
    }

    public void exit(){
        System.exit(0);
    }

    public void openHomeScene(){
        Scene homeScene = HomeScene.createScene(primaryStage);
        primaryStage.setScene(homeScene);
    }
    public void populateDropDown(ObservableList<Product> productTypeList){
        productTypeList.clear();
        DatabaseConnection database = new DatabaseConnection("Database/InventoryDatabase.db");
        ProductService.selectAll(productTypeList, database);
    }
    public void prepareStockAddition(ComboBox<Product> inventoryItemsList, int sliderIntegerValue){
        Product selectedProduct = inventoryItemsList.getSelectionModel().getSelectedItem();

        if(sliderIntegerValue <= 0){
            outputAlertMessage("Stock Addition Must be more than zero");
            return;
        }

        int targetProductID = selectedProduct.getProductID();
        if (targetProductID < 0){
            outputAlertMessage("Product ID Invalid");
            return;
        }

        int productCurrentQuantity = selectedProduct.getQuantityHeld();
        if (productCurrentQuantity < 0){
            outputAlertMessage("Current Product quantity in database is invalid");
            return;
        }

        int productNewQuantity = productCurrentQuantity + sliderIntegerValue;
        if (productNewQuantity < 0) {
            outputAlertMessage("New product quantity is below zero");
            return;
        }

        int productMaxQuantity = selectedProduct.getMaxQuantity();
        if(productNewQuantity > productMaxQuantity){
            outputAlertMessage("The desired new quantity is higher than the max quantity");
            return;
        }

        DatabaseConnection database = new DatabaseConnection("Database/InventoryDatabase.db");

        ProductService.stockAddition(database, targetProductID, productNewQuantity);

        outputAlertMessage("Stock level now at: " + productNewQuantity + ".");
        openHomeScene();
    }

    public void outputAlertMessage(String contentText){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message from Inventory Management");
        alert.setHeaderText(null);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

}