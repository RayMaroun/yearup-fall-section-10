=============================
**JAVA OOP REVIEW**
=============================

1. **Classes in Java**:

   - Concept: A blueprint for creating objects.
   - Example:
     ```java
     public class Book {
         String title;
         void readBook() {
             // method body
         }
     }
     ```

2. **Encapsulation**:

   - Concept: Hiding internal state and requiring all interaction to be performed through an object's methods.
   - Example:
     ```java
     public class BankAccount {
         private double balance;
         public void deposit(double amount) {
             if (amount > 0) {
                 balance += amount;
             }
         }
     }
     ```

3. **Inheritance**:

   - Concept: One class extends another, inheriting its properties and methods.
   - Example:
     ```java
     public class Animal {
         // base class
     }
     public class Bird extends Animal {
         // derived class
     }
     ```

4. **Polymorphism**:

   - Concept: The ability of different classes to be treated as instances of the same class through inheritance.
   - Example:
     ```java
     class Shape {
         void draw() {
             System.out.println("Drawing a shape");
         }
     }
     class Circle extends Shape {
         void draw() {
             System.out.println("Drawing a circle");
         }
     }
     ```

5. **Objects in Java**:

   - Concept: An instance of a class.
   - Example:
     ```java
     public class Main {
         public static void main(String[] args) {
             Book myBook = new Book();
         }
     }
     ```

6. **"this" keyword**:

   - Purpose: To refer to the current instance of the class.
   - Example:
     ```java
     public class Student {
         private int age;
         public Student(int age) {
             this.age = age;
         }
     }
     ```

7. **"super" keyword**:

   - Purpose: To refer to a parent class's methods or constructor.
   - Example:
     ```java
     public class Parent {
         Parent() {
             // constructor
         }
     }
     public class Child extends Parent {
         Child() {
             super();
         }
     }
     ```

8. **Interfaces with Implementations**:

   - Fact: Interfaces can contain default and static methods.
   - Example:
     ```java
     public interface Printable {
         default void print() {
             System.out.println("Printing");
         }
     }
     ```

9. **Abstract Classes**:

   - Fact: Abstract classes are meant to be extended and cannot be instantiated.
   - Example:
     ```java
     public abstract class Vehicle {
         abstract void accelerate();
     }
     ```

10. **Package Declaration**:

    - Syntax: Use dot notation to declare a package.
    - Example:
      ```java
      package org.myapp.utilities;
      ```

11. **Overloading vs Overriding**:

    - Overloading: Methods with the same name but different parameters.
    - Overriding: Redefining a parent class's method in the subclass.

12. **Constructors**:

    - Best Practice: Use `this` to refer to instance variables.
    - Example:

      ```java
      public class Event {
          private String host;
          private String location;
          private int attendees;

          public Event(String host, String location, int attendees) {
              this.host = host;
              this.location = location;
              this.attendees = attendees;
          }
      }
      ```

13. **Getters and Setters**:

    - Example:
      ```java
      public class Employee {
          private String id;
          public void setId(String id) {
              this.id = id;
          }
          public String getId() {
              return id;
          }
      }
      ```

14. **Class Definition with Methods**:

    - Example:
      ```java
      public class Bicycle {
          private String type;
          private String color;
          public Bicycle(String type, String color) {
              this.type = type;
              this.color = color;
          }
          public void ride() {
              System.out.println("Riding the " + color + " " + type);
          }
      }
      ```

15. **Usage of "this"**:

    - Purpose: Differentiates between instance variables and parameters.
    - Example: Refer to the Bicycle class example above.

16. **Creating a Subclass**:

    - Correct Syntax: `extends` keyword for inheritance.
    - Example:
      ```java
      public class Laptop extends Computer { }
      ```

17. **Abstract Class Definition**:

    - Example:
      ```java
      public abstract class Instrument {
          public abstract void play();
      }
      ```

18. **Interface Definition**:

    - Example:
      ```java
      public interface Chargeable {
          void charge();
      }
      ```

19. **"super" Keyword in Constructors**:

    - Purpose: Calls the constructor of the superclass.
    - Example: Refer to the Child class example above.

20. **"final" Keyword**:

    - Purpose: To prevent a variable from being modified.
    - Example:
      ```java
      public class Constants {
          public final int MAX_SIZE = 100;
      }
      ```

21. **ArrayList Access**:

    - Correct Method: `.get(index)` for element access.
    - Example:
      ```java
      ArrayList<String> colors = new ArrayList<String>();
      String firstColor = colors.get(0);
      ```

22. **Exception Handling**:

    - Syntax: `try-catch` blocks for handling exceptions.
    - Example:
      ```java
      try {
          File file = new File("example.txt");
          FileReader fr = new FileReader(file);
          // other code not shown
      }
      catch (FileNotFoundException e) {
          System.out.println("File not found");
      }
      ```

23. **Interface Implementation**:

    - Fact: Interfaces cannot be instantiated directly.
    - Correct Implementation: Create a class that implements the interface.

24. **LocalDate Usage**:

    - Function: To retrieve the current date.
    - Example:
      ```java
      LocalDate today = LocalDate.now();
      System.out.println(today.getMonth());
      ```

25. **LocalDateTime Usage**:
    - Function: To retrieve the current date and time.
    - Example:
      ```java
      LocalDateTime now = LocalDateTime.now();
      System.out.println(now.getMinute());
      ```
