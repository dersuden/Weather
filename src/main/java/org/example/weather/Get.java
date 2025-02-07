package org.example.weather;


import java.sql.*;

public class Get {
    public void getDay() {
        String url = "jdbc:postgresql://localhost:5432/Weather";
        String user = "Arthur";
        String password = "123";
        String sql = "SELECT * FROM days";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
               int id = resultSet.getInt("id");
               String temperature = resultSet.getString("temperature");
               boolean rainy = resultSet.getBoolean("rainy");
                String info = "Данные из таблицы: " + "\n" + "id= " + id + "\n" + "temperature= " + temperature + "\n" + "is today rainy?: " + rainy;
                System.out.println(info);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
