package Controller;

import View.LoginScene;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeSceneController {

    private Stage primaryStage;

    public HomeSceneController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void logout() {

        Scene loginScene = LoginScene.createScene(primaryStage);
        primaryStage.setScene(loginScene);

    }

}