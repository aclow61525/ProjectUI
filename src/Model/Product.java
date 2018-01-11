package Model;

public class Product {
    private int productID;
    private String productName;
    private int productWidth;
    private int productHeight;
    private int productDepth;
    private double productWeight;
    private int quantityHeld;
    private int reorderThreshold;
    private int maxQuantity;

    public Product(int productID, String productName, int productWidth, int productHeight, int productDepth, double productWeight, int quantityHeld, int reorderThreshold, int maxQuantity) {
        this.productID = productID;
        this.productName = productName;
        this.productWidth = productWidth;
        this.productHeight = productHeight;
        this.productDepth = productDepth;
        this.productWeight = productWeight;
        this.quantityHeld = quantityHeld;
        this.reorderThreshold = reorderThreshold;
        this.maxQuantity = maxQuantity;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductWidth() {
        return productWidth;
    }

    public void setProductWidth(int productWidth) {
        this.productWidth = productWidth;
    }

    public int getProductHeight() {
        return productHeight;
    }

    public void setProductHeight(int productHeight) {
        this.productHeight = productHeight;
    }

    public int getProductDepth() {
        return productDepth;
    }

    public void setProductDepth(int productDepth) {
        this.productDepth = productDepth;
    }

    public double getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(double productWeight) {
        this.productWeight = productWeight;
    }

    public int getQuantityHeld() {
        return quantityHeld;
    }

    public void setQuantityHeld(int quantityHeld) {
        this.quantityHeld = quantityHeld;
    }

    public int getReorderThreshold() {
        return reorderThreshold;
    }

    public void setReorderThreshold(int reorderThreshold) {
        this.reorderThreshold = reorderThreshold;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    @Override
    public String toString() {
        return productName;
    }
}