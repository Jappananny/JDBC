package dao;

public enum Requests {
    GET_ALL("SELECT * FROM employee INNER JOIN city ON employee.city_id=city.city_id"),
    INSERT("INSERT INTO employee(first_name, last_name, gender, age, city_id) VALUES ((?), (?), (?), (?), (?))"),
    DELETE("DELETE FROM employee WHERE id=(?)"),
    UPDATE("UPDATE employee SET first_name=?, last_name=?, gender=?, age=?, city_id=? WHERE id=?"),
    ID("SELECT * FROM employee WHERE id = ?");

    String requests;

    Requests(String requests) {
        this.requests = requests;
    }
}
