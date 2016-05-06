package DBTask;

import java.sql.*;

public class DBForChat {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "Nshsgshs");
        //Connection connection = DriverManager.getConnection("jdbc:postgresql://АДРЕС/НАЗВАНИЕ БД", "ИМЯ ПОЛЬЗОВАТЕЛЯ", "ПАРОЛЬ");
        Statement statement = connection.createStatement();   //statement - отправка запроса
        statement.executeQuery("create table chat(id serial primary key, name text, message text)");   //  <----Создание таблицы  для чата
//        statement.executeQuery("INSERT INTO chat(name, message) VALUES ('name3', 'mess3')"); //Добавление в столбцы name и message соотв. значений
/*
        boolean execute = statement.execute("select * from chat");
        if (execute) {
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2) + ": " + resultSet.getString(3));
            }
        }
*/





    }
}
