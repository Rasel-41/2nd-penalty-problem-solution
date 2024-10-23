public class CheckingAccount {
    private double balance;
    private int overdraftCount;
    private int currentMonth;

    public CheckingAccount(double initialBalance) {
        this.balance = initialBalance;
        this.overdraftCount = 0;
        this.currentMonth = getCurrentMonth();
    }

    private int getCurrentMonth() {
        return java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
    }

    private void checkMonthReset() {
        int month = getCurrentMonth();
        if (month != currentMonth) {
            currentMonth = month;
            overdraftCount = 0;
        }
    }
    public void deposit(double amount) {
        checkMonthReset();
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount + ", New Balance is: $" + balance);
        }
    }
    public void withdraw(double amount) {
        checkMonthReset();
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        balance -= amount;
        System.out.println("Withdrew: $" + amount + ", New Balance: $" + balance);
        if (balance < 0) {
            applyOverdraftPenalty();
        }
    }
    private void applyOverdraftPenalty() {
        overdraftCount++;
        if (overdraftCount == 1) {
            balance -= 20;
            System.out.println("Overdraft!1st Penalty was occured. New Balance: $" + balance);
        } else {
            balance -= 30;
            System.out.println("Overdraft! 2nd Penalty was occured.New Balance is: $" + balance);
        }
    }
    public double getBalance() {
        return balance;
    }
}