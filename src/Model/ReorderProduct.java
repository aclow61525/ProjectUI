package Model;

public class ReorderProduct {
    private int productID;
    private String productName;
    private int quantityHeld;
    private int maxQuantity;
    private int reorderAmount;


    public ReorderProduct(int productID, String productName, int quantityHeld, int maxQuantity, int reorderAmount) {
        this.productID = productID;
        this.productName = productName;
        this.quantityHeld = quantityHeld;
        this.maxQuantity = maxQuantity;
        this.reorderAmount = reorderAmount;
    }

    public ReorderProduct(ReorderProduct reorderProduct) {
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

    public int getQuantityHeld() {
        return quantityHeld;
    }

    public void setQuantityHeld(int quantityHeld) {
        this.quantityHeld = quantityHeld;
    }

    public int getReorderAmount() {
        return reorderAmount;
    }

    public void setReorderAmount(int ReorderAmount) {
        this.reorderAmount = reorderAmount;
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