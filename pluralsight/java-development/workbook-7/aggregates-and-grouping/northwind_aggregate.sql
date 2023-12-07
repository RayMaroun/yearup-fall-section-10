-- 1. Number of suppliers
SELECT COUNT(*) AS SupplierCount
FROM Suppliers;

-- 2. Sum of all employee salaries
SELECT SUM(Salary) AS TotalSalary
FROM Employees;

-- 3. Price of the cheapest item
SELECT MIN(UnitPrice) AS CheapestPrice
FROM Products;

-- 4. Average price of items
SELECT AVG(UnitPrice) AS AveragePrice
FROM Products;

-- 5. Price of the most expensive item
SELECT MAX(UnitPrice) AS MostExpensivePrice
FROM Products;

-- 6. Supplier ID and number of items supplied
SELECT SupplierID, COUNT(*) AS ItemCount
FROM Products
GROUP BY SupplierID;

-- 7. Category ID and average price of items in each category
SELECT CategoryID, AVG(UnitPrice) AS AveragePrice
FROM Products
GROUP BY CategoryID;

-- 8. Supplier ID and number of items supplied for suppliers with at least 5 items
SELECT SupplierID, COUNT(*) AS ItemCount
FROM Products
GROUP BY SupplierID
HAVING ItemCount >= 5;

-- 9. Product ID, product name, and inventory value (unit price multiplied by units on hand) sorted in descending order by value and product name
SELECT ProductID, ProductName, UnitPrice * UnitsInStock AS InventoryValue
FROM Products
ORDER BY InventoryValue DESC, ProductName ASC;
