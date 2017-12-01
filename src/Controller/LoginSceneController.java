package Controller;

import View.HomeScene;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginSceneController {
    //Controllers are where the actions happen

    private Stage primaryStage;

    public LoginSceneController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void openLoginScene() {

        Scene homeScene = HomeScene.createScene(primaryStage);
        primaryStage.setScene(homeScene);

    }
}