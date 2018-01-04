package Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product {
    private final SimpleIntegerProperty productID;
    private final SimpleStringProperty productName;
    private final SimpleIntegerProperty productWidth;
    private final SimpleIntegerProperty productHeight;
    private final SimpleIntegerProperty productDepth;
    private final SimpleDoubleProperty productWeight;
    private final SimpleIntegerProperty quantityHeld;
    private final SimpleIntegerProperty reorderThreshold;
    private final SimpleIntegerProperty maxQuantity;

    public Product(int productID, String productName, int productWidth, int productHeight, int productDepth, double productWeight, int quantityHeld, int reorderThreshold, int maxQuantity) {
        this.productID = new SimpleIntegerProperty(productID);
        this.productName = new SimpleStringProperty(productName);
        this.productWidth = new SimpleIntegerProperty(productWidth);
        this.productHeight = new SimpleIntegerProperty(productHeight);
        this.productDepth = new SimpleIntegerProperty(productDepth);
        this.productWeight = new SimpleDoubleProperty(productWeight);
        this.quantityHeld = new SimpleIntegerProperty(quantityHeld);
        this.reorderThreshold = new SimpleIntegerProperty(reorderThreshold);
        this.maxQuantity = new SimpleIntegerProperty(maxQuantity);
    }

    public int getProductID() {
        return productID.get();
    }

    public void setProductID(int productID) {
        this.productID.set(productID);
    }

    public String getProductName() {
        return productName.get();
    }

    public void setProductName(String productName) {
        this.productName.set(productName);
    }

    public int getProductWidth() {
        return productWidth.get();
    }

    public void setProductWidth(int productWidth) {
        this.productWidth.set(productWidth);
    }

    public int getProductHeight() {
        return productHeight.get();
    }

    public void setProductHeight(int productHeight) {
        this.productHeight.set(productHeight);
    }

    public int getProductDepth() {
        return productDepth.get();
    }

    public void setProductDepth(int productDepth) {
        this.productDepth.set(productDepth);
    }

    public double getProductWeight() {
        return productWeight.get();
    }

    public void setProductWeight(double productWeight) {
        this.productWeight.set(productWeight);
    }

    public int getQuantityHeld() {
        return quantityHeld.get();
    }

    public void setQuantityHeld(int quantityHeld) {
        this.quantityHeld.set(quantityHeld);
    }

    public int getReorderThreshold() {
        return reorderThreshold.get();
    }

    public void setReorderThreshold(int reorderThreshold) {this.reorderThreshold.set(reorderThreshold);}

    public int getMaxQuantity() {
        return maxQuantity.get();
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity.set(maxQuantity);
    }

    @Override
    public String toString() {
        return "ID: " + productID + ", Name: " + productName;
    }
}
