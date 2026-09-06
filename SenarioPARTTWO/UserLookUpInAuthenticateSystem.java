package SenarioPARTTWO;

import java.util.Arrays;
import java.util.List;

class User {

    private int id;
    private String name;
    private String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

class UserService {

    public String findUserNameByEmail(List<User> users, String searchEmail) {
        if (users == null || searchEmail == null) {
            return "User Not Found";
        }

        return users.stream()
        .filter(user -> user.getEmail().equalsIgnoreCase(searchEmail))
        .map(User::getName)
        .findFirst()
        .orElse("User Not Found");
    }
}

public class UserLookUpInAuthenticateSystem {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
            new User(1, "Bishal", "bishal@gmail.com"),
            new User(2, "Amit", "amit@gmail.com")
        );

        UserService service = new UserService();

        String name1 = service.findUserNameByEmail(users, "BISHAL@GMAIL.COM");
        System.out.println("Result 1: " + name1);

        String name2 = service.findUserNameByEmail(users, "Emily@gmail.com");
        System.out.println("Result 2: " + name2);
    }
    
}
