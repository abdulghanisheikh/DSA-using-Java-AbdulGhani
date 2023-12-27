import java.util.*;
class LessBalanceException extends Exception {
    LessBalanceException(String msg) {
        System.out.println(msg);
    }
}
class Account {
    private static final double minBalance = 500;
    private double balance;

    public void deposit(double amount) {
        balance = minBalance + amount;
        System.out.println("amount deposit: " + amount + " | Balance: " + balance);
    }

    public void withdraw(double amount) throws LessBalanceException {
        if((balance - amount) < minBalance) {
            throw new LessBalanceException("withdraw amount " + amount + " is not valid");
        }
        else {
            balance = balance - amount;
            System.out.println("Balance left: " + balance);
        }
    }
}
public class ExceptionHandling {
    public static void main(String[] args) {
        Account account1 = new Account();
        try {
            account1.deposit(1000);
            account1.withdraw(1200);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}