public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        // Fill in deposit logic
        // Answer: balance += amount;
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        setBalance(balance + amount);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////

    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        // Fill in the withdraw logic and throw exception if necessary
        // Answer:
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        if(amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        setBalance(balance - amount);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
    }
}
