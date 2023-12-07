-- SQL Script for "Mysterious Bookstore" Database

-- Creating the 'Books' table
CREATE TABLE Books (
    BookID VARCHAR(10) PRIMARY KEY,
    Title VARCHAR(255),
    AuthorID VARCHAR(10),
    CategoryID VARCHAR(10),
    Price DECIMAL(10, 2)
);

-- Creating the 'Authors' table
CREATE TABLE Authors (
    AuthorID VARCHAR(10) PRIMARY KEY,
    Name VARCHAR(255),
    Country VARCHAR(255)
);

-- Creating the 'Categories' table
CREATE TABLE Categories (
    CategoryID VARCHAR(10) PRIMARY KEY,
    CategoryName VARCHAR(255)
);

-- Creating the 'Orders' table
CREATE TABLE Orders (
    OrderID INT PRIMARY KEY,
    BookID VARCHAR(10),
    CustomerID VARCHAR(10),
    Quantity INT,
    OrderDate DATE,
    FOREIGN KEY (BookID) REFERENCES Books(BookID)
);

-- Creating the 'Customers' table
CREATE TABLE Customers (
    CustomerID VARCHAR(10) PRIMARY KEY,
    Name VARCHAR(255),
    Email VARCHAR(255)
);

-- Inserting sample data into 'Books'
INSERT INTO Books (BookID, Title, AuthorID, CategoryID, Price) VALUES
('B101', 'Mystery of the Old Library', 'A01', 'C01', 15.99),
('B102', 'The Lost Treasure', 'A02', 'C02', 9.99),
('B103', 'Adventures in SQL', 'A03', 'C03', 20.50);

-- Inserting sample data into 'Authors'
INSERT INTO Authors (AuthorID, Name, Country) VALUES
('A01', 'John Doe', 'USA'),
('A02', 'Emily Carter', 'UK'),
('A03', 'Alex Smith', 'Canada');

-- Inserting sample data into 'Categories'
INSERT INTO Categories (CategoryID, CategoryName) VALUES
('C01', 'Mystery'),
('C02', 'Adventure'),
('C03', 'Educational');

-- Inserting sample data into 'Orders'
INSERT INTO Orders (OrderID, BookID, CustomerID, Quantity, OrderDate) VALUES
(1, 'B102', 'CU01', 1, '2023-05-15');

-- Inserting sample data into 'Customers'
INSERT INTO Customers (CustomerID, Name, Email) VALUES
('CU01', 'Alice Brown', 'alice.brown@email.com'),
('CU02', 'Bob Johnson', 'bob.johnson@email.com'),
('CU03', 'Emily Carter', 'emily.carter@email.com');

-- The database is now set up with sample data
