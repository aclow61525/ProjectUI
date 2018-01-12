package Model;

import javax.xml.crypto.Data;
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

    public static void createNewProduct(DatabaseConnection database, String[] textFieldInputs) throws SQLException {
        PreparedStatement productCreationStatement = database.newStatement("INSERT INTO ProductDetails (ProductName, ProductWidth, ProductHeight, ProductDepth, ProductWeight, QuantityHeld, ReorderThreshold, MaxQuantity) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

        productCreationStatement.setString(1, textFieldInputs[0]);
        productCreationStatement.setString(2, textFieldInputs[4]);
        productCreationStatement.setString(3, textFieldInputs[5]);
        productCreationStatement.setString(4, textFieldInputs[6]);
        productCreationStatement.setString(5, textFieldInputs[7]);
        productCreationStatement.setString(6, textFieldInputs[1]);
        productCreationStatement.setString(7, textFieldInputs[3]);
        productCreationStatement.setString(8, textFieldInputs[2]);

        try {
            if (productCreationStatement != null) {
                database.executeUpdate(productCreationStatement);
            }
        } catch (Exception ex) {
            System.err.println("Database create product error: " + ex.getMessage());
        }

        database.disconnect();
    }
    public static void deleteProductType(DatabaseConnection database, int selectedProductID) {
        PreparedStatement productDeletionStatement = database.newStatement("DELETE FROM ProductDetails WHERE productID = " + selectedProductID);

        try {
            if (productDeletionStatement != null) {
                database.executeUpdate(productDeletionStatement);
            }
        } catch (Exception ex) {
            System.err.println("Database delete product error: " + ex.getMessage());
        }

        database.disconnect();
    }
    public static void reorderProducts(DatabaseConnection database){
        System.out.println("here");
        PreparedStatement productReorderStatement = database.newStatement("ALTER TABLE ProductDetails AUTO_INCREMENT = VALUE");

        try {
            if (productReorderStatement != null) {
                database.executeUpdate(productReorderStatement);
            }
        } catch (Exception ex) {
            System.err.println("Database delete product error: " + ex.getMessage());
        }

        database.disconnect();
    }
}
