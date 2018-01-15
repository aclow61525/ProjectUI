package View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Inventory Management GUI Prototype");
        primaryStage.setResizable(false);

        Scene loginScene = LoginScene.createScene(primaryStage);
        primaryStage.setScene(loginScene);
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("../Resources/ProjectLogo.png")));

        primaryStage.show();

    }

}