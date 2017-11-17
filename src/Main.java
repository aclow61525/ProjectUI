package View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Inventory Management: GUI");
        primaryStage.setResizable(false);

        Scene loginScene = LoginScene.createScene(primaryStage);
        primaryStage.setScene(loginScene);

        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }

}