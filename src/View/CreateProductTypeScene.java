package View;

import Controller.CreateProductTypeSceneController;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreateProductTypeScene {

    public static Scene createScene(Stage primaryStage) {

        CreateProductTypeSceneController controller = new CreateProductTypeSceneController(primaryStage);

        VBox outsideVBox = new VBox();
        Scene createProductTypeScene = new Scene(outsideVBox, 1024, 576);

        createProductTypeScene.getStylesheets().add("stylesheet.css");
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
        pageTitle.setText("Create Product Type");
        pageTitle.setFont(Font.font("Segoe UI Light", FontWeight.BOLD, 40));
        outsideVBox.getChildren().add(pageTitle);

        Pane mainPane = new Pane();

        //Left Column

        TextField productNameTF = new TextField();
        productNameTF.setPromptText("Product Name");
        productNameTF.setPrefWidth(477);
        productNameTF.setLayoutX(10);
        productNameTF.setLayoutY(10);
        mainPane.getChildren().add(productNameTF);

        TextField initialStockQuantityTF = new TextField();
        initialStockQuantityTF.setPromptText("Initial Quantity of Stock (Units)");
        initialStockQuantityTF.setPrefWidth(477);
        initialStockQuantityTF.setLayoutX(10);
        initialStockQuantityTF.setLayoutY(119);
        mainPane.getChildren().add(initialStockQuantityTF);

        TextField maxStockQuantityTF = new TextField();
        maxStockQuantityTF.setPromptText("Max Level of Stock (Units)");
        maxStockQuantityTF.setPrefWidth(477);
        maxStockQuantityTF.setLayoutX(10);
        maxStockQuantityTF.setLayoutY(228);
        mainPane.getChildren().add(maxStockQuantityTF);

        TextField reorderThresholdTF = new TextField();
        reorderThresholdTF.setPromptText("Reorder Threshold (Units)");
        reorderThresholdTF.setPrefWidth(477);
        reorderThresholdTF.setLayoutX(10);
        reorderThresholdTF.setLayoutY(337);
        mainPane.getChildren().add(reorderThresholdTF);

        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(ae -> controller.openHomeScene());
        cancelButton.setPrefWidth(300);
        cancelButton.setLayoutX(98.5);
        cancelButton.setLayoutY(446);
        cancelButton.getStyleClass().add("allButton");
        mainPane.getChildren().add(cancelButton);

        //Right Column

        TextField productWidthTF = new TextField();
        productWidthTF.setPromptText("Product Width (cm)");
        productWidthTF.setPrefWidth(477);
        productWidthTF.setLayoutX(537);
        productWidthTF.setLayoutY(10);
        mainPane.getChildren().add(productWidthTF);

        TextField productHeightTF = new TextField();
        productHeightTF.setPromptText("Product Height (cm)");
        productHeightTF.setPrefWidth(477);
        productHeightTF.setLayoutX(537);
        productHeightTF.setLayoutY(119);
        mainPane.getChildren().add(productHeightTF);

        TextField productDepthTF = new TextField();
        productDepthTF.setPromptText("Product Depth (cm)");
        productDepthTF.setPrefWidth(477);
        productDepthTF.setLayoutX(537);
        productDepthTF.setLayoutY(228);
        mainPane.getChildren().add(productDepthTF);

        TextField productWeightTF = new TextField();
        productWeightTF.setPromptText("Product Weight (grams)");
        productWeightTF.setPrefWidth(477);
        productWeightTF.setLayoutX(537);
        productWeightTF.setLayoutY(337);
        mainPane.getChildren().add(productWeightTF);

        Button confirmButton = new Button("Confirm");
        //confirmButton.setOnAction(ae -> controller.opencreateProductTypeScene());
        confirmButton.setPrefWidth(300);
        confirmButton.setLayoutX(635.5);
        confirmButton.setLayoutY(446);
        confirmButton.getStyleClass().add("allButton");
        mainPane.getChildren().add(confirmButton);

        outsideVBox.getChildren().add(mainPane);

        return createProductTypeScene;

    }
}