package models;

public class CustomerOrderHistory {
    private String productName;
    private int totalQuantity;

    public CustomerOrderHistory(String productName, int totalQuantity) {
        this.productName = productName;
        this.totalQuantity = totalQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }
}

