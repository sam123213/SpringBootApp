create database Springbootapp;

use Springapp;

INSERT INTO employee (name, designation, joining_date, department_id)
VALUES 
('Alice', 'DEVELOPER', '2023-01-15', 1),
('Bob', 'TESTER', '2022-11-01', 1),
('Charlie', 'MANAGER', '2021-06-10', 1),
('Diana', 'HR', '2024-03-05', 2),
('Ethan', 'DEVELOPER', '2023-07-20', 1);

select * from employee;

INSERT INTO department (name, location) VALUES ('IT', 'Pune');
INSERT INTO department (name, location) VALUES ('HR', 'Mumbai');
INSERT INTO department (name, location) VALUES ('Finance', 'Delhi');
INSERT INTO department (name, location) VALUES ('Marketing', 'Bangalore');

select * from department;

INSERT INTO salary (amount, employee_id) 
VALUES 
(55000.00, 6),  
(42000.00, 7),  
(75000.00, 8),  
(48000.00, 9),
(60000.00, 10); 

select * from salary;
