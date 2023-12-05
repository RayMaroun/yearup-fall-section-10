-- 1. Name of the table that holds the items Northwind sells:
-- Products

-- 2. Query to list the product id, product name, and unit price of every product:
SELECT ProductID, ProductName, UnitPrice
FROM Products;

-- 3. Query to list the product id, product name, and unit price of every product, ordered in ascending order by price:
SELECT ProductID, ProductName, UnitPrice
FROM Products
ORDER BY UnitPrice ASC;

-- 4. Products carried with a unit price of $7.50 or less:
SELECT *
FROM Products
WHERE UnitPrice <= 7.50;

-- 5. Products carried with at least 100 units on hand, ordered in descending order by price:
SELECT *
FROM Products
WHERE UnitsInStock >= 100
ORDER BY UnitPrice DESC;

-- 6. Products carried with at least 100 units on hand, ordered in descending order by price. If two or more have the same price, list them in ascending order by product name:
SELECT *
FROM Products
WHERE UnitsInStock >= 100
ORDER BY UnitPrice DESC, ProductName ASC;

-- 7. Products carried with no units on hand, but 1 or more units on backorder, ordered by product name:
SELECT *
FROM Products
WHERE UnitsInStock = 0 AND UnitsOnOrder > 0
ORDER BY ProductName;

-- 8. Name of the table that holds the types (categories) of the items Northwind sells:
-- Categories

-- 9. Query to list all columns and rows of the categories table and find the category id of seafood:
SELECT *
FROM Categories;

-- 10. How the Products table identifies the type (category) of each item sold and query to list all seafood items:
SELECT *
FROM Products
WHERE CategoryID = 8;

-- 11. First and last names of all Northwind employees:
SELECT FirstName, LastName
FROM Employees;

-- 12. Employees with "manager" in their titles:
SELECT *
FROM Employees
WHERE Title LIKE '%Manager%';

-- 13. Distinct job titles in employees:
SELECT DISTINCT Title
FROM Employees;

-- 14. Employees with a salary between $2000 and $2500:
SELECT *
FROM Employees
WHERE Salary BETWEEN 2000 AND 2500;

-- 15. All information about Northwind's suppliers:
SELECT *
FROM Suppliers;

-- 16. How to identify the supplier for each product and list all items supplied by "Tokyo Traders":
SELECT *
FROM Products
WHERE SupplierID = 4;
