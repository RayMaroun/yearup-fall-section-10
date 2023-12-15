-- Query 4: Find the dealership where a certain car is located, by VIN
SELECT d.*
FROM dealerships d
INNER JOIN inventory i ON d.dealership_id = i.dealership_id
WHERE i.VIN = '1HGCM82633A123456';