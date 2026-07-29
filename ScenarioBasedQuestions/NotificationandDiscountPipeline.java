package ScenarioBasedQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class User {
    private String name;
    private String email;
    private String membershipTier;
    private double cartTotal;
    private boolean isActive;

    public User(String name, String email, String membershipTier, double cartTotal, boolean isActive) {
        this.name = name;
        this.email = email;
        this.membershipTier = membershipTier;
        this.cartTotal = cartTotal;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMembershipTier() {
        return membershipTier;
    }

    public double getCartTotal() {
        return cartTotal;
    }

    public boolean isActive() {
        return isActive;
    }
    
}

interface UserMethod {
    void processUsers(List<User> listUsers, 
        Predicate<User> predicateUser, 
        Function<User, Double> functionUser, 
        Consumer<User> consumerUser);
}

public class NotificationandDiscountPipeline {
    public static void main(String[] args) {
        User u1 = new User("Bishal Mohapatra", "bishalmohapatra000@gmail.com", "Gold", 10000.00, true);
        User u2 = new User("Barasa Mohapatra", "barasamohapatra001@gmail.com", "Gold", 20000.00, true);
        User u3 = new User("Apple Kumar", "applekumar002@gmail.com", "Silver",9000.00,  false );
        User u4 = new User("Orange Kumari", "orangekumari003@gmail.com", "Bronze", 3000.00, false);

        List<User> userList = new ArrayList<>();
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        userList.add(u4);

    }
}
