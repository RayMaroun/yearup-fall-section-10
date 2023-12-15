-- Step 1: Drop the database if it exists
DROP DATABASE IF EXISTS car_dealership;

-- Step 2: Create the database
CREATE DATABASE car_dealership;

-- Step 3: Use the database
USE car_dealership;

-- Step 4: Create the tables

-- Table 1: dealerships
CREATE TABLE dealerships (
    dealership_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    address VARCHAR(50),
    phone VARCHAR(12)
);

-- Table 2: vehicles
CREATE TABLE vehicles (
    VIN VARCHAR(17) PRIMARY KEY,
    make VARCHAR(50),
    model VARCHAR(50),
    year INT,
    SOLD BOOLEAN,
    color VARCHAR(50),
    vehicleType VARCHAR(50),
    odometer INT,
    price DOUBLE
);

-- Table 3: inventory
CREATE TABLE inventory (
    dealership_id INT,
    VIN VARCHAR(17),
    FOREIGN KEY (dealership_id) REFERENCES dealerships(dealership_id),
    FOREIGN KEY (VIN) REFERENCES vehicles(VIN)
);

-- Table 4: sales_contracts
CREATE TABLE sales_contracts (
    contract_id INT AUTO_INCREMENT PRIMARY KEY,
    VIN VARCHAR(17),
    sale_date DATE,
    price DECIMAL(10, 2),
    FOREIGN KEY (VIN) REFERENCES vehicles(VIN)
);

-- Table 5: lease_contracts
CREATE TABLE lease_contracts (
    contract_id INT AUTO_INCREMENT PRIMARY KEY,
    VIN VARCHAR(17),
    lease_start DATE,
    lease_end DATE,
    monthly_payment DECIMAL(10, 2),
    FOREIGN KEY (VIN) REFERENCES vehicles(VIN)
);

-- Step 5: Populate the tables with sample data

-- Insert sample dealerships
INSERT INTO dealerships (name, address, phone)
VALUES
    ('Dealership A', '123 Main Street', '123-456-7890'),
    ('Dealership B', '456 Elm Street', '987-654-3210'),
    ('Dealership C', '789 Oak Street', '555-555-5555');

-- Insert sample vehicles
INSERT INTO vehicles (VIN, make, model, year, SOLD, color, vehicleType, odometer, price)
VALUES
    ('1HGCM82633A123456', 'Honda', 'Accord', 2010, TRUE, 'Silver', 'Sedan', 50000, 15000.00),
    ('2G1WF52E859123456', 'Chevrolet', 'Impala', 2005, TRUE, 'Red', 'Sedan', 80000, 12000.00),
    ('3VWFA81H3WM123456', 'Ford', 'Mustang', 2012, TRUE, 'Red', 'Coupe', 60000, 18000.00),
    ('4T1BF1FK0CU123456', 'Toyota', 'Camry', 2012, TRUE, 'White', 'Sedan', 70000, 16000.00),
    ('5YJSA1DN2DFP12345', 'Tesla', 'Model S', 2013, TRUE, 'Blue', 'Sedan', 30000, 25000.00),
    ('6G2VX12G84L123456', 'Pontiac', 'GTO', 2004, FALSE, 'Yellow', 'Coupe', 90000, 12000.00),
    ('7J3SY16123C123456', 'Mazda', 'Miata', 2008, FALSE, 'Green', 'Convertible', 75000, 10000.00),
    ('8D1JA1K5J0Y123456', 'Nissan', 'Altima', 2015, FALSE, 'Gray', 'Sedan', 40000, 14000.00),
    ('9E2SK12153S123456', 'BMW', '3 Series', 2017, FALSE, 'Silver', 'Sedan', 20000, 28000.00),
    ('1P3ES22Y6VD123456', 'Plymouth', 'Breeze', 1997, FALSE, 'Red', 'Sedan', 120000, 3000.00),
    ('2B3CJ5CT2AH123456', 'Dodge', 'Charger', 2010, FALSE, 'Black', 'Sedan', 80000, 11000.00),
    ('3W7DK72C32G123456', 'Subaru', 'Impreza', 2002, FALSE, 'Blue', 'Hatchback', 100000, 7000.00),
    ('4S4BRCKC1D3P12345', 'Suzuki', 'Grand Vitara', 2013, FALSE, 'Silver', 'SUV', 60000, 13000.00),
    ('5R2CU18163G123456', 'Kia', 'Sorento', 2006, FALSE, 'Green', 'SUV', 90000, 9000.00),
    ('6MCDJ2AB0AH123456', 'Mercedes-Benz', 'C-Class', 2010, FALSE, 'Gray', 'Sedan', 70000, 19000.00),
    ('7F7YE17104D123456', 'Lexus', 'RX 350', 2015, FALSE, 'Silver', 'SUV', 40000, 24000.00),
    ('8K1FJ1K9A1W123456', 'Jeep', 'Wrangler', 2012, FALSE, 'Black', 'SUV', 80000, 18000.00),
    ('9A4DH2CG2D1P12345', 'Audi', 'A4', 2018, FALSE, 'Blue', 'Sedan', 30000, 27000.00),
    ('1B2VC12G34A123456', 'Volkswagen', 'Jetta', 2011, FALSE, 'Silver', 'Sedan', 70000, 14000.00),
    ('2C3AJ56G65H123456', 'Chrysler', '300', 2006, FALSE, 'Red', 'Sedan', 90000, 8000.00);

-- Insert sample inventory
INSERT INTO inventory (dealership_id, VIN)
VALUES
    (1, '1HGCM82633A123456'),
    (2, '2G1WF52E859123456'),
    (1, '3VWFA81H3WM123456'),
    (3, '4T1BF1FK0CU123456'),
    (1, '5YJSA1DN2DFP12345'),
    (1, '6G2VX12G84L123456'),
    (2, '7J3SY16123C123456'),
    (3, '8D1JA1K5J0Y123456'),
    (1, '9E2SK12153S123456'),
    (2, '1P3ES22Y6VD123456'),
    (3, '2B3CJ5CT2AH123456'),
    (1, '3W7DK72C32G123456'),
    (2, '4S4BRCKC1D3P12345'),
    (3, '5R2CU18163G123456'),
    (1, '6MCDJ2AB0AH123456'),
    (2, '7F7YE17104D123456'),
    (3, '8K1FJ1K9A1W123456'),
    (1, '9A4DH2CG2D1P12345'),
    (2, '1B2VC12G34A123456'),
    (3, '2C3AJ56G65H123456');

-- Insert sample sales contracts
INSERT INTO sales_contracts (VIN, sale_date, price)
VALUES
    ('1HGCM82633A123456', '2023-01-15', 15000.00),
    ('2G1WF52E859123456', '2023-03-20', 12000.00),
    ('3VWFA81H3WM123456', '2023-05-10', 18000.00),
    ('4T1BF1FK0CU123456', '2023-02-01', 16000.00),
    ('5YJSA1DN2DFP12345', '2023-04-15', 25000.00);

-- Insert sample lease contracts
INSERT INTO lease_contracts (VIN, lease_start, lease_end, monthly_payment)
VALUES
    ('6G2VX12G84L123456', '2023-03-02', '2024-03-01', 400.00),
    ('7J3SY16123C123456', '2023-05-20', '2024-05-19', 350.00),
    ('8D1JA1K5J0Y123456', '2023-06-10', '2024-06-09', 500.00);
