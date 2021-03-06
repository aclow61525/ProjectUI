package View;

import Controller.HomeSceneController;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomeScene {
    private static ObservableList<Product> productList = FXCollections.observableArrayList();

    public static Scene createScene(Stage primaryStage) {

        HomeSceneController controller = new HomeSceneController(primaryStage);

        VBox outsideVBox = new VBox();
        Scene homeScene = new Scene(outsideVBox, 1024, 576);

        homeScene.getStylesheets().add("stylesheet.css");
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

        Menu fileMenu = new Menu("Database");
        MenuItem fileMenuItem1 = new MenuItem("Refresh Database");
        fileMenuItem1.setOnAction(ae -> controller.populateTable(productList));
        fileMenu.getItems().addAll(fileMenuItem1);

        Menu productMenu = new Menu("Product");
        MenuItem productMenuItem1 = new MenuItem("Add new product type");
        productMenuItem1.setOnAction(ae -> controller.openCreateProductTypeScene());
        MenuItem productMenuItem2 = new MenuItem("Delete Product Type");
        productMenuItem2.setOnAction(ae -> controller.openDeleteProductTypeScene());
        productMenu.getItems().addAll(productMenuItem1, productMenuItem2);

        myMenu.getMenus().addAll(loginMenu, fileMenu, productMenu);
        outsideVBox.getChildren().add(myMenu);

        Text pageTitle = new Text();
        pageTitle.setText("Home Page");
        pageTitle.setFont(Font.font("Segoe UI Light", FontWeight.BOLD, 40));
        outsideVBox.getChildren().add(pageTitle);

        HBox quickFunctionsBar = new HBox(208);

        Button[] quickButtons = new Button[4];

        quickButtons[0] = new Button("+");
        quickButtons[0].setPrefSize(100, 50);
        quickButtons[0].getStyleClass().add("symbolButton");
        quickButtons[0].setOnAction((ActionEvent ae) -> controller.openStockAdditionScene());

        quickButtons[1] = new Button("-");
        quickButtons[1].setPrefSize(100, 50);
        quickButtons[1].getStyleClass().add("symbolButton");
        quickButtons[1].setOnAction((ActionEvent ae) -> controller.openStockReductionScene());

        quickButtons[2] = new Button("REFRESH");
        quickButtons[2].setPrefSize(100, 50);
        quickButtons[2].getStyleClass().add("allButton");
        quickButtons[2].setOnAction((ActionEvent ae) -> controller.populateTable(productList));

        quickButtons[3] = new Button("CHECK");
        quickButtons[3].setPrefSize(100, 50);
        quickButtons[3].getStyleClass().add("allButton");
        quickButtons[3].setOnAction((ActionEvent ae) -> controller.openCheckScene());

        quickFunctionsBar.getChildren().addAll(quickButtons);

        outsideVBox.getChildren().add(quickFunctionsBar);

        Pane mainPane = new Pane();

        //TableView
        TableView inventoryTable = new TableView();
        inventoryTable.setEditable(false);
        TableColumn productID = new TableColumn("ID");
        productID.setPrefWidth(50);
        TableColumn productName = new TableColumn("Name");
        productName.setPrefWidth(180);
        TableColumn quantityHeld = new TableColumn("In Stock");
        quantityHeld.setPrefWidth(160);
        TableColumn reorderLevel = new TableColumn("Reorder Level");
        reorderLevel.setPrefWidth(195);
        TableColumn maxQuantity = new TableColumn("Max Level");
        maxQuantity.setPrefWidth(170);
        TableColumn productWidth = new TableColumn("Width");
        productWidth.setPrefWidth(100);
        TableColumn productHeight = new TableColumn("Height");
        productHeight.setPrefWidth(100);
        TableColumn productDepth = new TableColumn("Depth");
        productDepth.setPrefWidth(100);
        TableColumn productWeight = new TableColumn("Weight");
        productWeight.setPrefWidth(110);

        inventoryTable.getColumns().addAll(productID, productName, quantityHeld, reorderLevel, maxQuantity, productWidth, productHeight, productDepth, productWeight);
        inventoryTable.setPrefWidth(1000);
        inventoryTable.setLayoutX(12);

        inventoryTable.setLayoutY(10);
        inventoryTable.setPrefHeight(430);

        controller.populateTable(productList);

        inventoryTable.setItems(productList);

        productID.setCellValueFactory(new PropertyValueFactory<>("productID"));
        productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        productWidth.setCellValueFactory(new PropertyValueFactory<>("productWidth"));
        productHeight.setCellValueFactory(new PropertyValueFactory<>("productHeight"));
        productDepth.setCellValueFactory(new PropertyValueFactory<>("productDepth"));
        productWeight.setCellValueFactory(new PropertyValueFactory<>("productWeight"));
        quantityHeld.setCellValueFactory(new PropertyValueFactory<>("quantityHeld"));
        reorderLevel.setCellValueFactory(new PropertyValueFactory<>("reorderThreshold"));
        maxQuantity.setCellValueFactory(new PropertyValueFactory<>("maxQuantity"));

        mainPane.getChildren().add(inventoryTable);

        outsideVBox.getChildren().add(mainPane);

        return homeScene;

    }

}
