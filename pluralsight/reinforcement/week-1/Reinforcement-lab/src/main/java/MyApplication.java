import java.util.Scanner;

public class MyApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = getName(scanner);
        int age = getAge(scanner);

        printNameAndAge(name, age);
        printVotingEligibility(age);
        printMessage(name, age);
        printWelcomeMessage(name);

        double number = getNumber(scanner);
        double squareRoot = calculateSquareRoot(number);
        System.out.println("The square root of " + number + " is " + squareRoot);

        int firstNumber = getFirstNumber(scanner);
        int secondNumber = getSecondNumber(scanner);
        boolean isGreaterThan = isGreaterThan(firstNumber, secondNumber);
        System.out.println(firstNumber + " is greater than " + secondNumber + ": " + isGreaterThan);

        String welcomeMessage = name.equals("Eve") ? "You are not welcome, " + name + "!" : "Welcome, " + name + "!";
        System.out.println(welcomeMessage);

        double num1 = 5.6;
        double num2 = 3.2;
        double maxNum = getMax(num1, num2);
        System.out.println("The maximum of " + num1 + " and " + num2 + " is " + maxNum);

        int randomNum = generateRandomNumber();
        System.out.println("Random number between 1 and 10: " + randomNum);

        int number1 = 5;
        int number2 = 10;
        int smallerNumber = getSmallerNumber(number1, number2);
        System.out.println("The smaller number is: " + smallerNumber);
    }

    public static String getName(Scanner scanner) {
        System.out.println("Enter your name:");
        return scanner.nextLine();
    }

    public static int getAge(Scanner scanner) {
        System.out.println("Enter your age:");
        return scanner.nextInt();
    }

    public static void printNameAndAge(String name, int age) {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void printVotingEligibility(int age) {
        if (age >= 18) {
            System.out.println("You are old enough to vote.");
        } else {
            System.out.println("You are not old enough to vote.");
        }
    }

    public static void printMessage(String name, int age) {
        System.out.println("Hello, " + name + "! You are " + age + " years old.");
    }

    public static void printWelcomeMessage(String name) {
        switch (name.toLowerCase()) {
            case "alice":
                System.out.println("Welcome, Alice!");
                break;
            case "bob":
                System.out.println("Hey Bob, do you want to grab a drink?");
                break;
            default:
                System.out.println("Hello, stranger!");
                break;
        }
    }

    public static double getNumber(Scanner scanner) {
        System.out.println("Enter a number:");
        return scanner.nextDouble();
    }

    public static double calculateSquareRoot(double number) {
        return Math.sqrt(number);
    }

    public static int getFirstNumber(Scanner scanner) {
        System.out.println("Enter the first number:");
        return scanner.nextInt();
    }

    public static int getSecondNumber(Scanner scanner) {
        System.out.println("Enter the second number:");
        return scanner.nextInt();
    }

    public static boolean isGreaterThan(int firstNumber, int secondNumber) {
        return firstNumber > secondNumber;
    }

    public static double getMax(double num1, double num2) {
        return Math.max(num1, num2);
    }

    public static int generateRandomNumber() {
        int min = 1;
        int max = 10;
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }

    public static int getSmallerNumber(int firstNumber, int secondNumber) {
        return Math.min(firstNumber, secondNumber);
    }
}
