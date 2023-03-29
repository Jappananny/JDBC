package dao;

import model.Employee;

import java.util.List;

public interface EmployeeDao {

    void create(Employee employee);

    Employee readById(int id);

    List<Employee> readAll();

    void updateAmountById(Employee employee);

    void deleteById(Employee employee);
}

