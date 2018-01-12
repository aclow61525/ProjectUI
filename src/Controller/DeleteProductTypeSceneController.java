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

public class DeleteProductTypeSceneController {

    private Stage primaryStage;

    public DeleteProductTypeSceneController(Stage primaryStage) {
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

    public void prepareProductDeletion(ComboBox<Product> inventoryItemsList){
        Product selectedProduct = inventoryItemsList.getSelectionModel().getSelectedItem();
        int selectedProductID = selectedProduct.getProductID();

        DatabaseConnection database = new DatabaseConnection("Database/InventoryDatabase.db");

        ProductService.deleteProductType(database, selectedProductID);

        outputAlertMessage(selectedProduct.getProductName() + " deleted successfully!");
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