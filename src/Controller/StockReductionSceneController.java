package Controller;

import View.HomeScene;
import View.LoginScene;
import View.StockReductionScene;
import View.StockReductionScene;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StockReductionSceneController {
    //Controllers are where the actions happen

    private Stage primaryStage;

    public StockReductionSceneController(Stage primaryStage) {
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

    public void openStockDepletionScene() {
        Scene stockDepletionScene = StockReductionScene.createScene(primaryStage);
        primaryStage.setScene(stockDepletionScene);
    }
}