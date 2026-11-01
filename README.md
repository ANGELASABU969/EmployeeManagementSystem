# Employee Management System

A console-based Employee Management System developed using **Java, JDBC, and MySQL**. This application allows users to manage employee records through a simple menu-driven interface, with data stored persistently in a MySQL database.

## Features

- **Add Employee:** Add new employee records to the database.
- **View Employees:** Display all stored employee details.
- **Search Employee:** Find an employee using their ID.
- **Update Employee:** Modify existing employee information.
- **Delete Employee:** Remove employee records from the database.
- **Database Integration:** Store and retrieve employee information using JDBC and MySQL.

## Technologies Used

- Java
- MySQL
- JDBC (Java Database Connectivity)
- MySQL Connector/J
- Visual Studio Code

## Project Structure

```text
EmployeeManagementSystem/
│
├── .vscode/
│   └── settings.json
│
├── lib/
│   └── mysql-connector-j-26.7.0.jar
│
├── Employee.java
├── EmployeeManager.java
├── Main.java
├── DatabaseConnection.java
├── DatabaseTest.java
└── README.md
```

## Database Configuration

1. Install MySQL Server and MySQL Workbench.
2. Create a database named `employee_management`.
3. Create the `employees` table using the following SQL query:

```sql
CREATE DATABASE employee_management;

USE employee_management;

CREATE TABLE employees (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(100),
    salary DOUBLE,
    email VARCHAR(150)
);
```

## Database Connection

The application uses JDBC to connect Java with MySQL.

Update the database password configuration using a Windows environment variable named `DB_PASSWORD`.

The application reads the password using:

```java
System.getenv("DB_PASSWORD");
```

Make sure the environment variable is configured before running the application. Do not store your actual database password in the source code.

## How to Run

1. Clone or download this repository.
2. Open the project folder in Visual Studio Code.
3. Ensure that Java JDK and MySQL Server are installed.
4. Configure the MySQL database and `DB_PASSWORD` environment variable.
5. Ensure that the MySQL Connector/J JAR is included in the project's referenced libraries.
6. Run `Main.java`.
7. Use the console menu to perform employee management operations.

## Learning Outcomes

Through this project, I gained practical experience in:

- Java object-oriented programming.
- JDBC connectivity.
- MySQL database operations.
- Implementing CRUD (Create, Read, Update, Delete) functionality.
- Handling database connections and SQL queries using PreparedStatement.

---

**Developed as a Java portfolio project.**