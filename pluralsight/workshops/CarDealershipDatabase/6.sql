-- Query 6: Get all sales information for a specific dealer for a specific date range
SELECT s.*
FROM sales_contracts s
INNER JOIN vehicles v ON s.VIN = v.VIN
INNER JOIN inventory i ON v.VIN = i.VIN
INNER JOIN dealerships d ON i.dealership_id = d.dealership_id
WHERE d.dealership_id = 1 AND s.sale_date BETWEEN '2023-01-01' AND '2023-12-31';