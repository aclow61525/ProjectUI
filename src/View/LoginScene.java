package View;

import Controller.LoginSceneController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginScene {

    public static Scene createScene(Stage primaryStage) {

        LoginSceneController controller = new LoginSceneController(primaryStage);

        Pane borderPane = new Pane();
        Scene loginScene = new Scene(borderPane, 1024, 768);

        borderPane.getStylesheets().add("stylesheet.css");

        Button loginButton = new Button("Login Button");
        loginButton.setOnAction(ae -> controller.login());
        loginButton.setLayoutX(512);
        loginButton.setLayoutY(200);
        borderPane.getChildren().add(loginButton);

        return loginScene;

    }

}
