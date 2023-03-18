import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import model.City;
import model.Employee;

import java.sql.*;
import java.util.List;

public class Application {


    public static void main(String[] args) throws SQLException {

        // Создаем переменные с данными для подключения к базе
        final String user = "postgres";
        final String pass = "100592";
        final String url = "jdbc:postgresql://localhost:6666/skypro";


        // Создаем соединение с базой с помощью Connection
        // Формируем запрос к базе с помощью PreparedStatement
        try (final Connection connection = DriverManager.getConnection(url, user, pass)) {
            EmployeeDao employeeDao = new EmployeeDaoImpl(connection);
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
            employeeDao.deleteById(11);
            System.out.println("-------------------------");
            employeeDao.readAll().forEach(System.out::println);
        }
    }


}