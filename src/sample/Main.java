package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    //Instance variables
    public static Stage primaryStage;
    public static LoginSceneController lsc;
    public static HomeSceneController hsc;

    @Override
    public void start(Stage primaryStage) throws Exception {
        lsc = new LoginSceneController();
        hsc = new HomeSceneController();

        primaryStage.setTitle("Inventory Management: GUI");
        primaryStage.setScene(lsc.loginScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
        public static void main(String[] args) {
        launch(args);
    }
}
