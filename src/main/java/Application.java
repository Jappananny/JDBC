import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import model.City;
import model.Employee;

import java.sql.*;
import java.util.List;

public class Application {


    public static void main(String[] args) throws SQLException {
            EmployeeDao employeeDao = new EmployeeDaoImpl();
            // Создаем объект класса BookDAOImpl

            Employee krivich = new Employee(8, "Святослав", "Вернидубович", "male", 274, 2);
                        // Вызываем метод добавления объекта
            //employeeDao.create(krivich);
            employeeDao.readAll().forEach(System.out::println);
            System.out.println("-------------------------");
            employeeDao.readById(10);
            System.out.println("-------------------------");
            employeeDao.updateAmountById(10,"Йосиф","Бродский","Male",50,1);
            System.out.println(employeeDao.readById(10));
            employeeDao.deleteById(employeeDao.readById(10));
            System.out.println("-------------------------");
            employeeDao.readAll().forEach(System.out::println);
    }


}