package Controller;

import View.LoginScene;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CheckSceneController {
    //Controllers are where the actions happen
    private Stage primaryStage;

    public CheckSceneController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void logout() {

        Scene loginScene = LoginScene.createScene(primaryStage);
        primaryStage.setScene(loginScene);

    }
    public void exit(){
        System.exit(0);
    }

}