package com.pluralsight.ledger.models;

public class Transaction {
    private int transactionId;
    private double amount;
    private String vendor;

    public Transaction(int transactionId, double amount, String vendor) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.vendor = vendor;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", amount=" + amount +
                ", vendor='" + vendor + '\'' +
                '}';
    }
}
