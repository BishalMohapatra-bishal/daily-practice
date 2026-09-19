package JAVA8AllFeatures;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class UserAccount {
    private String userName;
    private  boolean isActive;
    private boolean isEmailVerified;
    private int failedLoginAttempts;

    public UserAccount(String userName, boolean isActive, boolean isEmailVerified, int failedLoginAttempts) {
        this.userName = userName;
        this.isActive = isActive;
        this.isEmailVerified = isEmailVerified;
        this.failedLoginAttempts = failedLoginAttempts;
    }

    public String getUserName() {
        return userName;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public boolean getIsEmailVerfied() {
        return isEmailVerified;
    }

    public int getFailedLoginAttempts() {
        return failedLoginAttempts;
    }
}

class SecurityService {
    private final Predicate<UserAccount> isActivPredicate = UserAccount::getIsActive;
    private final Predicate<UserAccount> isEmailVerifiedPredicate = UserAccount::getIsEmailVerfied;
    private final Predicate<UserAccount> isNotLockedPredicate = user -> user.getFailedLoginAttempts() < 3;

    private final Predicate<UserAccount> eligibleForAccess = isActivPredicate
            .and(isEmailVerifiedPredicate)
            .and(isNotLockedPredicate);

    public List<UserAccount> filterEligibleUsers(List<UserAccount> users) {
        if (users == null) {
            return List.of();
        }

        return users.stream()
                    .filter(eligibleForAccess)
                    .collect(Collectors.toList());
    }
}
public class UserAccoutSecurityFilter {
    public static void main(String[] args) {
        List<UserAccount> accounts = List.of(
            new UserAccount("bishal_dev", true, true, 0),
            new UserAccount("guest_user", true, false, 1),
            new UserAccount("locked_admin", true, true, 5)
        );

        SecurityService service = new SecurityService();
        List<UserAccount> eligible = service.filterEligibleUsers(accounts);

        System.out.println("Eligible UserName:");
        eligible.forEach(acc -> System.out.println("_ " + acc.getUserName()));
    }   
}
