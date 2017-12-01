package Controller;

import View.CheckScene;
import View.HomeScene;
import View.LoginScene;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
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
    public void prepareCheck(Button homeButton, Button checkButton){
        homeButton.setText("Home Unavailable");
        //homeButton.setDisable(true);

        System.out.println("2");

        checkButton.setText("Running check...");
        //checkButton.setDisable(true);

        scanDatabase();

        System.out.println("4");

        homeButton.setDisable(false);
        homeButton.setText("Home");

        checkButton.setDisable(false);
        checkButton.setText("Check complete");
    }

    public void scanDatabase(){
        System.out.println("Will do a database check here");

        try{
            TimeUnit.SECONDS.sleep(3);
        }catch(InterruptedException ie){
            System.out.println("Didn't work");
        }

    }

}