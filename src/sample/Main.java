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
    public void start(Stage stage) throws Exception {

        Pane root = new Pane();

        Scene scene = new Scene(root, 1024, 768);
        scene.getStylesheets().add("stylesheet.css");

        stage.setTitle("Graphical User Interface");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        MenuBar myMenu = new MenuBar();

        Menu numbersMenu = new Menu("Numbers");
        MenuItem numbersItem1 = new MenuItem("One");
        MenuItem numbersItem2 = new MenuItem("Two");
        MenuItem numbersItem3 = new MenuItem("Three");
        numbersMenu.getItems().addAll(numbersItem1, numbersItem2, numbersItem3);

        Menu coloursMenu = new Menu("Colours");
        MenuItem coloursItem1 = new MenuItem("Red");
        MenuItem coloursItem2 = new MenuItem("Green");
        MenuItem coloursItem3 = new MenuItem("Blue");
        coloursMenu.getItems().addAll(coloursItem1, coloursItem2, coloursItem3);

        Menu shapesMenu = new Menu("Shapes");
        MenuItem shapesItem1 = new MenuItem("Triangle");
        MenuItem shapesItem2 = new MenuItem("Square");
        MenuItem shapesItem3 = new MenuItem("Circle");
        shapesMenu.getItems().addAll(shapesItem1, shapesItem2, shapesItem3);

        myMenu.getMenus().addAll(numbersMenu, coloursMenu, shapesMenu);
        root.getChildren().add(myMenu);

        /*Button myButton = new Button("Click me!");
        myButton.setPrefSize(100, 35);
        myButton.setOnAction((ActionEvent ae) -> doSomething(ae));
        myButton.getStyleClass().add("normal_button");
        root.getChildren().add(myButton);*/

        Button someButton = new Button("Open STwo");
        someButton.setPrefSize(125, 35);
        someButton.setLayoutX(250);
        someButton.setLayoutY(250);
        someButton.setOnAction((ActionEvent ae) -> openNewStage(root));
        root.getChildren().add(someButton);

        //Can change to horizontal by changing V to H
        HBox boxOfButtons = new HBox(10);
        boxOfButtons.setLayoutY(300);
        Button[] multiButtons = new Button[5];

        multiButtons[0] = new Button("Button number one");
        multiButtons[0].setPrefSize(200, 50);
        multiButtons[0].getStyleClass().add("normal_button");
        multiButtons[0].setOnAction((ActionEvent ae) -> doSomething(ae));

        multiButtons[1] = new Button("Button number two");
        multiButtons[1].setPrefSize(200, 50);
        multiButtons[1].getStyleClass().add("normal_button");
        multiButtons[1].setOnAction((ActionEvent ae) -> doSomething(ae));

        multiButtons[2] = new Button("Button number three");
        multiButtons[2].setPrefSize(200, 50);
        multiButtons[2].getStyleClass().add("normal_button");
        multiButtons[2].setOnAction((ActionEvent ae) -> doSomething(ae));

        multiButtons[3] = new Button("Button number four");
        multiButtons[3].setPrefSize(200, 50);
        multiButtons[3].getStyleClass().add("normal_button");
        multiButtons[3].setOnAction((ActionEvent ae) -> doSomething(ae));

        multiButtons[4] = new Button("Button number five");
        multiButtons[4].setPrefSize(200, 50);
        multiButtons[4].getStyleClass().add("normal_button");
        multiButtons[4].setOnAction((ActionEvent ae) -> doSomething(ae));

        boxOfButtons.setPadding(new Insets(10));
        boxOfButtons.getChildren().addAll(multiButtons);

        root.getChildren().add(boxOfButtons);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void doSomething(ActionEvent ae) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Wow, you clicked the button with style!");
        alert.showAndWait();
    }
    public static void openNewStage(Pane parent) {
        StageTwo newStage = new StageTwo(parent);
    }
}
