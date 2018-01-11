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
    public void stockAddition(ComboBox inventoryItemsList, int sliderIntegerValue){
        //DatabaseConnection database = new DatabaseConnection("Database/InventoryDatabase.db");
        System.out.println(inventoryItemsList.getSelectionModel().getSelectedItem());
        Product selectedProduct = new Product(inventoryItemsList.getSelectionModel().getSelectedItem());
        System.out.println(sliderIntegerValue);
        //ProductService.selectAll(productTypeList, database);
    }
}