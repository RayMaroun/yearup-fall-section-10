=============================
**JAVA OOP RETAKE REVIEW**
=============================

1. **Classes in Java**:

   - Concept: Templates for creating objects.
   - Example:
     ```java
     public class Vehicle {
         String brand;
         void drive() {
             // method body
         }
     }
     ```

2. **Encapsulation (Non-goal)**:

   - Misconception: Creating global variables and functions is not a goal of encapsulation.
   - Example:
     ```java
     public class Wallet {
         private double money;
         public void addMoney(double amount) {
             // method implementation
         }
     }
     ```

3. **Inheritance**:

   - Concept: Reusing code across classes through a hierarchical relationship.
   - Example:
     ```java
     public class Animal {
         // base class
     }
     public class Fish extends Animal {
         // derived class
     }
     ```

4. **Polymorphism**:

   - Concept: Same interface, different underlying forms or behaviors.
   - Example:
     ```java
     class Employee {
         void work() {
             System.out.println("Working");
         }
     }
     class Developer extends Employee {
         void work() {
             System.out.println("Writing code");
         }
     }
     ```

5. **Objects in Java**:

   - Concept: Instances of classes.
   - Example:
     ```java
     public class Main {
         public static void main(String[] args) {
             Vehicle myCar = new Vehicle();
         }
     }
     ```

6. **"this" Keyword Purpose**:

   - Usage: To differentiate between class and local variables.
   - Example:
     ```java
     public class Rectangle {
         private int length;
         public Rectangle(int length) {
             this.length = length;
         }
     }
     ```

7. **"super" Keyword Purpose**:

   - Usage: To call a parent class's method.
   - Example:
     ```java
     public class Parent {
         void greet() {
             // method body
         }
     }
     public class Child extends Parent {
         void welcome() {
             super.greet();
         }
     }
     ```

8. **Interfaces with Implementations**:

   - Fact: Java interfaces can contain default and static method implementations.

9. **Abstract Classes**:

   - Fact: Abstract classes must be extended to be utilized.

10. **Package Folder Structure**:

    - Correct Structure: Uses backslashes to denote directory hierarchy.
    - Example:
      ```text
      src\main\java\com\yearup\demo
      ```

11. **Overloading vs Overriding (Correction)**:

    - Overloading: Same method name, different parameters.
    - Overriding: Same method name, same parameters, in subclass.

12. **Constructors in Java**:

    - Concept: Constructors are special methods used to initialize objects.
    - Example:
      ```java
      public class Book {
          private String title;
          public Book(String title) {
              this.title = title;
          }
      }
      ```

13. **Class Fields and Methods**:

    - Concept: Classes in Java contain fields (attributes) and methods (functions).
    - Example:
      ```java
      public class Bicycle {
          private String type;
          public Bicycle(String type) {
              this.type = type;
          }
          public void ride() {
              // method body
          }
      }
      ```

14. **Field Initialization in Constructors**:

    - Concept: Proper field initialization in constructors is crucial for setting object state.
    - Example:
      ```java
      public class Lamp {
          private String color;
          public Lamp(String color) {
              this.color = color; // Correctly initializing the field
          }
      }
      ```

15. **Creating a Subclass**:

    - Correct Syntax: `extends` keyword for inheritance.

16. **Using Abstract Class**:

    - Approach: Extend the abstract class to provide specific implementations.

17. **Interface Definition**:

    - Fact: Interfaces define methods but do not provide implementations.

18. **Class Structure and Method Placement**:

    - Concept: Understanding where methods and blocks of code can be placed within a class.
    - Example:

      ```java
      public class Animal {
          // Field declarations
          private String name;

          // Constructor
          public Animal(String name) {
              this.name = name;
          }

          // Methods
          public void makeSound() {
              // method body
          }
      }
      ```

19. **"final" Keyword Purpose**:

    - Usage: To declare a variable that cannot be changed after initial assignment.

20. **Adding Item to ArrayList**:

    - Method: Using `.add(index, element)` to insert at a specific position.

21. **Exception Handling**:

    - Concept: Using try-catch blocks to handle exceptions and maintain program flow.
    - Example:
      ```java
      try {
          // Code that may throw an exception
          File file = new File("filename.txt");
          FileReader fr = new FileReader(file);
      } catch (FileNotFoundException e) {
          // Handling the exception
          System.out.println("File not found");
      }
      ```

22. **Interface Implementation Error**:

    - Fact: Interfaces cannot be instantiated; they must be implemented by a class.

23. **Working with Dates in Java**:

    - **Concept**: Java provides classes like `LocalDate` and `Period` to work with dates, allowing you to perform operations such as calculating the difference between two dates.
    - **Example**:

    ```java
    LocalDate start = LocalDate.of(2022, 1, 1);
    LocalDate end = LocalDate.of(2022, 6, 1);
    Period period = Period.between(start, end);
    int monthsBetween = period.getMonths(); // Gets the number of months between two dates
    ```

24. **ArrayList Access Method**:
    - Correct Method: Using `.get(index)` to retrieve an element from an ArrayList.
