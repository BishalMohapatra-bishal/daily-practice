package JDBC.First;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student_db";
        String username = "root";
        String password = "pass2903";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {

        }
    }
    
}
