package View;

import Controller.LoginSceneController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginScene {

    public static Scene createScene(Stage primaryStage) {

        LoginSceneController lsc = new LoginSceneController(primaryStage);

        Pane borderPane = new Pane();
        Scene loginScene = new Scene(borderPane, 1024, 768);

        borderPane.getStylesheets().add("stylesheet.css");

        TextField userNameField = new TextField();
        userNameField.setPrefWidth(300);
        userNameField.setLayoutX(362);
        userNameField.setLayoutY(307.2);
        borderPane.getChildren().add(userNameField);

        TextField passwordField = new TextField();
        passwordField.setPrefWidth(300);
        passwordField.setLayoutX(362);
        passwordField.setLayoutY(460.8);
        borderPane.getChildren().add(passwordField);

        Button loginButton = new Button("Login Button");
        loginButton.setOnAction(ae -> lsc.login());
        loginButton.setPrefWidth(300);
        loginButton.setLayoutX(362);
        loginButton.setLayoutY(614.4);
        borderPane.getChildren().add(loginButton);

        return loginScene;

    }

}
