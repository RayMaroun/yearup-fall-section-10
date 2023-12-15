-- Query 2: Find all vehicles for a specific dealership
SELECT v.*
FROM vehicles v
INNER JOIN inventory i ON v.VIN = i.VIN
INNER JOIN dealerships d ON i.dealership_id = d.dealership_id
WHERE d.name = 'Dealership A';