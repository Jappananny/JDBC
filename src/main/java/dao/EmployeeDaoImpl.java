package dao;

import model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    private final Connection connection;
    public EmployeeDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Employee employee) {

        // Формируем запрос к базе с помощью PreparedStatement
        try(PreparedStatement statement = connection.prepareStatement(Requests.INSERT.requests)) {

            // Подставляем значение вместо wildcard
            // первым параметром указываем порядковый номер wildcard
            // вторым параметром передаем значение
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCityId());
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Employee readById(int id) {
        Employee employee = new Employee();
        // Формируем запрос к базе с помощью PreparedStatement
try (PreparedStatement statement = connection.prepareStatement(Requests.ID.requests)) {
            // Подставляем значение вместо wildcard
            statement.setInt(1, id);
            // Делаем запрос к базе и результат кладем в ResultSet
            ResultSet resultSet = statement.executeQuery();
            // Методом next проверяем есть ли следующий элемент в resultSet
            // и одновременно переходим к нему, если таковой есть
            while(resultSet.next()) {
                // С помощью методов getInt и getString получаем данные из resultSet
                // и присваиваем их полим объекта
                employee.setId(resultSet.getInt("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setGender(resultSet.getString("gender"));
                employee.setAge(resultSet.getInt("age"));
                employee.setCityId(resultSet.getInt("city_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
    @Override
    public List<Employee> readAll() {
        // Создаем список, в который будем укладывать объекты
        List<Employee> employeesList = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement(Requests.GET_ALL.requests)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                int cityId = resultSet.getInt("city_id");
                // Создаем объекты на основе полученных данных
                // и укладываем их в итоговый список
                employeesList.add(new Employee(id, firstName, lastName, gender,age,cityId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeesList;
    }
    @Override
    public void updateAmountById(int id, String firstName, String lastName, String gender, int age, int cityId) {
        try (PreparedStatement statement = connection.prepareStatement(
                Requests.UPDATE.requests)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, gender);
            statement.setInt(4,  age);
            statement.setInt(5, cityId);
            statement.setInt(6, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteById(int id) {
        try(PreparedStatement statement = connection.prepareStatement(
        Requests.DELETE.requests)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

