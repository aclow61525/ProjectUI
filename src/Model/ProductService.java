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
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
        database.disconnect();
    }
    public static void stockAddition(DatabaseConnection database, int targetProductID, int productNewQuantity) {
        PreparedStatement stockAdditionStatement = database.newStatement("UPDATE ProductDetails SET quantityHeld = " + productNewQuantity + " WHERE productID = " + targetProductID + ";");

        try {
            if (stockAdditionStatement != null) {
                database.executeUpdate(stockAdditionStatement);
            }
        } catch (Exception ex) {
            System.out.println("Database update error: " + ex.getMessage());
        }

        database.disconnect();
    }
}
