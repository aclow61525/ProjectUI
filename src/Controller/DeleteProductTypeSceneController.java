package Controller;

import View.DeleteProductTypeScene;
import View.HomeScene;
import View.LoginScene;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DeleteProductTypeSceneController {
    //Controllers are where the actions happen

    private Stage primaryStage;

    public DeleteProductTypeSceneController(Stage primaryStage) {
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
}