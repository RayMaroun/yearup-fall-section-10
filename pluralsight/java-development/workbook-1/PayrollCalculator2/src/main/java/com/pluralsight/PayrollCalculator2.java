package com.pluralsight;

import java.util.Scanner;

public class PayrollCalculator2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter employee name: ");
        String name = input.nextLine();

        System.out.print("Enter hours worked: ");
        double hoursWorked = input.nextDouble();

        System.out.print("Enter hourly pay rate: ");
        double rate = input.nextDouble();

        double totalPay = calculateTotalPay(rate, hoursWorked);

        printPayroll(name, rate, hoursWorked, totalPay);
    }

    public static double calculateRegularPay(double rate, double hoursWorked) {
        if (hoursWorked <= 40) {
            return rate * hoursWorked;
        } else {
            return rate * 40;
        }
    }

    public static double calculateOvertimePay(double rate, double hoursWorked) {
        if (hoursWorked > 40) {
            return rate * 1.5 * (hoursWorked - 40);
        } else {
            return 0;
        }
    }

    public static double calculateTotalPay(double rate, double hoursWorked) {
        double regularPay = calculateRegularPay(rate, hoursWorked);
        double overtimePay = calculateOvertimePay(rate, hoursWorked);
        return regularPay + overtimePay;
    }

    public static void printPayroll(String name, double rate, double hoursWorked, double totalPay) {
        System.out.println("Payroll for " + name);
        System.out.println("Hours worked: " + hoursWorked);
        System.out.println("Hourly rate: " + rate);
        System.out.println("Regular pay: " + calculateRegularPay(rate, hoursWorked));
        System.out.println("Overtime pay: " + calculateOvertimePay(rate, hoursWorked));
        System.out.println("Total pay: " + totalPay);
    }

}
