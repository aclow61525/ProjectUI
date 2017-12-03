package Controller;

import View.HomeScene;
import View.LoginScene;
import View.StockAdditionScene;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StockAdditionSceneController {
    //Controllers are where the actions happen

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

    public void openStockAdditionScene() {
        Scene stockAdditionScene = StockAdditionScene.createScene(primaryStage);
        primaryStage.setScene(stockAdditionScene);
    }
}