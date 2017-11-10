package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.layout.BorderPane;
import javafx.scene.layout.*;


public class LoginSceneController {
    //Instance variables
    BorderPane borderPane;
    Scene loginScene;
    public LoginSceneController() {
        borderPane = new BorderPane();
        loginScene = new Scene(borderPane,1024,768);

        borderPane.getStylesheets().add("stylesheet.css");

        Button loginButton = new Button("Login Button");
        loginButton.setOnAction(ae -> primaryStage.setScene(hsc.homeScene));
        loginButton.setLayoutX(512);
        loginButton.setLayoutY(200);
        borderPane.getChildren().add(loginButton);
    }
}