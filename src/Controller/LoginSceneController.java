package Controller;

import View.HomeScene;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginSceneController {
    //Instance variables

    private Stage primaryStage;

    public LoginSceneController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void login() {

        Scene homeScene = HomeScene.createScene(primaryStage);
        primaryStage.setScene(homeScene);

    }

}