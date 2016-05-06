package DBTask;

import java.sql.*;
//123
public class DB {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "Nshsgshs");
        Statement statement = connection.createStatement();
//      statement.executeQuery("create table message(id serial primary key, name text, message text)"); //Создание таблицы с 3-мя полями<--- выполняется 1 раз при 1м запуске, потом не нужно!
//      statement.executeQuery("INSERT INTO message(name, message) VALUES ('name3', 'mess3')"); //Добавление в столбцы name и message соотв. значений

        boolean execute = statement.execute("select * from message");
        if (execute) {
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2) + ": " + resultSet.getString(3));
            }
        }

        statement.executeQuery("INSERT INTO message(name, message) VALUES ('name3', 'mess3')"); //Добавление в столбцы name и message соотв. значений
    }
}
