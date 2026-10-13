package JDBC.First;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import JDBC.First.model.Student;
import JDBC.First.repository.StudentRepository;

public class Main {
    public static void main(String[] args) {
        StudentRepository repository = new StudentRepository();
        repository.createUser(new Student("Rohit", "rohit@gmail.com", 21));

        // repository.updateUser();

        // repository.deleteUser();

        // repository.getUserById();
        // try {
        //     Class.forName("com.mysql.cj.jdbc.Driver");
        //     System.out.println("Found");
        // } catch (ClassNotFoundException e) {
        //     System.out.println("Not found");
        //     e.printStackTrace();
        // }
    }
    
}
