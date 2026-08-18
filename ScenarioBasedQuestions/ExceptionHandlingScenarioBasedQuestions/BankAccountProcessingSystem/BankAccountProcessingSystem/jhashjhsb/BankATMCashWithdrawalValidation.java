package ScenarioBasedQuestions.ExceptionHandlingScenarioBasedQuestions.BankAccountProcessingSystem.BankAccountProcessingSystem.jhashjhsb;


class InsufficientBalanceException extends Exception{

    public InsufficientBalanceException(String message) {
        super(message);
    }

}

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
           throw new IllegalArgumentException("Withdrawal amount must be greater than zero."); 
        }

        if(amount > balance) {
             throw new InsufficientBalanceException(
                String.format("Transaction declined: Insufficient funds. Available balance: Rs%.2f", balance)    
            );
        }

        balance -= amount;
        System.out.println("Withdrawal sucessful \n Remaining balance Rs" + balance);
    }

}

public class BankATMCashWithdrawalValidation {
  public static void main(String[] args) {
    BankAccount account = new BankAccount("AccNo123", 1000);

    try {
        account.withdraw(500);
    }catch(InsufficientBalanceException in) {
        System.out.println(in.getMessage());
    }

    try {
        account.withdraw(1001);
  } catch (InsufficientBalanceException in) {
        System.out.println(in.getMessage());
  }
}

}