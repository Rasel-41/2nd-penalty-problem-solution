public class Runnner {
    public static void main(String[] args) {
        CheckingAccount account = new CheckingAccount(1000.00);


        account.withdraw(1500);
        account.withdraw(500);
        account.deposit(1000);
        account.withdraw(1200);

        System.out.println("Final Balance: $" + account.getBalance());
    }
}


