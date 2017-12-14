package Controller;

import View.HomeScene;
import View.LoginScene;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

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

    public void openHomeScene(){
        Scene homeScene = HomeScene.createScene(primaryStage);
        primaryStage.setScene(homeScene);
    }

    public void scanDatabase(){
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch(InterruptedException ie){
            System.out.println("Didn't work");
        }
        System.out.println("Insert stock check here");
    }

}