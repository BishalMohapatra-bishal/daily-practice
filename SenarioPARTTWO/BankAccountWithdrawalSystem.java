package SenarioPARTTWO;

class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {

    double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance in your account to withdraw requested amount! Current balance is Rs" + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: Rs" + balance);
        }
    }
}

public class BankAccountWithdrawalSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount(500);

        try {
            acc1.withdraw(250);
        } catch(InsufficientBalanceException ie) {
            ie.getMessage();
        } finally {
            System.out.println("Transaction completed.");
        }

        try {
            acc1.withdraw(600);
        } catch(InsufficientBalanceException iee) {
            iee.getMessage();
        } finally {
            System.out.println("Transaction completed.");
        }

        
    }


}
