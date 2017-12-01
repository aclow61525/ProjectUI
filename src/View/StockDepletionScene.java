package View;

import Controller.LoginSceneController;
import Controller.StockDepletionSceneController;
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

public class StockDepletionScene {

    public static Scene createScene(Stage primaryStage) {

        StockDepletionSceneController controller = new StockDepletionSceneController(primaryStage);

        VBox outsideVBox = new VBox();
        Scene loginScene = new Scene(outsideVBox, 1024, 576);

        loginScene.getStylesheets().add("stylesheet.css");
        outsideVBox.getStyleClass().add("Pages");

        Text pageTitle = new Text();
        pageTitle.setText("stockkkkkkkkkkk");
        pageTitle.setFont(Font.font("Segoe UI Light", FontWeight.BOLD, 40));
        outsideVBox.getChildren().add(pageTitle);

        Pane borderPane = new Pane();

        TextField userNameField = new TextField();
        userNameField.setPromptText("Username");
        //userNameField.setFocusTraversable(false);
        userNameField.setPrefWidth(300);
        userNameField.setLayoutX(362);
        userNameField.setLayoutY(134);
        borderPane.getChildren().add(userNameField);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        //passwordField.setFocusTraversable(false);
        passwordField.setPrefWidth(300);
        passwordField.setLayoutX(362);
        passwordField.setLayoutY(268);
        borderPane.getChildren().add(passwordField);

        Button loginButton = new Button("Hello");
        //loginButton.setOnAction(ae -> controller.openLoginScene());
        loginButton.setPrefWidth(300);
        loginButton.setLayoutX(362);
        loginButton.setLayoutY(402);
        loginButton.getStyleClass().add("allButton");
        borderPane.getChildren().add(loginButton);

        outsideVBox.getChildren().add(borderPane);

        return loginScene;

    }

}
