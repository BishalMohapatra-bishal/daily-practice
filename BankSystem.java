package TheConstructionChainReaction;

class Account {
    public Account(String id) {
        System.out.println("Account Initialized");
    }
}
class SavingsAccount extends Account {
    public SavingsAccount() {
        super("34567");
        System.out.println("SavingsAccount Initialized");
    }
}

public class BankSystem {
    public static void main(String[] args) {
        new SavingsAccount();
    }
}

