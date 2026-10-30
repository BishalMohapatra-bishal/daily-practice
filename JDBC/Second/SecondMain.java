package JDBC.Second;

import JDBC.Second.model.User;
import JDBC.Second.repository.UserRepository;

public class SecondMain {

    public static void main(String[] args) {
        
        UserRepository userRepo = new UserRepository();

        userRepo.createUser(new User("Bishal", "Puri"));
        userRepo.createUser(new User("Barasa", "Puriii"));
    }
    
}
