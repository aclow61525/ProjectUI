package Controller;

import View.LoginScene;
import View.CheckScene;
import View.StockDepletionScene;
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
    public void openCheckScene(){
        Scene checkScene = CheckScene.createScene(primaryStage);
        primaryStage.setScene(checkScene);

    }
    public void openStockDepletionScene(){
        Scene stockDepletionScene = StockDepletionScene.createScene(primaryStage);
        primaryStage.setScene(stockDepletionScene);
    }
    public void exit(){
        System.exit(0);
    }

}