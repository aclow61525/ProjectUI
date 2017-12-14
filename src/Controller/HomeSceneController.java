package Controller;

import View.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeSceneController {
    //Controllers are where the actions happen
    private Stage primaryStage;

    public HomeSceneController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void logout() {
        Scene loginScene = LoginScene.createScene(primaryStage);
        primaryStage.setScene(loginScene);
    }
    public void openDeleteProductTypeScene(){
        Scene deleteProductTypeScene = DeleteProductTypeScene.createScene(primaryStage);
        primaryStage.setScene(deleteProductTypeScene);
    }
    public void openCreateProductTypeScene(){
        Scene createProductTypeScene = CreateProductTypeScene.createScene(primaryStage);
        primaryStage.setScene(createProductTypeScene);
    }
    public void openCheckScene(){
        Scene checkScene = CheckScene.createScene(primaryStage);
        primaryStage.setScene(checkScene);
    }
    public void openStockAdditionScene(){
        Scene stockAdditionScene = StockAdditionScene.createScene(primaryStage);
        primaryStage.setScene(stockAdditionScene);
    }
    public void openStockDepletionScene(){
        Scene stockDepletionScene = StockReductionScene.createScene(primaryStage);
        primaryStage.setScene(stockDepletionScene);
    }
    public void exit(){
        System.exit(0);
    }

}