package database;

public interface Employable {
    public void insertEmployee();

    public void insertDataByUserInput(Employee employee);

    public void showALLEmployee();

    public void showEmployeeBasedOnId(int id);

    public void updateEmployee(int id, String name);

    public void deleteEmployee(int id);
}
