package models;

public class SalesByCategory {
    private String productName;
    private double totalPurchase;

    public SalesByCategory(String productName, double totalPurchase) {
        this.productName = productName;
        this.totalPurchase = totalPurchase;
    }

    public String getProductName() {
        return productName;
    }

    public double getTotalPurchase() {
        return totalPurchase;
    }
}
