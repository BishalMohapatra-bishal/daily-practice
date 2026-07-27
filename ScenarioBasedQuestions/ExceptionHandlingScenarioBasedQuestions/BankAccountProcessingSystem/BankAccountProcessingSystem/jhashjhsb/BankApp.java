package ScenarioBasedQuestions.ExceptionHandlingScenarioBasedQuestions.BankAccountProcessingSystem.BankAccountProcessingSystem.jhashjhsb;

// ----------------------------------------Custom Exception---------------------------------------------
// ----------------------------------------Checked Exception--------------------------------------------
class InsufficientBalanceException extends Exception {
    private final double currentBalance;
    private final double attemptedAmount;
    public InsufficientBalanceException(double currentBalance, double attemptedAmount) {
        super("Insufficient balance! Current: Rs" + currentBalance + ", Attempted: Rs" + attemptedAmount);
        this.currentBalance = currentBalance;
        this.attemptedAmount = attemptedAmount;
    }
    public double getCurrentBalance() {
        return currentBalance;
    }
    public double getAttemptedAmount() {
        return attemptedAmount;
    }
    
}

// ----------------------------------------UnChecked Exception------------------------------------------
class DailyLimitExceededException extends RuntimeException {
    public DailyLimitExceededException(double amount, double limit) {
        super("Transaction denied! Attempted Rs" + amount + " exceeds daily limit of Rs" +limit);
    }
}

class BankAccount {
    private String accountNumber;
    private double balance;
    private static final double DAILY_LIMIT = 100000.00;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }



    public String getAccountNumber() {
        return accountNumber;
    }



    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }



    public double getBalance() {
        return balance;
    }



    public void setBalance(double balance) {
        this.balance = balance;
    }



    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > DAILY_LIMIT) {
            throw new DailyLimitExceededException(amount, DAILY_LIMIT);
        } else if (amount > balance) {
           throw new InsufficientBalanceException(balance, amount);
        } else {
            balance -= amount;
            System.out.println("successfully Withdrawal Rs:"+ amount + "\nRemaining balance: " + balance);
        }
    }
}

public class BankApp {
    public static void processWithdrawal(BankAccount account, double amount) {
        System.out.println("\n--- Initiating withdrawal of Rs" + amount + " ---");
        try {
            account.withdraw(amount);
        } catch (InsufficientBalanceException e) {
            System.err.println("[CHECKED ERROR] " + e.getMessage());
        } catch (DailyLimitExceededException e) {
            System.err.println("[UNCHECKED ERROR] " + e.getMessage());
        } catch (Exception e) {
            System.err.println("[GENERIC ERROR] Unchecked error: " + e.getMessage());
        } finally {
            System.out.println("[AUDIT LOG] Transaction processing finished for Account: " + account.getAccountNumber());
        }
    }
     public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("acc1234", 20000.00);
        BankAccount acc2 = new BankAccount("acc1235", 15000.00);
        BankAccount acc3 = new BankAccount("acc1236", 22000.00);

        processWithdrawal(acc1, 9900.00);

        processWithdrawal(acc2, 21000.00);

        processWithdrawal(acc3, 110000.00);
    } 
}