-- Query 5: Find all dealerships that have a certain car type (i.e. Red Ford Mustang)
SELECT d.*
FROM dealerships d
INNER JOIN inventory i ON d.dealership_id = i.dealership_id
INNER JOIN vehicles v ON i.VIN = v.VIN
WHERE v.make = 'Ford' AND v.model = 'Mustang' AND v.color = 'Red';