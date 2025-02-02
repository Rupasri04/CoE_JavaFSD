import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited: " + amount + ". Current balance: " + balance);
        }
    }

    public synchronized void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: " + amount + ". Current balance: " + balance);
        } else if (amount > 0 && balance < amount) {
            System.out.println(Thread.currentThread().getName() + " attempted to withdraw: " + amount + ". Insufficient funds.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class DepositThread extends Thread {
    private BankAccount account;
    private double amount;

    public DepositThread(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.deposit(amount);
    }
}

class WithdrawThread extends Thread {
    private BankAccount account;
    private double amount;

    public WithdrawThread(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(amount);
    }
}

public class BankingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter initial balance for the account *****:");
        double initialBalance = scanner.nextDouble();
        BankAccount account = new BankAccount(initialBalance);

        System.out.println("Enter the number of deposit and withdrawal operations *****:");
        int n = scanner.nextInt();
        scanner.nextLine();  

        for (int i = 0; i < n; i++) {
            System.out.println("Enter operation type (deposit/withdraw)*****:");
            String operation = scanner.nextLine();

            System.out.println("Enter amount*****:");
            double amount = scanner.nextDouble();
            scanner.nextLine();  

            if (operation.equalsIgnoreCase("deposit")) {
                DepositThread depositThread = new DepositThread(account, amount);
                depositThread.start();
            } else if (operation.equalsIgnoreCase("withdraw")) {
                WithdrawThread withdrawThread = new WithdrawThread(account, amount);
                withdrawThread.start();
            }
        }

        scanner.close();
    }
}
