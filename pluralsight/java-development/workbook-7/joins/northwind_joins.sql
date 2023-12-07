-- 1. List the product id, product name, unit price and category name of all products. Order by category name and within that, by product name.
SELECT p.ProductID, p.ProductName, p.UnitPrice, c.CategoryName
FROM Products p
INNER JOIN Categories c ON p.CategoryID = c.CategoryID
ORDER BY c.CategoryName, p.ProductName;

-- 2. List the product id, product name, unit price and supplier name of all products that cost more than $75. Order by product name.
SELECT p.ProductID, p.ProductName, p.UnitPrice, s.CompanyName
FROM Products p
INNER JOIN Suppliers s ON p.SupplierID = s.SupplierID
WHERE p.UnitPrice > 75
ORDER BY p.ProductName;

-- 3. List the product id, product name, unit price, category name, and supplier name of every product. Order by product name.
SELECT p.ProductID, p.ProductName, p.UnitPrice, c.CategoryName, s.CompanyName
FROM Products p
INNER JOIN Categories c ON p.CategoryID = c.CategoryID
INNER JOIN Suppliers s ON p.SupplierID = s.SupplierID
ORDER BY p.ProductName;

-- 4. What is the product name(s) and categories of the most expensive products? HINT: Find the max price in a subquery and then use that in your more complex query that joins products with categories.
SELECT p.ProductName, c.CategoryName
FROM Products p
INNER JOIN Categories c ON p.CategoryID = c.CategoryID
WHERE p.UnitPrice = (
  SELECT MAX(UnitPrice)
  FROM Products
);

-- 5. List the order id, ship name, ship address, and shipping company name of every order that shipped to Germany.
SELECT o.OrderID, o.ShipName, o.ShipAddress, s.CompanyName AS ShippingCompany
FROM Orders o
INNER JOIN Shippers s ON o.ShipVia = s.ShipperID
WHERE o.ShipCountry = 'Germany';

-- 6. List the order id, order date, ship name, ship address of all orders that ordered "Sasquatch Ale".
SELECT o.OrderID, o.OrderDate, o.ShipName, o.ShipAddress
FROM Orders o
INNER JOIN `Order Details` od ON o.OrderID = od.OrderID
INNER JOIN Products p ON od.ProductID = p.ProductID
WHERE p.ProductName = 'Sasquatch Ale';
