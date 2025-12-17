import java.lang.IllegalArgumentException;
public class BankAccount {
    private double balance;

    public BankAccount() {
        balance = 100;
    }

    public void withdraw(double amount) {

        if (balance - amount < 0) {
            throw new IllegalArgumentException("You're broke dumb shit");
        
        }

        if (amount < 0) {
            throw new IllegalArgumentException("No negatives");
        }
        balance -= amount;
    }
}