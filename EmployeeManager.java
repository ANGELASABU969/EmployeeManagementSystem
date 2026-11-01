import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeManager {

    public void addEmployee(Employee employee) {

        String sql = "INSERT INTO employees (id, name, department, salary, email) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getName());
            statement.setString(3, employee.getDepartment());
            statement.setDouble(4, employee.getSalary());
            statement.setString(5, employee.getEmail());

            statement.executeUpdate();

            System.out.println("Employee added successfully.");

        } catch (Exception e) {
            System.out.println("Error adding employee.");
            e.printStackTrace();
        }
    }


    public void viewEmployees() {

        String sql = "SELECT * FROM employees";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            if (!result.next()) {
                System.out.println("No employees found.");
                return;
            }

            do {
                System.out.println("----------------------");
                System.out.println("ID: " + result.getInt("id"));
                System.out.println("Name: " + result.getString("name"));
                System.out.println("Department: " + result.getString("department"));
                System.out.println("Salary: " + result.getDouble("salary"));
                System.out.println("Email: " + result.getString("email"));
            } while (result.next());

            System.out.println("----------------------");

        } catch (Exception e) {
            System.out.println("Error viewing employees.");
            e.printStackTrace();
        }
    }


    public void searchEmployee(int id) {

        String sql = "SELECT * FROM employees WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            if (result.next()) {

                System.out.println("----------------------");
                System.out.println("ID: " + result.getInt("id"));
                System.out.println("Name: " + result.getString("name"));
                System.out.println("Department: " + result.getString("department"));
                System.out.println("Salary: " + result.getDouble("salary"));
                System.out.println("Email: " + result.getString("email"));
                System.out.println("----------------------");

            } else {
                System.out.println("Employee not found.");
            }

        } catch (Exception e) {
            System.out.println("Error searching employee.");
            e.printStackTrace();
        }
    }


    public void updateEmployee(int id, String name,
                               String department, double salary,
                               String email) {

        String sql = "UPDATE employees SET name = ?, department = ?, "
                   + "salary = ?, email = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            statement.setString(2, department);
            statement.setDouble(3, salary);
            statement.setString(4, email);
            statement.setInt(5, id);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Employee updated successfully.");
            } else {
                System.out.println("Employee not found.");
            }

        } catch (Exception e) {
            System.out.println("Error updating employee.");
            e.printStackTrace();
        }
    }


    public void deleteEmployee(int id) {

        String sql = "DELETE FROM employees WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Employee deleted successfully.");
            } else {
                System.out.println("Employee not found.");
            }

        } catch (Exception e) {
            System.out.println("Error deleting employee.");
            e.printStackTrace();
        }
    }
}