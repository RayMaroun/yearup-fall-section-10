package com.pluralsight;

public class StaticClasses {
    public static void main(String[] args) {
        
        // Test the format method with separate name components
        String formattedName1 = NameFormatter.format("Mr.", "John", "Robert", "Doe", "Jr.");
        System.out.println(formattedName1); // Should print "Doe, Mr. John Robert, Jr."


        System.out.println(NameFormatter.format("Mel Johnson"));
        System.out.println(NameFormatter.format("Mel B Johnson, PhD"));
        System.out.println(NameFormatter.format("Dr. Mel B Johnson, PhD"));

        // Test the format method with minimum name components
        String formattedName3 = NameFormatter.format("Maria", "Garcia");
        System.out.println(formattedName3); // Should print "Garcia, Maria"

    }
}
