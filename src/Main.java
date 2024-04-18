import database.Employee;
import database.EmployeeService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Welcome to Employee Management System!!!");
        Scanner scanner = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeService();

        do{
            System.out.println("1. Added Employee\n" +
                    "2. Added Employee By User Input\n"+
                    "3. Show All Employee\n" +
                    "4. Show Employee based on ID\n" +
                    "5. Update Employee\n" +
                    "6. Delete Employee\n");

            System.out.print("Enter valid choice : ");
            int ch = scanner.nextInt();
            switch (ch){
                case 1:
                    employeeService.insertEmployee();
                    break;
                case 2:
                    Employee employee = new Employee();
                    System.out.print("Enter Employee Id : ");
                    int EmpId = scanner.nextInt();
                    System.out.print("Enter Employee Name : ");
                    String EmpName = scanner.next();
                    System.out.print("Enter Employee Salary : ");
                    double EmpSalary = scanner.nextDouble();
                    System.out.print("Enter Employee Age : ");
                    int EmpAge = scanner.nextInt();
                    employee.setId(EmpId);
                    employee.setName(EmpName);
                    employee.setSalary(EmpSalary);
                    employee.setAge(EmpAge);
                    employeeService.insertDataByUserInput(employee);
                    break;
                case 3:
                    employeeService.showALLEmployee();
                    break;
                case 4:
                    System.out.print("Enter Id to show the Employee Details : ");
                    int empId = scanner.nextInt();
                    employeeService.showEmployeeBasedOnId(empId);
                    break;
                case 5:
                    System.out.print("Enter Id to update the Employee Details : ");
                    int id = scanner.nextInt();
                    System.out.print("Enter New Employee Name : ");
                    String name = scanner.next();
                    employeeService.updateEmployee(id,name);
                    break;
                case 6:
                    System.out.print("Enter Id to delete the Employee Details : ");
                    int delempId = scanner.nextInt();
                    employeeService.deleteEmployee(delempId);
                    break;
                case 7:
                    System.out.println("Thank you for using our application!!!");
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice : ");
                    break;
            }
        }while (true);
    }
}