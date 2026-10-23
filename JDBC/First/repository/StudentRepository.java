package JDBC.First.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import JDBC.First.model.Student;

public class StudentRepository {

    String url = "jdbc:mysql://localhost:3306/student_db";
    String username = "root";
    String password = "pass2903";

    Connection connection = null;
    PreparedStatement preparedStatement;

    public void createUser(Student student) {

        String sql = """
                    INSERT INTO student (name, email, age)
                    VALUES(?, ?, ?)
                    """;

        try(
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            

            // Statement statement = connection.createStatement();
            // int result = statement.executeUpdate(sql);
            // if (result == 1) {
            //     System.out.println("Create operation successful");
            // } else {
            //     System.out.println("Creation failed");
            // }

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getAge());

            // int rowAffected = preparedStatement.executeUpdate(sql);  dont pass sql as argument in preparedStatement here
            // executeUpdate() this method use for --> CREATE, UPDATE, DELETE 
            int rowAffected = preparedStatement.executeUpdate();

            if (rowAffected == 1) {
                System.out.println("Create student successful");
            } else {
                System.out.println("Create student failed");
            }

            // connection.close();
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }

    public void updateUser(Student student, Long id) {

        String sql = """
                UPDATE student
                SET name = ?,
                    email = ?,
                    age = ?
                WHERE id = ?
                """;
        try(
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setLong(4, id);


            // int rowAffected = preparedStatement.executeUpdate(sql); //Remove sql as parameter
            int rowAffected = preparedStatement.executeUpdate();

            if (rowAffected == 1) {
                System.out.println("update operation sucessful");
            } else {
                System.out.println("Updation failed");
            }

        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }

    public void deleteUser(Long id) {
        String sql = """
                    // DELETE from student " + "WHERE id = ?
                    DELETE from student 
                    WHERE id = ? 
                    """;
        try(
            Connection connection = DriverManager.getConnection(url, username, password);

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setLong(1, id);
            
            // int rowAffected = preparedStatement.executeUpdate(sql); remove sql as parameter here
            int rowAffected = preparedStatement.executeUpdate(sql);
            if (rowAffected == 1) {
                System.out.println("Deletion sucessful");
            } else {
                System.out.println("Deletion failed");
            }

        } catch (SQLException e) {
            System.out.println("connection failed");
            e.printStackTrace();
        }
    }

    public void getUserById(Long id) {

        String sql = """
                SELECT id, name, email, age FROM student 
                WHERE id = ?
                """;
        try(
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setLong(1, id);

            // try(ResultSet resultSet = preparedStatement.executeQuery(sql)) { Remove sql as query from here as well
            // executeQuery() --> This method is use to READ(SELECT) Operations
            try(ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                 Student student = mapRow(resultSet);
                 System.out.println(student);  
             }

            }
        } catch(SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }

    public  void completeCRUD() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String sql = "SELECT id, name, email, age " + 
            "FROM student where id = 2";

            // execute() --> General purpose (CRUD) 
            boolean result = statement.execute(sql);

            if (result) {
                ResultSet resultSet = statement.getResultSet();                
            } else {
                int rowAffected = statement.getUpdateCount();
            }
        } catch(SQLException e) {
            System.out.println("Connection failed"); 
            e.printStackTrace();
        }
    }

    private Student mapRow(ResultSet resultSet) throws SQLException {
        Student student = new Student();

        student.setId(resultSet.getLong("id"));
        student.setName(resultSet.getString("name"));
        student.setEmail(resultSet.getString("email"));
        student.setAge(resultSet.getInt("age"));

        return student;
    }

}
