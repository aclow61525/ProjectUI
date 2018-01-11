package View;

import Controller.StockReductionSceneController;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StockReductionScene {

    public static Scene createScene(Stage primaryStage) {

        StockReductionSceneController controller = new StockReductionSceneController(primaryStage);

        VBox outsideVBox = new VBox();
        Scene stockReductionScene = new Scene(outsideVBox, 1024, 576);

        stockReductionScene.getStylesheets().add("stylesheet.css");
        outsideVBox.getStyleClass().add("Pages");

        //Menu Bar
        MenuBar myMenu = new MenuBar();
        myMenu.setMinHeight(20);

        Menu loginMenu = new Menu("Login Options");
        MenuItem loginMenuItem1 = new MenuItem("Logout");
        loginMenuItem1.setOnAction(ae -> controller.logout());
        MenuItem loginMenuItem2 = new MenuItem("Exit the program");
        loginMenuItem2.setOnAction(ae -> controller.exit());
        loginMenu.getItems().addAll(loginMenuItem1, loginMenuItem2);

        myMenu.getMenus().addAll(loginMenu);
        outsideVBox.getChildren().add(myMenu);

        Text pageTitle = new Text();
        pageTitle.setText("Record reduction of Stock levels");
        pageTitle.setFont(Font.font("Segoe UI Light", FontWeight.BOLD, 40));
        outsideVBox.getChildren().add(pageTitle);

        Pane mainPane = new Pane();

        ObservableList<Product> productTypeList = FXCollections.observableArrayList();
        controller.populateDropDown(productTypeList);

        ComboBox<Product> inventoryItemsList = new ComboBox<>(productTypeList);
        inventoryItemsList.setPromptText("Select an item from the database");
        inventoryItemsList.setPrefWidth(300);
        inventoryItemsList.setLayoutX(362);
        inventoryItemsList.setLayoutY(86);
        inventoryItemsList.getStyleClass().add("combo-box");
        mainPane.getChildren().add(inventoryItemsList);

        TextField reductionLevelEntry = new TextField();
        reductionLevelEntry.setPromptText("Level of reduction");
        reductionLevelEntry.setEditable(false);
        reductionLevelEntry.setPrefWidth(300);
        reductionLevelEntry.setLayoutX(362);
        reductionLevelEntry.setLayoutY(172);

        mainPane.getChildren().add(reductionLevelEntry);

        Slider quantitySlider = new Slider(); //Declares a new Slider Control
        quantitySlider.setMin(0); //Sets the min value of the slider to be 0
        quantitySlider.setMax(100); //Sets the max value of the slider to be 100
        quantitySlider.setValue(50);    //The default slider position is set to 50
        quantitySlider.setMajorTickUnit(10); //Sets each milestone 'tick' (point) to be every 10, this is what's labelled
        quantitySlider.setBlockIncrement(1); //TThe amount by which to adjust the slider if the bar of the slider is clicked
        quantitySlider.setShowTickLabels(true); //This enables the label of the key milestone slider values (ticks), set to 10
        quantitySlider.setPrefWidth(300); //Sets the width of the slider to be 300
        quantitySlider.setLayoutX(362); //Sets the X co-ordinate position of the slider within the pane
        quantitySlider.setLayoutY(258); //Sets the Y co-ordinate position of the slider within the pane
        mainPane.getChildren().add(quantitySlider); //Adds the slider to the Pane

        quantitySlider.valueProperty().addListener((observable, old_value, new_value) -> {
            int sliderIntegerValue = (new_value.intValue());
            reductionLevelEntry.setText("Reducing stock level by: " + (sliderIntegerValue));
        });

        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(ae -> controller.openHomeScene());
        cancelButton.setPrefWidth(300);
        cancelButton.setLayoutX(207);
        cancelButton.setLayoutY(402);
        cancelButton.getStyleClass().add("allButton");
        mainPane.getChildren().add(cancelButton);

        Button confirmButton = new Button("Confirm");
        confirmButton.setOnAction(ae -> {
            int sliderIntegerValue = quantitySlider.valueProperty().intValue();
            controller.prepareStockReduction(inventoryItemsList, sliderIntegerValue);
        });
        confirmButton.setPrefWidth(300);
        confirmButton.setLayoutX(517);
        confirmButton.setLayoutY(402);
        confirmButton.getStyleClass().add("allButton");
        mainPane.getChildren().add(confirmButton);

        outsideVBox.getChildren().add(mainPane);

        return stockReductionScene;
    }

}
