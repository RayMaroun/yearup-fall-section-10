import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class FinancialTracker {

    private static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    private static final String FILE_NAME = "transactions.csv";
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String TIME_FORMAT = "HH:mm:ss";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMAT);

    public static void main(String[] args) {
        loadTransactions(FILE_NAME);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to TransactionApp");
            System.out.println("Choose an option:");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");

            String input = scanner.nextLine().trim();

            switch (input.toUpperCase()) {
                case "D":
                    addDeposit(scanner);
                    break;
                case "P":
                    addPayment(scanner);
                    break;
                case "L":
                    ledgerMenu(scanner);
                    break;
                case "X":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }

        scanner.close();
    }

    public static void loadTransactions(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                LocalDate date = LocalDate.parse(parts[0], DATE_FORMATTER);
                LocalTime time = LocalTime.parse(parts[1], TIME_FORMATTER);
                String description = parts[2];
                String vendor = parts[3];
                double amount = parseDouble(parts[4]);
                transactions.add(new Transaction(date, time, description, vendor, amount));
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
        }
    }

    private static void addDeposit(Scanner scanner) {
        System.out.println("Add Deposit");
        System.out.println("Enter the date (format: " + DATE_FORMAT + "):");
        LocalDate date = LocalDate.parse(scanner.nextLine(), DATE_FORMATTER);
        System.out.println("Enter the time (format: " + TIME_FORMAT + "):");
        LocalTime time = LocalTime.parse(scanner.nextLine(), TIME_FORMATTER);
        System.out.println("Enter the description:");
        String description = scanner.nextLine();
        System.out.println("Enter the vendor:");
        String vendor = scanner.nextLine();
        System.out.println("Enter the amount:");
        double amount = parseDouble(scanner.nextLine());

        transactions.add(new Transaction(date, time, description, vendor, amount));

        String transaction = String.format("%s|%s|%s|%s|%.2f", date.format(DATE_FORMATTER),
                time.format(TIME_FORMATTER), description, vendor, amount);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(transaction);
            writer.newLine();
            System.out.println("Deposit added successfully");
        } catch (IOException e) {
            System.out.println("Failed to add deposit");
            e.printStackTrace();
        }
    }

    private static void addPayment(Scanner scanner) {
        System.out.println("Make Payment (Debit)");
        System.out.println("Enter the date (format: " + DATE_FORMAT + "):");
        LocalDate date = LocalDate.parse(scanner.nextLine(), DATE_FORMATTER);
        System.out.println("Enter the time (format: " + TIME_FORMAT + "):");
        LocalTime time = LocalTime.parse(scanner.nextLine(), TIME_FORMATTER);
        System.out.println("Enter the description:");
        String description = scanner.nextLine();
        System.out.println("Enter the vendor:");
        String vendor = scanner.nextLine();
        System.out.println("Enter the amount:");
        double amount = parseDouble(scanner.nextLine()) * -1;

        transactions.add(new Transaction(date, time, description, vendor, amount));

        String transaction = String.format("%s|%s|%s|%s|%.2f", date.format(DATE_FORMATTER),
                time.format(TIME_FORMATTER), description, vendor, amount);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(transaction);
            writer.newLine();
            System.out.println("Payment added successfully");
        } catch (IOException e) {
            System.out.println("Failed to add payment");
            e.printStackTrace();
        }
    }

    private static void ledgerMenu(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("Ledger");
            System.out.println("Choose an option:");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");

            String input = scanner.nextLine().trim();

            switch (input.toUpperCase()) {
                case "A":
                    displayLedger();
                    break;
                case "D":
                    displayDeposits();
                    break;
                case "P":
                    displayPayments();
                    break;
                case "R":
                    reportsMenu(scanner);
                    break;
                case "H":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    private static void displayLedger() {
        System.out.println("Ledger:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    private static void displayDeposits() {
        System.out.println("Deposits:");
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() > 0) {
                System.out.println(transaction);
            }
        }
    }

    private static void displayPayments() {
        System.out.println("Payments:");
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < 0) {
                System.out.println(transaction);
            }
        }
    }

    private static void reportsMenu(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("Reports");
            System.out.println("Choose an option:");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("6) Custom Search");
            System.out.println("0) Back");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    filterTransactionsByDate(LocalDate.now().withDayOfMonth(1), LocalDate.now());
                    break;
                case "2":
                    LocalDate lastMonth = LocalDate.now().minusMonths(1);
                    LocalDate startDate = LocalDate.of(lastMonth.getYear(), lastMonth.getMonth(), 1);
                    LocalDate endDate = startDate.plusMonths(1).minusDays(1);
                    filterTransactionsByDate(startDate, endDate);
                    break;
                case "3":
                    filterTransactionsByDate(LocalDate.now().withDayOfYear(1), LocalDate.now());
                    break;
                case "4":
                    LocalDate lastYear = LocalDate.now().minusYears(1);
                    LocalDate startYear = LocalDate.of(lastYear.getYear(), 1, 1);
                    LocalDate endYear = startYear.plusYears(1).minusDays(1);
                    filterTransactionsByDate(startYear, endYear);
                    break;
                case "5":
                    System.out.println("Enter vendor name:");
                    String vendor = scanner.nextLine().trim();
                    filterTransactionsByVendor(vendor);
                    break;
                case "6":
                    customSearch(scanner);
                    break;
                case "0":
                    running = false;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    private static void filterTransactionsByDate(LocalDate startDate, LocalDate endDate) {
        System.out.println("Report:");
        for (Transaction transaction : transactions) {
            if (transaction.getDate().isAfter(startDate.minusDays(1)) && transaction.getDate().isBefore(endDate.plusDays(1))) {
                System.out.println(transaction);
            }
        }
    }

    private static void filterTransactionsByVendor(String vendor) {
        System.out.println("Report:");
        for (Transaction transaction : transactions) {
            if (transaction.getVendor().equalsIgnoreCase(vendor)) {
                System.out.println(transaction);
            }
        }
    }

    private static void customSearch(Scanner scanner) {
        System.out.println("Custom Search");
        System.out.println("Enter start date (format: " + DATE_FORMAT + ", leave blank for none):");
        LocalDate startDate = parseDate(scanner.nextLine().trim());
        System.out.println("Enter end date (format: " + DATE_FORMAT + ", leave blank for none):");
        LocalDate endDate = parseDate(scanner.nextLine().trim());
        System.out.println("Enter description (leave blank for none):");
        String description = scanner.nextLine().trim();
        System.out.println("Enter vendor (leave blank for none):");
        String vendor = scanner.nextLine().trim();
        System.out.println("Enter amount (leave blank for none):");
        Double amount = parseDouble(scanner.nextLine().trim());

        ArrayList<Transaction> results = new ArrayList<Transaction>();
        for (Transaction transaction : transactions) {
            if ((startDate == null || transaction.getDate().compareTo(startDate) >= 0)
                    && (endDate == null || transaction.getDate().compareTo(endDate) <= 0)
                    && (description.isEmpty() || transaction.getDescription().equalsIgnoreCase(description))
                    && (vendor.isEmpty() || transaction.getVendor().equalsIgnoreCase(vendor))
                    && (amount == null || transaction.getAmount() == amount)) {
                results.add(transaction);
            }
        }

        if (results.size() == 0) {
            System.out.println("No transactions found");
        } else {
            System.out.println("Results:");
            for (Transaction transaction : results) {
                System.out.println(transaction);
            }
        }
    }

    private static LocalDate parseDate(String dateString) {
        if (dateString.isEmpty()) {
            return null;
        }
        try {
            return LocalDate.parse(dateString, DATE_FORMATTER);
        } catch (Exception e) {
            System.out.println("Invalid date format: " + dateString);
            return null;
        }
    }

    private static Double parseDouble(String doubleString) {
        if (doubleString.isEmpty()) {
            return null;
        }
        try {
            return Double.parseDouble(doubleString);
        } catch (Exception e) {
            System.out.println("Invalid double format: " + doubleString);
            return null;
        }
    }
}
