package dao;

import model.Employee;

import java.util.List;

public interface EmployeeDao {

    void create(Employee employee);

    Employee readById(int id);

    List<Employee> readAll();

    void updateAmountById(int id, String first_name, String last_name, String gender, int age, int city_id);

    void deleteById(Employee employee);
}

