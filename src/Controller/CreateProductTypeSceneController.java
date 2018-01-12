package Controller;

import Model.DatabaseConnection;
import Model.Product;
import Model.ProductService;
import View.HomeScene;
import View.LoginScene;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.Arrays;

public class CreateProductTypeSceneController {

    private Stage primaryStage;

    public CreateProductTypeSceneController(Stage primaryStage) {
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

    public void prepareCreateProductType(String[] textFieldInputs){
        int initialStockQuantity;
        try{
            initialStockQuantity = Integer.parseInt(textFieldInputs[1]);
        }catch(Exception a){
            outputAlertMessage("Error with Initial Stock Quantity Value");
            return;
        }

        int maxStockQuantity;
        try{
            maxStockQuantity = Integer.parseInt(textFieldInputs[2]);
        }catch(Exception b){
            outputAlertMessage("Error with Max Stock Quantity Value");
            return;
        }

        int reorderThreshold;
        try{
            reorderThreshold = Integer.parseInt(textFieldInputs[3]);
        }catch(Exception c){
            outputAlertMessage("Error with Reorder Threshold Value");
            return;
        }

        int productWidth;
        try{
            productWidth = Integer.parseInt(textFieldInputs[4]);
        }catch(Exception d){
            outputAlertMessage("Error with Product Width Value");
            return;
        }

        int productHeight;
        try{
            productHeight = Integer.parseInt(textFieldInputs[5]);
        }catch(Exception e){
            outputAlertMessage("Error with Product Height Value");
            return;
        }

        int productDepth;
        try{
            productDepth = Integer.parseInt(textFieldInputs[6]);
        }catch(Exception f){
            outputAlertMessage("Error with Product Depth Value");
            return;
        }

        double productWeight;
        try{
            productWeight = Double.parseDouble(textFieldInputs[7]);
        }catch(Exception g){
            outputAlertMessage("Error with Product Weight Value");
            return;
        }

        if(reorderThreshold <= 0){
            outputAlertMessage("Reorder Threshold must be higher than 0");
            return;
        }
        if(reorderThreshold > 1000){
            outputAlertMessage("Reorder Threshold must be 1000 or lower");
            return;
        }

        if(maxStockQuantity <=0){
            outputAlertMessage("Max Stock Level must be higher than 0");
            return;
        }

        if(maxStockQuantity > 1000){
            outputAlertMessage("Max Stock level must be 1000 or lower");
            return;
        }

        if(reorderThreshold >= maxStockQuantity){
            outputAlertMessage("Reorder Threshold cannot be higher or equal to max level");
            return;
        }

        if(initialStockQuantity > maxStockQuantity){
            outputAlertMessage("Stock Quantity is higher than Max Level entered");
            return;
        }

        DatabaseConnection database = new DatabaseConnection("Database/InventoryDatabase.db");

        try {
            ProductService.createNewProduct(database, textFieldInputs);
        } catch (SQLException e) {
            outputAlertMessage("Something went wrong");
            e.printStackTrace();
            return;
        }

        outputAlertMessage("New product created successfully!");
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
