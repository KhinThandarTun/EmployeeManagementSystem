package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertEmployee {
    static void insert(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","");
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into employee values(1,\"Su War\",20000,24);");
            System.out.println("success");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        insert();
    }
}
