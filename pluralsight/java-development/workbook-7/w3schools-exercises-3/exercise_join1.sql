SELECT *
FROM Orders LEFT JOIN Customers
ON Orders.CustomerID = Customers.CustomerID;