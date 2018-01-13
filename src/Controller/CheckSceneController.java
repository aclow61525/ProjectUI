package Controller;

import Model.DatabaseConnection;
import Model.Product;
import Model.ProductService;
import Model.ReorderProduct;
import View.HomeScene;
import View.LoginScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class CheckSceneController {
    private Stage primaryStage;

    public CheckSceneController(Stage primaryStage) {
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

    public void scanDatabase(ObservableList<ReorderProduct> resultsList){
        DatabaseConnection database = new DatabaseConnection("Database/InventoryDatabase.db");

        ObservableList<Product> productList = FXCollections.observableArrayList();
        ProductService.selectAll(productList, database);

        for (int x = 0; x < productList.size(); x++){
            Product holdProduct = productList.get(x);

            int productID = holdProduct.getProductID();
            String productName = holdProduct.getProductName();
            int productStock = holdProduct.getQuantityHeld();
            int productReorderThreshold = holdProduct.getReorderThreshold();
            int productMaxQuantity = holdProduct.getMaxQuantity();
            int potentialRestockAmount = productMaxQuantity - productStock;

            if (productStock < productReorderThreshold){
                resultsList.add(new ReorderProduct(productID, productName, productStock, productMaxQuantity, potentialRestockAmount));
            }
        }

        if (resultsList != null){
            ProductService.createRestockOrder(database, resultsList);
        }
        else{
            outputAlertMessage("Something went wrong");
        }
    }

    public void outputAlertMessage(String contentText){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message from Inventory Management");
        alert.setHeaderText(null);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

}