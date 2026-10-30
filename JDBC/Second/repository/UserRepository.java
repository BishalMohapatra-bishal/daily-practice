package JDBC.Second.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import JDBC.Second.model.User;

public class UserRepository {
    
    String url = "jdbc:mysql://localhost:3306/my_java_jdbcpractice";
    String username = "root";
    String password = "pass2903";

    public void createUser(User user) {
        
        String sql = """
                        INSERT INTO user_jdbc (name, address)
                        VALUES (?, ?)
                     """;
        try (
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getAddress());

            int rowAffected = preparedStatement.executeUpdate();

            if (rowAffected == 1) {
                System.out.println("User created sucessfully");
            } else {
                System.out.println("User creation failed");
            }

        } catch (SQLException e) {

            System.out.println("Connection failed");
            e.printStackTrace();

        }         
    }
}
