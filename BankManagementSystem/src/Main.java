import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);
        int accountNumber;
        double amount;
        do {
            System.out.println("Welcome To the bank");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter a Choice(1-4) :- ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number :- ");
                    accountNumber = sc.nextInt();
                    System.out.print("Enter Initial Balance :- ");
                    double balance = sc.nextDouble();
                    System.out.print("Do you want overdraft protection? (yes/no) :- ");
                    String hasOverDraft = sc.next();
                    boolean overDraft = hasOverDraft.equalsIgnoreCase("yes");
                    Account account = new Account(accountNumber, balance, overDraft);
                    bank.addAccount(account);
                    System.out.println("Account Created Successfully");
                    break;
                case 2:
                    System.out.print("Enter Account Number :- ");
                    accountNumber = sc.nextInt();
                    System.out.print("Enter Amount to Deposit :- ");
                    amount = sc.nextDouble();
                    Account account1 = bank.getAccount(accountNumber);
                    if (account1 != null) {
                        account1.deposit(amount);
                        System.out.println("Amount Deposited Successfully");
                    } else {
                        System.out.println("Account Not Found");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account Number :- ");
                    accountNumber = sc.nextInt();
                    System.out.print("Enter Amount to Withdraw :- ");
                    amount = sc.nextDouble();
                    Account account2 = bank.getAccount(accountNumber);
                    if (account2 != null) {
                        account2.withdraw(amount);
                        System.out.println("Amount Withdrawn Successfully");
                    } else {
                        System.out.println("Account Not Found");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account Number :- ");
                    accountNumber = sc.nextInt();
                    Account account3 = bank.getAccount(accountNumber);
                    if (account3 != null) {
                        System.out.println("Balance :- " + account3.getBalance());
                    } else {
                        System.out.println("Account Not Found");
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using the bank");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        } while (true);
    }
}
