package models;

import java.util.Date;

public class SalesByYear {
    private Date shippedDate;
    private int orderID;
    private double subtotal;
    private int year;

    public SalesByYear(Date shippedDate, int orderID, double subtotal, int year) {
        this.shippedDate = shippedDate;
        this.orderID = orderID;
        this.subtotal = subtotal;
        this.year = year;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public int getOrderID() {
        return orderID;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public int getYear() {
        return year;
    }
}
