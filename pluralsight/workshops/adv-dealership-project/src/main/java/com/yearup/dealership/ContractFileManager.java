package com.yearup.dealership;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ContractFileManager {
    public static void saveContract(Contract contract) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("contracts.csv", true))) {
            String contractType = (contract instanceof SalesContract) ? "SALE" : "LEASE";
            bw.write(contractType + "|" + contract.getDate() + "|" + contract.getCustomerName()
                    + "|" + contract.getCustomerEmail() + "|" + contract.getVehicleSold().getVin()
                    + "|" + contract.getVehicleSold().getYear() + "|" + contract.getVehicleSold().getMake()
                    + "|" + contract.getVehicleSold().getModel() + "|" + contract.getVehicleSold().getVehicleType()
                    + "|" + contract.getVehicleSold().getColor() + "|" + contract.getVehicleSold().getOdometer()
                    + "|" + contract.getVehicleSold().getPrice() + "|");

            if (contract instanceof SalesContract) {
                SalesContract salesContract = (SalesContract) contract;
                bw.write(salesContract.getSalesTaxAmount() + "|" + salesContract.getRecordingFee()
                        + "|" + salesContract.getProcessingFee() + "|" + salesContract.getTotalPrice()
                        + "|" + (salesContract.isFinanceOption() ? "YES" : "NO")
                        + "|" + salesContract.getMonthlyPayment());
            } else if (contract instanceof LeaseContract) {
                LeaseContract leaseContract = (LeaseContract) contract;
                bw.write(leaseContract.getExpectedEndingValue() + "|" + leaseContract.getLeaseFee()
                        + "|" + leaseContract.getTotalPrice() + "|" + leaseContract.getMonthlyPayment());
            }
        } catch (Exception e) {
            System.out.println("Error writing to contracts file: " + e.getMessage());
        }
    }
}
