package Controller;

import Model.DatabaseConnection;
import Model.Product;
import Model.ProductService;
import View.HomeScene;
import View.LoginScene;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
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
    public void stockAddition(ComboBox<Product> inventoryItemsList, int sliderIntegerValue){
        DatabaseConnection database = new DatabaseConnection("Database/InventoryDatabase.db");
        ProductService.stockAddition(database);

        System.out.println(inventoryItemsList.getSelectionModel().getSelectedItem());
        Product selectedProduct = inventoryItemsList.getSelectionModel().getSelectedItem();

        System.out.println("Before " + selectedProduct + ": " + selectedProduct.getQuantityHeld());

        selectedProduct.setQuantityHeld(selectedProduct.getQuantityHeld() + sliderIntegerValue);

        System.out.println("After " + selectedProduct + ": " + selectedProduct.getQuantityHeld());

        //ProductService.selectAll(productTypeList, database);
    }
}