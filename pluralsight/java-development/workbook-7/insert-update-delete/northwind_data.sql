-- 1. Add a new supplier.
INSERT INTO Suppliers (SupplierID, CompanyName, ContactName, ContactTitle, Address, City, PostalCode, Country, Phone)
VALUES (30, 'New Supplier', 'John Doe', 'CEO', '123 Main Street', 'New York', '12345', 'USA', '123-456-7890');

-- 2. Add a new product provided by that supplier.
INSERT INTO Products (ProductID, ProductName, SupplierID, CategoryID, UnitPrice)
VALUES (78, 'New Product', 30, 1, 10.00);

-- 3. List all products and their suppliers.
SELECT p.ProductName, s.CompanyName
FROM Products p
LEFT JOIN Suppliers s ON p.SupplierID = s.SupplierID;

-- 4. Raise the price of your new product by 15%.
UPDATE Products
SET UnitPrice = UnitPrice * 1.15
WHERE ProductID = 78;

-- 5. List the products and prices of all products from that supplier.
SELECT ProductName, UnitPrice
FROM Products
WHERE SupplierID = 30;

-- 6. Delete the new product.
DELETE FROM Products
WHERE ProductID = 78;

-- 7. Delete the new supplier.
DELETE FROM Suppliers
WHERE SupplierID = 30;

-- 8. List all products.
SELECT *
FROM Products;

-- 9. List all suppliers.
SELECT *
FROM Suppliers;
