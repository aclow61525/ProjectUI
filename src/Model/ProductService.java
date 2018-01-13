package Model;

import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;

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
    public static void createRestockOrder(DatabaseConnection database, ObservableList<ReorderProduct> resultsList){
        //Check statement is accurate
        /*
        PreparedStatement productReorderStatement = database.newStatement("INSERT INTO ReorderTable (ProductID, ProductName, QuantityHeld, MaxStock, ReorderAmount) VALUES (?, ?, ?, ?, ?)");

        if (resultsList != null){
            try {
                for (int x = 0; x < resultsList.size(); x++){
                    //the list created in the controller is unpacked
                    ReorderProduct holdProduct = new ReorderProduct(resultsList.get(x));

                    productReorderStatement.setInt(1, holdProduct.getProductID());
                    productReorderStatement.setString(2, holdProduct.getProductName());
                    productReorderStatement.setInt(3, holdProduct.getQuantityHeld());
                    productReorderStatement.setInt(4, holdProduct.getMaxQuantity());
                    productReorderStatement.setInt(5, holdProduct.getReorderAmount());

                    productReorderStatement.executeUpdate();
                }

            }catch(Exception e){
                e.printStackTrace();
            }
        }*/
        database.disconnect();
    }
}
