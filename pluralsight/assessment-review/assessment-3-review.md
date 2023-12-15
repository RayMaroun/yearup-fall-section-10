=============================
**SQL/JDBC REVIEW**
=============================

1. **SQL (Structured Query Language)**:

   - SQL is a standard language for accessing and manipulating databases.
   - No specific example, but it's important to remember that SQL is used to interact with relational databases.

2. **SELECT Statement in SQL**:

   - Retrieves data from one or more tables in a database.
   - Example: `SELECT name FROM students;`
     - This statement fetches the `name` column from the `students` table.

3. **GROUP BY Clause in SQL**:

   - Groups rows sharing a property so that an aggregate function can be applied to each group.
   - Example: `SELECT COUNT(student_id), class FROM students GROUP BY class;`
     - This query counts the number of students in each class and groups the results by class.

4. **JOIN Clause in SQL**:

   - Combines columns from one or more tables based on a related column between them.
   - Example: `SELECT students.name, classes.name FROM students JOIN classes ON students.class_id = classes.id;`
     - This query joins the `students` and `classes` tables to select student names along with their class names.

5. **Basic SQL Query**:

   - A simple SQL statement to fetch specific information.
   - Example: `SELECT name FROM students WHERE age > 20;`
     - This query selects names of students who are older than 20 years.

6. **COUNT Function in SQL**:

   - Used to count the number of rows that match a specified criterion.
   - Example: `SELECT COUNT(*) FROM students;`
     - This query counts the total number of students.

7. **LIKE Operator in SQL**:

   - Used for pattern matching in a SQL query.
   - Example: `SELECT * FROM students WHERE name LIKE 'J%';`
     - This query selects all students whose names start with 'J'.

8. **DELETE Statement in SQL**:

   - Used to remove records from a database table.
   - Example: `DELETE FROM students WHERE graduation_year < 2020;`
     - This query deletes students who graduated before 2020.

9. **Combining GROUP BY and JOIN**:

   - Utilize `JOIN` to combine tables and `GROUP BY` to aggregate results.
   - Example: `SELECT department, COUNT(employee_id) FROM employees GROUP BY department;`
     - This query counts the number of employees in each department.

10. **INNER JOIN in SQL**:

    - Combines rows from two tables where there is a match in both tables.
    - Example: `SELECT orders.id, customers.name FROM orders INNER JOIN customers ON orders.customer_id = customers.id;`
      - This query fetches order IDs and customer names for each order.

11. **LEFT JOIN in SQL**:

    - Returns all records from the left table and matched records from the right table.
    - Example: `SELECT employees.name, departments.name FROM employees LEFT JOIN departments ON employees.dept_id = departments.id;`
      - This query retrieves all employees with their respective department names, including those without a department.

12. **JDBC URL for MySQL**:

    - The JDBC URL format for MySQL connection.
    - Example: `jdbc:mysql://hostname:port/dbname`
      - This is the format to connect to a MySQL database named `dbname` on the specified host and port.

13. **Connecting to a Database in Java**:

    - Establishing a database connection using JDBC.
    - Example: `Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "pass");`
      - This code snippet establishes a connection to the MySQL database named `mydb`.

14. **Creating and Executing SQL Statements in Java**:

    - Execute a SQL query through JDBC.
    - Example:
      ```java
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM students");
      ```
      - This creates a `Statement` object and executes a query to select all records from the `students` table.

15. **Inserting Data with JDBC**:

    - Inserting new data into a database table using JDBC.
    - Example:
      ```java
      int affectedRows = stmt.executeUpdate("INSERT INTO students (name) VALUES ('John Doe')");
      ```
      - This statement inserts a new student named 'John Doe' into the `students` table.

16. **Retrieving Data with JDBC**:

    - Fetching data from a database using JDBC.
    - Example:
      ```java
      while (rs.next()) {
          String name = rs.getString("name");
          // process the name
      }
      ```
      - This loop iterates over the ResultSet `rs`, retrieving the `name` column for each row.

17. **Prepared Statements in JDBC**:
    - Using `PreparedStatement` for secure and efficient SQL query execution.
    - Example:
      ```java
      PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM students WHERE age > ?");
      pstmt.setInt(1, 18);
      ResultSet rs = pstmt.executeQuery();
      ```
      - This code snippet prepares a statement to select students older than 18 and executes it.
