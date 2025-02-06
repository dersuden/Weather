package org.example.weather;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WeatherDatabase {
    public void addDay(int id, String temperature, boolean rainy) {
        String url = "jdbc:postgresql://localhost:5432/Weather";
        String user = "Arthur";
        String password = "123";
        String sql = "INSERT INTO days(id, temperature, rainy) " +
                "VALUES (?,?,?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, temperature);
            pstmt.setBoolean(3, rainy);
            pstmt.executeUpdate();
            System.out.println("Данные добавлены");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
