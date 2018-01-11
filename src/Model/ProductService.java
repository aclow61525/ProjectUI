package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductService {
    public static void selectAll(List<Product> productList, DatabaseConnection database) {

        PreparedStatement selectAllStatement = database.newStatement("SELECT * FROM ProductDetails ORDER BY productID");

        try {
            if (selectAllStatement != null) {

                ResultSet results = database.executeQuery(selectAllStatement);

                if (results != null) {
                    while (results.next()) {
                        productList.add(new Product(
                                results.getInt("productID"),
                                results.getString("productName"),
                                results.getInt("productWidth"),
                                results.getInt("productHeight"),
                                results.getInt("productDepth"),
                                results.getDouble("productWeight"),
                                results.getInt("quantityHeld"),
                                results.getInt("reorderThreshold"),
                                results.getInt("maxQuantity")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.err.println("Database select all error: " + resultsException.getMessage());
        }
        database.disconnect();
    }
    public static void stockUpdate(DatabaseConnection database, int targetProductID, int productNewQuantity) {
        PreparedStatement stockAdditionStatement = database.newStatement("UPDATE ProductDetails SET quantityHeld = " + productNewQuantity + " WHERE productID = " + targetProductID + ";");

        try {
            if (stockAdditionStatement != null) {
                database.executeUpdate(stockAdditionStatement);
            }
        } catch (Exception ex) {
            System.err.println("Database update error: " + ex.getMessage());
        }

        database.disconnect();
    }
    public static void createNewProduct(DatabaseConnection database, String[] testFieldInputs) {
        PreparedStatement productCreationStatement = database.newStatement("INSERT INTO ProductDetails (ProductName, ProductWidth, ProductHeight, ProductDepth, ProductWeight, QuantityHeld, ReorderThreshold, MaxQuantity) VALUES (" + testFieldInputs[0] + ", " + testFieldInputs[4] + ", " + testFieldInputs[5] + ", " + testFieldInputs[6] + ", " + testFieldInputs[7] + ", " + testFieldInputs[1] + ", " + testFieldInputs[3] + ", " + testFieldInputs[2] + ")");


        /*textFieldInputs[0] =  productNameTF.getText();
        textFieldInputs[1] =  initialStockQuantityTF.getText();
        textFieldInputs[2] =  maxStockQuantityTF.getText();
        textFieldInputs[3] =  reorderThresholdTF.getText();
        textFieldInputs[4] =  productWidthTF.getText();
        textFieldInputs[5] =  productHeightTF.getText();
        textFieldInputs[6] =  productDepthTF.getText();
        textFieldInputs[7] =  productWeightTF.getText();*/

        try {
            if (productCreationStatement != null) {
                database.executeUpdate(productCreationStatement);
            }
        } catch (Exception ex) {
            System.err.println("Database create product error: " + ex.getMessage());
        }

        database.disconnect();
    }

}
