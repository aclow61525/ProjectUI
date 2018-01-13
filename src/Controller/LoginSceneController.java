package Controller;

import View.HomeScene;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginSceneController {

    private Stage primaryStage;

    public LoginSceneController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void openHomeScene() {
        Scene homeScene = HomeScene.createScene(primaryStage);
        primaryStage.setScene(homeScene);
    }

    public void checkLoginCredentials(TextField customerIDField, PasswordField passwordField){
        String givenUserID = customerIDField.getText();

        if (givenUserID.length() != 5){
            outputAlertMessage("UserID is incorrect");
            return;
        }

        if (!givenUserID.matches("12114")){
            outputAlertMessage("UserID is incorrect");
            return;
        }

        String givenPassword = passwordField.getText();

        if (!givenPassword.matches("SecurePassword_1")){
            outputAlertMessage("Password is incorrect");
            return;
        }
        openHomeScene();

    }

    public void outputAlertMessage(String contentText){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Message from Inventory Management");
        alert.setHeaderText(null);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
}