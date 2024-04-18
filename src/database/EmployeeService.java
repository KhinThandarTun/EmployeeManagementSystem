package database;

import java.sql.*;

import static database.MyProjectUtils.URL;
import static database.MyProjectUtils.USER_NAME;

public class EmployeeService implements Employable{
    @Override
    public void insertEmployee() {
        try {
            Connection connection = DriverManager.getConnection(URL,USER_NAME,"");
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into employee values(3,\"SuEi\",20000,24);");
            System.out.println("Employee Inserted Successfully!!!");
            System.out.println("\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertDataByUserInput(Employee employee) {
        try {
            Connection connection = DriverManager.getConnection(URL,USER_NAME,"");
            String sql = "insert into employee values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Set parameters
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setDouble(3,employee.getSalary());
            preparedStatement.setInt(4,employee.getAge());

            // Execute the update
            int resultSet = preparedStatement.executeUpdate();

            if(resultSet > 0){
                System.out.println("Employee Insert Successfully!!!");
                System.out.println("\n");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void showALLEmployee() {
        try {
            Connection connection = DriverManager.getConnection(URL,USER_NAME,"");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from employee");
            System.out.println("Employee Details : ");
            System.out.println("------------------------------------------------");
            System.out.format("%s\t%s\t%s\t%s\t\n","ID","Name","Salary","Age");
            System.out.println("-----------------------------------------------");
            while (resultSet.next()){
                System.out.format("%d\t%s\t%f\t%d\n",
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getInt(4));
            }
            System.out.println("-------------------------------------------------");
            System.out.println("\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void showEmployeeBasedOnId(int id) {
        try {
            Connection connection = DriverManager.getConnection(URL,USER_NAME,"");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from employee where id="+id);
            while (resultSet.next()){
                System.out.format("%d\t%s\t%f\t%d\n",
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getInt(4));
            }
            System.out.println("\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEmployee(int id, String name) {
        try {
            Connection connection = DriverManager.getConnection(URL,USER_NAME,"");
            // Create a PreparedStatement with parameterized query
            String sql = "UPDATE employee SET name = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Set parameters
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);

            // Execute the update
            int resultSet = preparedStatement.executeUpdate();

            // Check the result
            if (resultSet > 0) {
                System.out.println("Employee Update successful! "+id);
            } else {
                System.out.println("No rows updated. Employee with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteEmployee(int id) {
        try {
            Connection connection = DriverManager.getConnection(URL,USER_NAME,"");

            String sql = "delete from employee where id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            // Execute the update
            int resultSet = preparedStatement.executeUpdate();

            // Check the result
            if (resultSet > 0) {
                System.out.println("Employee Deleted successful! "+id);
                System.out.println("\n");
            } else {
                System.out.println("No rows updated. Employee with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
