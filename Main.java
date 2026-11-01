import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();

        int choice;

        do {

            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            
                case 1:

                    System.out.print("Enter employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter employee name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    Employee employee = new Employee(
                        id, name, department, salary, email
                    );

                    manager.addEmployee(employee);

                    break;
                    

                case 2:
                    manager.viewEmployees();
                    break;

                
                case 3:

                    System.out.print("Enter employee ID to search: ");
                    int searchId = sc.nextInt();

                    manager.searchEmployee(searchId);

                    break;
                

                case 4:

                    System.out.print("Enter employee ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter new department: ");
                    String newDepartment = sc.nextLine();

                    System.out.print("Enter new salary: ");
                    double newSalary = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter new email: ");
                    String newEmail = sc.nextLine();

                    manager.updateEmployee(
                        updateId,
                        newName,
                        newDepartment,
                        newSalary,
                        newEmail
                    );

                    break;

                case 5:

                    System.out.print("Enter employee ID to delete: ");
                    int deleteId = sc.nextInt();

                    manager.deleteEmployee(deleteId);

                    break;

                case 6:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}