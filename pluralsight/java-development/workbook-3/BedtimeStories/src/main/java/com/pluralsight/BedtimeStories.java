package com.pluralsight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BedtimeStories {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the name of the story file: ");
        String fileName = console.nextLine();

        try {
            FileInputStream fis = new FileInputStream(fileName);
            Scanner fileScanner = new Scanner(fis);
            int lineNumber = 1;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.printf("%d. %s%n", lineNumber, line);
                lineNumber++;
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }
}

