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

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane loginPage = new Pane();
        Scene scene1 = new Scene(loginPage, 1024, 768);

        Pane mainPage = new Pane();
        Scene scene2 = new Scene(mainPage, 1024, 768);

        loginPage.getStylesheets().add("stylesheet.css");
        mainPage.getStylesheets().add("stylesheet.css");

        primaryStage.setTitle("Inventory Management: GUI");
        primaryStage.setScene(scene1);
        primaryStage.setResizable(false);
        primaryStage.show();

        Button loginButton = new Button("Login Button");
        loginButton.setOnAction(ae -> primaryStage.setScene(scene2));
        loginPage.getChildren().add(loginButton);

        //Menu Bar
        MenuBar myMenu = new MenuBar();

        Menu fileMenu = new Menu("File");
        MenuItem fileMenuItem1 = new MenuItem("Reload");
        fileMenu.getItems().addAll(fileMenuItem1);

        Menu productMenu = new Menu("Product");
        MenuItem productMenuItem1 = new MenuItem("Add new product type");
        MenuItem productMenuItem2 = new MenuItem("Delete Product Type");
        productMenu.getItems().addAll(productMenuItem1, productMenuItem2);

        Menu loginMenu = new Menu("Login Options");
        MenuItem loginMenuItem1 = new MenuItem("Logout");
        loginMenuItem1.setOnAction(ae -> primaryStage.setScene(scene1));
        loginMenu.getItems().addAll(loginMenuItem1);

        myMenu.getMenus().addAll(fileMenu, productMenu, loginMenu);
        mainPage.getChildren().add(myMenu);
        loginPage.getChildren().add(myMenu);//Need to rearrange this
    }
        public static void main(String[] args) {
        launch(args);
    }
}
