package Controller;

import View.StockDepletionScene;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StockDepletionSceneController {
    //Controllers are where the actions happen

    private Stage primaryStage;

    public StockDepletionSceneController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void openStockDepletionScene() {
        Scene stockDepletionScene = StockDepletionScene.createScene(primaryStage);
        primaryStage.setScene(stockDepletionScene);
    }
}