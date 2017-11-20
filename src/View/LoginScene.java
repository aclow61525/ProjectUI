package View;

import Controller.LoginSceneController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginScene {

    public static Scene createScene(Stage primaryStage) {

        LoginSceneController lsc = new LoginSceneController(primaryStage);

        VBox outsideVBox = new VBox();
        Scene loginScene = new Scene(outsideVBox, 1024, 576);

        Text pageTitle = new Text();
        pageTitle.setText("Login");
        pageTitle.setFont(Font.font("helvetica", FontWeight.BOLD, 40));
        outsideVBox.getChildren().add(pageTitle);

        Pane borderPane = new Pane();

        TextField userNameField = new TextField();
        userNameField.setPrefWidth(300);
        userNameField.setLayoutX(362);
        userNameField.setLayoutY(134);
        borderPane.getChildren().add(userNameField);

        PasswordField passwordField = new PasswordField();
        passwordField.setPrefWidth(300);
        passwordField.setLayoutX(362);
        passwordField.setLayoutY(268);
        borderPane.getChildren().add(passwordField);

        Button loginButton = new Button("Login Button");
        loginButton.setOnAction(ae -> lsc.login());
        loginButton.setPrefWidth(300);
        loginButton.setLayoutX(362);
        loginButton.setLayoutY(402);
        borderPane.getChildren().add(loginButton);

        outsideVBox.getChildren().add(borderPane);

        return loginScene;

    }

}
