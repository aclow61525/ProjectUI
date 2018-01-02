package View;

import Controller.LoginSceneController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginScene {

    public static Scene createScene(Stage primaryStage) {

        LoginSceneController controller = new LoginSceneController(primaryStage);

        VBox outsideVBox = new VBox();
        Scene loginScene = new Scene(outsideVBox, 1024, 576);

        loginScene.getStylesheets().add("stylesheet.css");
        outsideVBox.getStyleClass().add("Pages");

        Text pageTitle = new Text();
        pageTitle.setText("Login");
        pageTitle.setFont(Font.font("Segoe UI Light", FontWeight.BOLD, 40));
        outsideVBox.getChildren().add(pageTitle);

        Pane mainPane = new Pane();

        TextField userNameField = new TextField();
        userNameField.setPromptText("Username");
        userNameField.setPrefWidth(300);
        userNameField.setLayoutX(362);
        userNameField.setLayoutY(134);
        mainPane.getChildren().add(userNameField);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setPrefWidth(300);
        passwordField.setLayoutX(362);
        passwordField.setLayoutY(268);
        mainPane.getChildren().add(passwordField);

        Button loginButton = new Button("Login");
        loginButton.setOnAction(ae -> controller.openLoginScene());
        loginButton.setPrefWidth(300);
        loginButton.setLayoutX(362);
        loginButton.setLayoutY(402);
        loginButton.getStyleClass().add("allButton");
        mainPane.getChildren().add(loginButton);

        outsideVBox.getChildren().add(mainPane);

        return loginScene;

    }

}
