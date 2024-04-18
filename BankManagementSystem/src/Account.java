public class Account {
    private final int accountNumber;
    private double balance;
    private final boolean hasOverDraft;
    public Account(int accountNumber, double balance, boolean hasOverDraft) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.hasOverDraft = hasOverDraft;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount || hasOverDraft) {
            balance -= amount;
            if (balance < 0) {
                System.out.println("You have overdrafted. Your balance is now negative and considered as a loan.");
            }
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public boolean hasOverDraft() {
        return hasOverDraft;
    }
}
