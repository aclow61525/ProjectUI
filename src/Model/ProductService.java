package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductService {
    public static void selectAll(List<Product> testList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT * FROM ProductDetails ORDER BY productID");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        testList.add(new Product(
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
    }
}
