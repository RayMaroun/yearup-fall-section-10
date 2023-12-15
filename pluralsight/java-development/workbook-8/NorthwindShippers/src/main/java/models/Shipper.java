package models;

public class Shipper {
    private int shipperId;
    private String companyName;
    private String phoneNumber;

    public Shipper(int shipperId, String companyName, String phoneNumber) {
        this.shipperId = shipperId;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
    }

    public int getShipperId() {
        return shipperId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

