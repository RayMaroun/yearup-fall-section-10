package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class Payroll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the file employee file to process: ");
        String inputFileName = scanner.nextLine();

        System.out.print("Enter the name of the payroll file to create: ");
        String outputFileName = scanner.nextLine();

        if (!outputFileName.endsWith(".csv") && !outputFileName.endsWith(".json")) {
            System.err.println("Unsupported file type.");
            return;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
            String line;

            if (outputFileName.endsWith(".json")) {
                writer.write("[\n");  // Begin JSON array
            }

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                Employee employee = new Employee(id, name, hoursWorked, payRate);
                String outputLine = "";

                if (outputFileName.endsWith(".csv")) {
                    outputLine = String.format("%d|%s|%.2f%n",
                            employee.getEmployeeId(), employee.getName(), employee.getGrossPay());

                } else if (outputFileName.endsWith(".json")) {
                    outputLine = String.format("  { \"id\": %d, \"name\": \"%s\", \"grossPay\": %.2f }",
                            employee.getEmployeeId(), employee.getName(), employee.getGrossPay());

                    if (reader.ready()) {  // Check if there's another line to read
                        outputLine += ",";  // Add a comma if there's another JSON object after this
                    }

                    outputLine += "\n";  // New line after each JSON object
                }
                writer.write(outputLine);

            }
            if (outputFileName.endsWith(".json")) {
                writer.write("]\n");  // End JSON array
            }

            writer.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + inputFileName);
            System.err.println("Error writing output file: " + outputFileName);
        }
    }
}

