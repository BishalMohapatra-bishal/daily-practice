package ScenarioBasedQuestions;

import java.util.ArrayList;
import java.util.List;

class DigitalWallet {
    
    private String accountHolder;
    private double balance;
    List<String> transactionHistory;

    public DigitalWallet(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void deposit(double amount) {
        if(amount >= 0) {
            balance += amount;
            transactionHistory.add("Deposited: Rs" + amount);
        } else if (amount <= 0) {
            System.out.println("Invalid deposit amount.");  
        } 
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdraw: Rs" + amount);
            return true;
        } else {
            System.out.println("Transaction failed.");
            return false;
        }

    }
    
    public void printStatement() {
        System.out.println("Name of account holder: " + accountHolder + " | Current balance is: Rs" + balance);

        for(String wallet : transactionHistory) {
                System.out.println("- " + wallet);
        }
    }

}

public class DigitalWalletTransactionSystem {
    public static void main(String[] args) {
        DigitalWallet w1 = new DigitalWallet("Bishal Mohapatra", 1000);
        w1.deposit(200);
        w1.withdraw(300);
        w1.withdraw(20000);
        
        w1.printStatement();
    }
    
}
