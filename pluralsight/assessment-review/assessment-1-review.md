# Java Basics Assessment Review

1.  **Primitive Data Types**: Java has eight built-in data types: `byte`, `short`, `int`, `long`, `float`, `double`, `char`, and `boolean`.

    ```java
    byte b = 10;
    short s = 500;
    int i = 1000;
    long l = 5000L;
    float f = 5.7f;
    double d = 9.7;
    char c = 'A';
    boolean bool = true;
    ```

    Note: `String` is NOT a primitive data type.

    ```java
    String str = "Hello, Java!";
    ```

2.  **Main Method**: This is the entry point of a Java application.

    ```java
    public static void main(String[] args) {
        // code here
    }
    ```

3.  **Classes**: They are declared using the `class` keyword.

    ```java
    public class MyClass {
        // class members here
    }
    ```

4.  **Identifiers**: Identifiers are the names given to various program elements, such as variables, methods, classes, etc.

    - **Valid Identifiers**:

      ```java
      int validIdentifier = 10;
      String _alsoValid = "underscore";
      double $validToo = 5.6;
      ```

    - **Invalid Identifiers**:
      An identifier cannot start with a number, cannot contain spaces, and cannot be a reserved keyword. Special characters other than underscore (\_) and dollar sign ($) are also not allowed.
      ```java
      int 123invalid;  // starts with a number
      String class;    // 'class' is a reserved keyword in Java
      double my#var;   // contains a special character #
      ```

5.  **Printing to the Console**: Use `System.out.println();`

    ```java
    String message = "Java is fun!";
    System.out.println(message);
    ```

6.  **Operators**: Remember the order of operations.

    ```java
    int result1 = 4 + 4 / 2;  // 6. We do division first: 4 / 2 then + 4.
    ```

7.  **Postfix and Prefix**: Difference between `x++` and `++x`. The former will use `x` and then increment, while the latter increments first.

    ```java
    int x = 5;
    System.out.println(x++); // 5
    ```

    ```java
    int x = 5;
    System.out.println(++x); // 6
    ```

8.  **Compound Assignment and Expression Evaluation**: Compound assignment operators in Java allow for a shorter notation when applying an operation and subsequently assigning the result to the variable.

    - **Example**:

      ```java
      int y = 7;
      y *= 3 + 4;  // Equivalent to: y = y * (3 + 4);
      ```

      Here, the operation on the right (`3 + 4`) is evaluated first, which results in `7`. Then, the multiplication operation (`y * 7`) is executed, which gives `49`, and this value is then assigned to `y`.

    - **Outcome**:
      After executing the code, the value of `y` will be `49`.

9.  **String Comparison**:

    - `==` checks if two strings are the same object.
    - `.equals()` checks if two strings have the same value.
    - `.equalsIgnoreCase()` does the same but is case-insensitive.

    ```java
    String s1 = "Hello";
    String s2 = "hello";
    boolean isEqual1 = s1.equals(s2);  // false
    boolean isEqual2 = s1.equalsIgnoreCase(s2);  // true
    ```

10. **Arrays**: One-dimensional arrays look like `int[] arr = {1, 2, 3, 4};`. They use curly braces `{}` for initialization.

    ```java
    int[] arr = {1, 2, 3, 4};
    ```

11. **For-each Loop**: This is a concise way to loop through arrays or collections.

    ```java
    for (Type var : array) {
        // code here
    }
    ```

    Real example:

    ```java

    String[] fruits = {"apple", "banana", "cherry"};
    for (String fruit : fruits) {
    System.out.println(fruit);
    }
    ```

12. **Comparison Operators**: `==`, `!=`, `<`, `<=`, `>`, `>=`. Note: `=>` is NOT valid.

13. **Conditional Statements**: `if-else` statements can have multiple conditions but only one `else` block.

    ```java
    int score = 85;
    if (score > 90) {
        System.out.println("A grade");
    } else if (score > 75) {
        System.out.println("B grade");
    } else {
        System.out.println("C grade");
    }
    ```

14. **Loop Types**:

    - `for`: Standard loop.
    - `while`: Executes as long as the condition is true.
    - `do-while`: Executes at least once and then checks the condition.

    ```java
    for (int j = 0; j < 3; j++) {
        System.out.println("For loop: " + j);
    }

    int k = 0;
    while (k < 3) {
        System.out.println("While loop: " + k);
        k++;
    }

    int m = 0;
    do {
        System.out.println("Do-while loop: " + m);
        m++;
    } while (m < 3);
    ```

15. **Break**: Used to exit out of loops early.

    ```java
    for (int n = 0; n < 5; n++) {
        if (n == 3) {
            break;
        }
        System.out.println("Number: " + n);
    }
    ```

16. **String Operations**:

    - Concatenation: `"Hello" + " World" = "Hello World"`.
    - Substring: `s.substring(start, end)`. End index is exclusive.
    - Case-insensitive Comparison: Use `.equalsIgnoreCase()`.

    ```java
    String greet = "Hello";
    String who = "World";
    System.out.println(greet + " " + who);  // "Hello World"

    String txt = "Hello, World!";
    System.out.println(txt.substring(7, 12));  // "World"

    String s3 = "HELLO";
    String s4 = "hello";
    boolean isSameCaseInsensitive = s3.equalsIgnoreCase(s4);  // true
    ```
