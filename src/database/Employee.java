package database;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private int age;
    private static String patternPw = "[A-Za-z]*[A-Z]+[A-Za-z]*[1-9]+[,<>.';:!@#$%^&*)(_\\-+=]";
    private List<User> userList;

    public Employee(){
        this.userList = new ArrayList<>();
    }

    public Employee(int id, String name, double salary, int age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public void registerUser(String username, String password){
        if(!password.matches(patternPw)){
            System.out.println("\nYour password must have at least" +
                    "\n one upper, lower, numbers and special character : ");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Password : ");
            String pass = scanner.next();
            userList.add(new User(username,pass));
        }
        userList.add(new User(username,password));
    }

    public boolean loginUser(String username, String password){
        for (User user:userList){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
