package com.pluralsight.models;

public class Product {
    private int productID;
    private String productName;
    private double unitPrice;
    private int unitsInStock;

    public Product(int productID, String productName, double unitPrice, int unitsInStock) {
        this.productID = productID;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
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

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", unitPrice=" + unitPrice +
                ", unitsInStock=" + unitsInStock +
                '}';
    }
}
